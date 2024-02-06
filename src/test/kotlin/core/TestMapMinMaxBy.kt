package core

import org.junit.jupiter.api.Test

class TestMapMinMaxBy {

    @Test
    fun testMaxBy() {
        // Given a non-empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the largest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.maxBy { it.value }

        assert(entry.key == 44)
        assert(entry.value == 44)
    }

    @Test
    fun testMaxByOrNull() {
        // Given a possibly empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the largest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.maxByOrNull { it.value }

        assert(entry != null)
        assert(entry?.key == 44)
        assert(entry?.value == 44)
    }

    @Test
    fun testMinBy() {
        // Given a non-empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the smallest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.minBy { it.value }

        assert(entry.key == 42)
        assert(entry.value == 42)
    }

    @Test
    fun testMinByOrNull() {
        // Given a possibly empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the smallest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.minByOrNull { it.value }

        assert(entry != null)
        assert(entry?.key == 42)
        assert(entry?.value == 42)
    }
}