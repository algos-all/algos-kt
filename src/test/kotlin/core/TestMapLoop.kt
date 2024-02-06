package core

import org.junit.jupiter.api.Test

class TestMapLoop {

    @Test
    fun testForEach() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        map.forEach { (key, value) ->
            assert(map[key] == value)
        }
    }

    @Test
    fun testForLoop() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43
        map[44] = 44

        for ((key, value) in map) {
            assert(map[key] == value)
        }
    }
}