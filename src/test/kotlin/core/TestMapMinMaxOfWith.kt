package core

import org.junit.jupiter.api.Test

class TestMapMinMaxOfWith {

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
}