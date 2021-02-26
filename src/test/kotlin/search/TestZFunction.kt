package search

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestZFunction {
    @Test
    fun `string a`() {
        assert(zFunction("a").contentEquals(intArrayOf(1)))
    }

    @Test
    fun `string aa`() {
        assert(zFunction("aa").contentEquals(intArrayOf(2, 1)))
    }

    @Test
    fun `string aaa`() {
        assert(zFunction("aaa").contentEquals(intArrayOf(3, 2, 1)))
    }

    @Test
    fun `string aaaa`() {
        assert(zFunction("aaaa").contentEquals(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun `string aaaaa`() {
        assert(zFunction("aaaaa").contentEquals(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `string abcabc`() {
        assert(zFunction("abcabc").contentEquals(intArrayOf(6, 0, 0, 3, 0, 0)))
    }

    @Test
    fun `string aabaab`() {
        assert(zFunction("aabaab").contentEquals(intArrayOf(6, 1, 0, 3, 1, 0)))
    }

    @Test
    fun `string aaabaab`() {
        assert(zFunction("aaabaab").contentEquals(intArrayOf(7, 2, 1, 0, 2, 1, 0)))
    }

    @Test
    fun `string abacaba`() {
        assert(zFunction("abacaba").contentEquals(intArrayOf(7, 0, 1, 0, 3, 0, 1)))
    }

    @Test
    fun `search a in a`() {
        assert(searchZ("a", "a") == 0)
    }

    @Test
    fun `search a in b`() {
        assert(searchZ("b", "a") == 1)
    }

    @Test
    fun `search ba in abac`() {
        assert(searchZ("abac", "ba") == 1)
    }

    @RepeatedTest(value = 10000)
    fun `searchZ small random`() {
        val nText = (0..50).random() + 1
        val nPattern = (0..nText / 4).random() + 1
        val alphabet = "abcdefghijklmopqrstuvwxyz"


        val text = (0..nText).map { alphabet.random() }.joinToString("")
        val pattern = (0..nPattern).map { alphabet.random() }.joinToString("")

        val i = searchZ(text, pattern)
        if (i == text.length) {
            assert(!text.contains(pattern))
            return
        }
        println("${text}, ${pattern}, $i")
        if (i <= text.length - pattern.length) {
            assert(text.substring(i, i + pattern.length).contentEquals(pattern))
            return
        }

        assert(false)
    }

    @RepeatedTest(value = 10000)
    fun `searchZ big random`() {
        val nText = (0..8192).random() + 1
        val nPattern = (0..nText / 4).random() + 1
        val alphabet = "abcdefghijklmopqrstuvwxyz"


        val text = (0..nText).map { alphabet.random() }.joinToString("")
        val pattern = (0..nPattern).map { alphabet.random() }.joinToString("")

        val i = searchZ(text, pattern)
        if (i == text.length) {
            assert(!text.contains(pattern))
            return
        }
        println("${text}, ${pattern}, $i")
        if (i <= text.length - pattern.length) {
            assert(text.substring(i, i + pattern.length).contentEquals(pattern))
            return
        }

        assert(false)
    }
}