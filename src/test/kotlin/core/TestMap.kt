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
        assert(map[13] == null) { "map[13] still has old value" }
    }

    @Test
    fun testGetOrDefault() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        val result0 = map.getOrDefault(42, 44)
        val result1 = map.getOrDefault(13, 44)
        assert(result0 == 42) { "$result0 and 42" }
        assert(result1 == 44) { "$result1 and 44" }
        assert(map[13] == null) { " map[13] still has old value" }
    }

    @Test
    fun testGetOrPut() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        val result0 = map.getOrPut(42) { 44 }
        val result1 = map.getOrPut(13) { 44 }
        assert(result0 == 42) { "$result0 is not null" }
        assert(result1 == 44) { "$result1 is not null" }
        assert(map[13] == 44) { "map[13] has the computed value" }
    }

    @Test
    fun testComputeIfAbsent() {
        val map = HashMap<Int, Int>()
        map[42] = 42
        val result0 = map.computeIfAbsent(42) { _ -> 44 }
        val result1 = map.computeIfAbsent(13) { _ -> 44 }
        assert(result0 == 42) { "$result0 is not null" }
        assert(result1 == 44) { "$result1 is not null" }
        assert(map[13] == 44) { "map[13] has the computed value" }
    }

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

    @Test
    fun testMaxOfWith() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value0 = map.maxOfWith(compareBy({ it }, { it })) { it.value }
        val value1 = map.maxOfWith({ lft, rgt -> lft.compareTo(rgt) }) { it.value }

        assert(value0 == 88)
        assert(value1 == 88)
    }

    @Test
    fun testMaxOfWithOrNull() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value0 = map.maxOfWithOrNull(compareBy({ it }, { it })) { it.value }
        val value1 = map.maxOfWithOrNull({ lft, rgt -> lft.compareTo(rgt) }) { it.value }

        assert(value0 == 88)
        assert(value1 == 88)
    }

    @Test
    fun testMinOfWith() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value0 = map.minOfWith(compareBy({ it }, { it })) { it.value }
        val value1 = map.minOfWith({ lft, rgt -> lft.compareTo(rgt) }) { it.value }

        assert(value0 == 84)
        assert(value1 == 84)
    }

    @Test
    fun testMinOfWithOrNull() {
        val map = HashMap<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val value0 = map.minOfWithOrNull(compareBy({ it }, { it })) { it.value }
        val value1 = map.minOfWithOrNull({ lft, rgt -> lft.compareTo(rgt) }) { it.value }

        assert(value0 == 84)
        assert(value1 == 84)
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