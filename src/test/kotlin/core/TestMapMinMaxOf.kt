package core

import org.junit.jupiter.api.Test

class TestMapMinMaxOf {

    @Test
    fun testMaxOf() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value = map.maxOf { it.value }

        assert(value == 88)
    }

    @Test
    fun testMaxOfOrNull() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value = map.maxOfOrNull { it.value }

        assert(value == 88)
    }

    @Test
    fun testMinOf() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value = map.minOf { it.value }

        assert(value == 84)
    }

    @Test
    fun testMinOfOrNull() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value = map.minOfOrNull { it.value }

        assert(value == 84)
    }
}