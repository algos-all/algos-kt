package core

import org.junit.jupiter.api.Test

class TestMapComputeIfPresent {
    @Test
    fun testComputeIfPresent() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42
        map[43] = 43

        // Q: What will the following code produce? What will be the state of the map?
        val result0 = map.computeIfPresent(42) { _, value -> value.div(2) }
        val result1 = map.computeIfPresent(43) { _, _ -> null }
        val result2 = map.computeIfPresent(44) { _, _ -> 88 }

        assert(result0 == 21) { "$result0 is not 42" }
        assert(result1 == null) { "$result1 is not null" }
        assert(result2 == null) { "$result2 is not null" }
        assert(map[42] == 21) { "map[42] != 21" }
        assert(map[43] == null) { "map[43] != null" }
        assert(map[44] == null) { "map[44] != null" }
    }

    @Test
    fun testComputeIfPresentNullCase() {
        // Given a map:
        val map = HashMap<Int, Int?>()

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.computeIfAbsent(42) { _ -> null }

        assert(result == null)
        assert(map[42] == null)
        assert(map[43] == null)
    }
}