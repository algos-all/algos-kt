package core

import org.junit.jupiter.api.Test

class TestMapMerge {

    @Test
    fun testMergeToCreate() {
        val map = mutableMapOf<Int, Int>()

        val result = map.merge(42, 84) { _, value -> value + value }

        assert(result == 84)
        assert(map[42] == 84)
    }

    @Test
    fun testMergeToUpdate() {
        val map = mutableMapOf<Int, Int>()
        map[42] = 84

        val result = map.merge(42, 84) { _, value -> value + value }

        assert(result == 84 + 84)
        assert(map[42] == 84 + 84)
    }

    @Test
    fun testMergeToDelete() {
        val map = mutableMapOf<Int, Int>()
        map[42] = 84

        val result = map.merge(42, 84) { _, _ -> null }

        assert(result == null)
        assert(map[42] == null)
    }
}