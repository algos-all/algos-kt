package core

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.NoSuchElementException

class TestListMinMax {
    @Test
    fun testMin() {
        val xs = mutableListOf(42, 43, 44)

        val result = xs.min()

        assert(result == 42)
    }

    @Test
    fun testMinThrow() {
        val xs = emptyList<Int>()

        assertThrows<NoSuchElementException> { xs.min() }
    }

    @Test
    fun testMinOrNull() {
        val xs = emptyList<Int>()

        val result = xs.minOrNull()

        assert(result == null)
    }

    @Test
    fun testMax() {
        val xs = mutableListOf(42, 43, 44)

        val result = xs.max()

        assert(result == 44)
    }

    @Test
    fun testMaxThrow() {
        val xs = emptyList<Int>()

        assertThrows<NoSuchElementException> { xs.max() }
    }

    @Test
    fun testMaxOrNull() {
        val xs = emptyList<Int>()

        val result = xs.maxOrNull()

        assert(result == null)
    }
}