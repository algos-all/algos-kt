package core

import org.junit.jupiter.api.Test

class TestMapCompute {

    @Test
    fun testCompute() {
        // Given a map:
        val map = mutableMapOf<Int, Int>()
        map[42] = 84

        // What will the following code produce? What will be the state of the map?
        val result0 = map.compute(42) { _, value -> value?.div(2) }
        val result1 = map.compute(84) { _, value -> value?.div(2) }

        assert(result0 == 42) { "$result0 == 42" }
        assert(result1 == null)
        assert(map[42] == 42) { "map[42] has the new value" }
        assert(map[84] == null)
    }

    @Test
    fun testComputeIfAbsent() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 84

        // What will the following code produce? What will be the state of the map?
        val result0 = map.computeIfAbsent(42) { _ -> 44 }
        val result1 = map.computeIfAbsent(43) { _ -> 86 }

        assert(result0 == 84) { "$result0 is not null" }
        assert(result1 == 86) { "$result1 is not null" }
        assert(map[42] == 84) { "map[42] has the old value" }
        assert(map[43] == 86) { "map[43] has the new value" }
    }

    @Test
    fun testComputeIfPresent() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 84

        // What will the following code produce? What will be the state of the map?
        val result0 = map.computeIfPresent(42) { _, value -> value.div(2) }
        val result1 = map.computeIfPresent(43) { _, _ -> 86 }

        assert(result0 == 42) { "$result0 is not 42" }
        assert(result1 == null) { "$result1 is not null" }
        assert(map[42] == 42) { "map[42] has the old value" }
        assert(map[43] == null) { "map[43] has the new value" }
    }
}