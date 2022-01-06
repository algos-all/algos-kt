package math

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class ManualDivideTest {
    @Test
    fun `divide by one`() {
        assert(mDivide(1, 1) == 1)
        assert(mDivide(2, 1) == 2)
        assert(mDivide(7, 1) == 7)
    }

    @Test
    fun `divide by one with MAX_VALUE`() {
        assert(mDivide(Int.MAX_VALUE, 1) == Int.MAX_VALUE)
    }

    @Test
    fun `divide by one with MIN_VALUE`() {
        assertThrows(IllegalArgumentException::class.java) {
            mDivide(Int.MIN_VALUE, 1)
        }
    }

    @Test
    fun `divide by two`() {
        assert(mDivide(1, 2) == 0)
        assert(mDivide(2, 2) == 1)
        assert(mDivide(4, 2) == 2)
    }

    @RepeatedTest(value = 1000)
    fun `random divide test`() {
        val n = (0..Int.MAX_VALUE).random()
        val d = (1..Int.MAX_VALUE).random()

        assert(mDivide(n, d) == n / d)
    }
}