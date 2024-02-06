package core

import org.junit.jupiter.api.Test

class TestMapCompute {

    @Test
    fun testCompute() {
        val map = mutableMapOf<Int, Int>()
        map[42] = 84
        map[43] = 86
        map[44] = 88

        val result = map.compute(42) { _, value -> value?.div(2) }

        assert(result == 42) { "$result == 42" }
        assert(map[42] == 42) { "map[42] has the new value" }
    }

    @Test
    fun testComputeIfAbsent() {
        val map = HashMap<Int, Int>()
        map[42] = 84

        val result0 = map.computeIfAbsent(42) { _ -> 44 }
        val result1 = map.computeIfAbsent(43) { _ -> 86 }

        assert(result0 == 84) { "$result0 is not null" }
        assert(result1 == 86) { "$result1 is not null" }
        assert(map[42] == 84) { "map[42] has the old value" }
        assert(map[43] == 86) { "map[43] has the new value" }
    }

    @Test
    fun testComputeIfPresent() {
        val map = HashMap<Int, Int>()
        map[42] = 84

        val result0 = map.computeIfPresent(42) { _, value -> value.div(2) }
        val result1 = map.computeIfPresent(43) { _, _ -> 86 }

        assert(result0 == 42) { "$result0 is not 42" }
        assert(result1 == null) { "$result1 is not null" }
        assert(map[42] == 42) { "map[42] has the old value" }
        assert(map[43] == null) { "map[43] has the new value" }
    }
}