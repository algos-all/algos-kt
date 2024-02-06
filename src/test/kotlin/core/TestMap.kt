package core

import org.junit.jupiter.api.Test

class TestMap {

    @Test
    fun test() {
        val map = mutableMapOf<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88
    }

    @Test
    fun testMultiMapGetOrElse() {
        val map = mutableMapOf<Int, MutableList<Int>>()
        map.getOrElse(42) { mutableListOf() }.add(43)
        assert(map[42] == null) { "map[42] must not be null" }
    }

    @Test
    fun testMultiMapComputeIfAbsent() {
        val map = mutableMapOf<Int, MutableList<Int>>()
        map.computeIfAbsent(42) { key -> mutableListOf(key) }.add(43)
        assert(map[42] != null) { "map[42] must not be null" }
        assert(map[42]?.size == 2) { "map[42] must have size 2" }
    }

    @Test
    fun testUpdate() {
        val n = 42
        val xs = IntArray(n) { idx -> 2 * idx }
        for (i in xs.indices) {
            assert(xs[i] == 2 * i)
        }
    }
}