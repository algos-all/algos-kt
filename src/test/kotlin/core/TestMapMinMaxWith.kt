package core

import org.junit.jupiter.api.Test

class TestMapMinMaxWith {

    @Test
    fun testMaxWith() {
        // Given a possibly empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the largest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.maxWith { lft, rgt -> lft.value.compareTo(rgt.value) }

        assert(entry.key == 44)
        assert(entry.value == 44)
    }

    @Test
    fun testMaxWithOrNull() {
        // Given a possibly empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the largest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.maxWithOrNull { lft, rgt -> lft.value.compareTo(rgt.value) }

        assert(entry != null)
        assert(entry?.key == 44)
        assert(entry?.value == 44)
    }

    @Test
    fun testMinWith() {
        // Given a possibly empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the largest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.minWith { lft, rgt -> lft.value.compareTo(rgt.value) }

        assert(entry.key == 42)
        assert(entry.value == 42)
    }

    @Test
    fun testMinWithOrNull() {
        // Given a possibly empty map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // How to find the entry yielding the largest value of the given function?
        // Assume the function to be the value of the map entry:
        val entry = map.minWithOrNull { lft, rgt -> lft.value.compareTo(rgt.value) }

        assert(entry != null)
        assert(entry?.key == 42)
        assert(entry?.value == 42)
    }
}