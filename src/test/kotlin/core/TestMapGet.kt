package core

import org.junit.jupiter.api.Test

class TestMapGet {

    @Test
    fun testGetOrElse() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42

        // Q: What will the following code produce? What will be the state of the map?
        val result0 = map.getOrElse(42) { 44 }
        val result1 = map.getOrElse(13) { 44 }

        assert(result0 == 42) { "$result0 and 42" }
        assert(result1 == 44) { "$result1 and 44" }
        assert(map[42] == 42) { "map[42] has the old value" }
        assert(map[13] == null) { "map[13] still has old value" }
    }

    @Test
    fun testGetOrDefault() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42

        // Q: What will the following code produce? What will be the state of the map?
        val result0 = map.getOrDefault(42, 44)
        val result1 = map.getOrDefault(13, 44)

        assert(result0 == 42) { "$result0 and 42" }
        assert(result1 == 44) { "$result1 and 44" }
        assert(map[42] == 42) { "map[42] has the old value" }
        assert(map[13] == null) { "map[13] still has old value" }
    }

    @Test
    fun testGetOrPut() {
        // Given a map:
        val map = HashMap<Int, Int>()
        map[42] = 42

        // Q: What will the following code produce? What will be the state of the map?
        val result0 = map.getOrPut(42) { 44 }
        val result1 = map.getOrPut(13) { 44 }

        assert(result0 == 42) { "$result0 is not null" }
        assert(result1 == 44) { "$result1 is not null" }
        assert(map[42] == 42) { "map[42] has the old value" }
        assert(map[13] == 44) { "map[13] has the computed value" }
    }
}