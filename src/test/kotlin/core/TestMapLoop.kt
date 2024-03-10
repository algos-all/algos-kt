package core

import org.junit.jupiter.api.Test

class TestMapLoop {

    @Test
    fun testForEach() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // Q: How to iterate over its key value pairs without a for loop?
        map.forEach { (key, value) ->
            assert(map[key] == value)
        }
    }

    @Test
    fun testForLoop() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // Q: How to iterate over its key value pairs with a for loop?
        for ((key, value) in map) {
            assert(map[key] == value)
        }
    }

    @Test
    fun testForLoopEntries() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        // Q: How to iterate over its key value pairs with a for loop?
        for ((key, value) in map.entries) {
            assert(map[key] == value)
        }
    }
}