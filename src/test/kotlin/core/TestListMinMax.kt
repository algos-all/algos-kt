package core

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.NoSuchElementException

class TestListMinMax {
    @Test
    fun testMin() {
        // Given a list:
        val xs = mutableListOf(42, 43, 44)

        // What will be returned if you call xs.min()?
        val result = xs.min()

        assert(result == 42)
    }

    @Test
    fun testMinThrow() {
        // Given an empty list:
        val xs = emptyList<Int>()

        // What will be returned if you call xs.min()?
        assertThrows<NoSuchElementException> { xs.min() }
    }

    @Test
    fun testMinOrNull() {
        // Given a list whose content is unknown:
        val xs = emptyList<Int>()

        // How to search for the min element without raising an exception?
        val result = xs.minOrNull()

        assert(result == null)
    }

    @Test
    fun testMax() {
        // Given a list:
        val xs = mutableListOf(42, 43, 44)

        // What will be returned if you call xs.max()?
        val result = xs.max()

        assert(result == 44)
    }

    @Test
    fun testMaxThrow() {
        // Given an empty list:
        val xs = emptyList<Int>()

        // What will be returned if you call xs.max()?
        assertThrows<NoSuchElementException> { xs.max() }
    }

    @Test
    fun testMaxOrNull() {
        // Given a list whose content is unknown:
        val xs = emptyList<Int>()

        // How to search for the max element without raising an exception?
        val result = xs.maxOrNull()

        assert(result == null)
    }
}