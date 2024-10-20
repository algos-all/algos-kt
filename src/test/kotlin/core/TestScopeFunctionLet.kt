package core

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class TestScopeFunctionLet {

    @Test
    fun testLetMainUseCase() {
        data class Node(var key: String, var top: Node?, var lft: Node?, var rgt: Node?)

        val root = Node("root", null, null, null)
        val lft = Node("lft", root, null, null)
        val rgt = Node("rgt", root, null, null)

        root.lft = lft
        root.rgt = rgt

        val lResult = root.lft?.let {
            lft.top = root
            println("root node has a left child")
        }

        val rResult = root.rgt?.let {
            rgt.top = root
            println("root node has a right child")
        }

        assert(lResult == rResult)
    }
}