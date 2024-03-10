package core

import org.junit.jupiter.api.Test

class TestMapMerge {

    @Test
    fun testMergeToCreate() {
        // Given a map:
        val map = mutableMapOf<Int, List<Int>>()

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.merge(42, listOf(42)) { lft, rgt ->
            lft + rgt
        }

        assert(result == listOf(42)) { "$result" }
        assert(map[42] == listOf(42)) { "${map[42]}" }
    }

    @Test
    fun testMergeToUpdate() {
        // Given a map:
        val map = mutableMapOf<Int, List<Int>>()
        map[42] = listOf(84)

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.merge(42, listOf(96)) { lft, rgt ->
            lft + rgt
        }

        assert(result == listOf(96, 84) || result == listOf(84, 96)) { "$result" }
        assert(map[42] == listOf(96, 84) || map[42] == listOf(84, 96)) { "${map[42]}" }
    }

    @Test
    fun testMergeToDelete() {
        // Given a map:
        val map = mutableMapOf<Int, Int>()
        map[42] = 84

        // Q: What will the following code produce? What will be the state of the map?
        val result = map.merge(42, 84) { _, _ -> null }

        assert(result == null)
        assert(map[42] == null)
    }
}