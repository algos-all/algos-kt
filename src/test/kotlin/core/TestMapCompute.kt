package core

import org.junit.jupiter.api.Test

class TestMapCompute {

    @Test
    fun testComputeInitialPresentAndResultPresent() {
        // Given a map:
        val map = mutableMapOf<Int, Int>()
        map[42] = 42

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.compute(42) { _, value -> value?.div(2) }

        assert(result == 21)
        assert(map[42] == 21)
    }

    @Test
    fun testComputeInitialPresentAndResultAbsent() {
        // Given a map:
        val map = mutableMapOf<Int, Int>()
        map[42] = 42

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.compute(42) { _, value ->
            if (value?.rem(2) == 0) {
                null
            } else {
                value
            }
        }

        assert(result == null)
        assert(map[42] == null)
    }

    @Test
    fun testComputeInitialAbsentAndResultPresent() {
        // Given a map:
        val map = mutableMapOf<Int, Int>()

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.compute(42) { key, value -> value ?: key }

        assert(result == 42)
        assert(map[42] == 42)
    }

    @Test
    fun testComputeInitialAbsentAndResultAbsent() {
        // Given a map:
        val map = mutableMapOf<Int, Int>()

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.compute(42) { _, value -> value }

        assert(result == null)
        assert(map[42] == null)
    }
}