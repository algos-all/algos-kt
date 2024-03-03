package core

import org.junit.jupiter.api.Test

class TestListMinus {
    @Test
    fun testListMinus() {
        // Given a list:
        val xs = listOf(1, 2, 3, 2, 4, 2)

        // Q: What is the result of the following code? What are the contents of both lists?
        val ys = xs - listOf(2)

        assert(xs == listOf(1, 2, 3, 2, 4, 2))
        assert(ys == listOf(1, 3, 4))
    }

    @Test
    fun testListMinusAssign() {
        // Given a list:
        var xs = listOf(1, 2, 3, 2, 4, 2)

        // Q: What is the result of the following code? Why does it work?
        xs -= listOf(2)

        assert(xs == listOf(1, 3, 4))
    }

    @Test
    fun testMutableListMinusAssign() {
        // Given a list:
        val xs = mutableListOf(1, 2, 3, 2, 4, 2)

        // Q: What is the result of the following code?
        xs -= listOf(2)

        assert(xs == listOf(1, 3, 4))
    }
}