package core

import org.junit.jupiter.api.Test

class TestListGet {

    @Test
    fun testGetOrElse() {
        val xs = listOf(42, 43, 44)

        val result0 = xs.getOrElse(2) { 88 }
        val result1 = xs.getOrElse(9) { 99 }

        assert(result0 == 44)
        assert(result1 == 99)
    }
}