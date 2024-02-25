package core

import org.junit.jupiter.api.Test

class TestListGet {

    @Test
    fun testGetOrElse() {
        // Given a non-empty list:
        val xs = listOf(42, 43, 44)

        // How to find:
        //  1. The element at position 2 and return it
        //  2. The element at position 9 and return it
        // If the position is out of bounds, return the index squared
        val result0 = xs.getOrElse(2) { idx -> idx * idx }
        val result1 = xs.getOrElse(9) { idx -> idx * idx }

        assert(result0 == 44)
        assert(result1 == 99)
    }
}