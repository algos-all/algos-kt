package core

import org.junit.jupiter.api.Test

class TestMap {
    @Test
    fun testGetOrElse() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        val result0 = map.getOrElse(42) { 44 }
        val result1 = map.getOrElse(13) { 44 }
        assert(result0 == 42) { "$result0 and 42" }
        assert(result1 == 44) { "$result1 and 44" }
    }

    @Test
    fun testGetOrDefault() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        val result0 = map.getOrDefault(42, 44)
        val result1 = map.getOrDefault(13, 44)
        assert(result0 == 42) { "$result0 and 42" }
        assert(result1 == 44) { "$result1 and 44" }
    }

    @Test
    fun testComputeIfAbsent() {
        val map = mutableMapOf<Int, Int>()
        val result0 = map.putIfAbsent(42, 42)
        val result1 = map.computeIfAbsent(44) { key -> key }
        assert(result0 == null) { "$result0 is not null" }
        assert(result1 == 44) { "$result1 is not null" }
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