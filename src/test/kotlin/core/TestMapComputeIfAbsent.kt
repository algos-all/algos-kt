package core

import org.junit.jupiter.api.Test

class TestMapComputeIfAbsent {
    @Test
    fun testComputeIfAbsent() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 84

        // Q: What will the following code produce? What will be the state of the map?
        val result0 = map.computeIfAbsent(42) { _ -> 44 }
        val result1 = map.computeIfAbsent(43) { _ -> 86 }

        assert(result0 == 84) { "$result0 is not null" }
        assert(result1 == 86) { "$result1 is not null" }
        assert(map[42] == 84) { "map[42] has the old value" }
        assert(map[43] == 86) { "map[43] has the new value" }
    }

    @Test
    fun testComputeIfAbsentNullCase() {
        // Given a map:
        val map = HashMap<Int, Int?>()

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.computeIfAbsent(42) { _ -> null }

        assert(result == null)
        assert(map[42] == null)
        assert(map[43] == null)
    }
}