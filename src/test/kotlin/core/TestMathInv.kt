package core

import org.junit.jupiter.api.Test

class TestMathInv {

    @Test
    fun testInvOfZero() {
        val x = 0
        val y = x.inv()

        assert(y == -1) { "$y != 0" }
    }

    @Test
    fun testInvOfPlusOne() {
        val x = 1
        val y = x.inv()

        assert(y == -2) { "$y != 2" }
    }

    @Test
    fun testInvOfMaxInt() {
        val x = Int.MAX_VALUE
        val y = x.inv()

        assert(y == Int.MIN_VALUE) { "$y != Int.MIN_VALUE" }
    }

    @Test
    fun testInvOfMinusOne() {
        val x = -1
        val y = x.inv()

        assert(y == 0) { "$y != 0" }
    }

    @Test
    fun testInvOfMinInt() {
        val x = Int.MIN_VALUE
        val y = x.inv()

        assert(y == Int.MAX_VALUE) { "$y != Int.MAX_VALUE" }
    }
}