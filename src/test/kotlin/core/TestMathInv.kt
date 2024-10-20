package core

import org.junit.jupiter.api.Test

class TestMathInv {

    @Test
    fun testInvOfZero() {
        // Q: what is the value of y?
        val x = 0
        val y = x.inv()

        assert(y == -1) { "$y != 0" }
    }

    @Test
    fun testInvOfPlusOne() {
        // Q: what is the value of y?
        val x = 1
        val y = x.inv()

        assert(y == -2) { "$y != 2" }
    }

    @Test
    fun testInvOfMaxInt() {
        // Q: what is the value of y?
        val x = Int.MAX_VALUE
        val y = x.inv()

        assert(y == Int.MIN_VALUE) { "$y != Int.MIN_VALUE" }
    }

    @Test
    fun testInvOfMinusOne() {
        // Q: what is the value of y?
        val x = -1
        val y = x.inv()

        assert(y == 0) { "$y != 0" }
    }

    @Test
    fun testInvOfMinInt() {
        // Q: what is the value of y?
        val x = Int.MIN_VALUE
        val y = x.inv()

        assert(y == Int.MAX_VALUE) { "$y != Int.MAX_VALUE" }
    }
}