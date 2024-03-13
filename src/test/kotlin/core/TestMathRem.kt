package core

import org.junit.jupiter.api.Test

class TestMathRem {

    @Test
    fun testRemTwoPositive() {
        // Given the values for a and b:
        val a = 42
        val b = 13

        // Q: what are the values for r0 and r1?
        val r0 = a.rem(b)
        val r1 = b.rem(a)

        // `rem` calculates the remainder of truncating division of dividend by divisor. The result is either zero or
        // has the same sign as the dividend and has the absolute value less than the absolute value of the divisor.
        assert(r0 == 3) { "$r0 == 3" }
        assert(r1 == 13) { "$r1 == 13" }
    }

    @Test
    fun testRemTwoNegative() {
        // Given the values for a and b:
        val a = -42
        val b = -13

        // Q: what are the values for r0 and r1?
        val r0 = a.rem(b)
        val r1 = b.rem(a)

        // `rem` calculates the remainder of truncating division of dividend by divisor. The result is either zero or
        // has the same sign as the dividend and has the absolute value less than the absolute value of the divisor.
        assert(r0 == -3) { "$r0 == -3" }
        assert(r1 == -13) { "$r1 == -13" }
    }

    @Test
    fun testRemOnePositiveOneNegative() {
        // Given the values for a and b:
        val a = 42
        val b = -13

        // Q: What are the values for r0 and r1?
        val r0 = a.rem(b)
        val r1 = b.rem(a)

        // `rem` calculates the remainder of truncating division of dividend by divisor. The result is either zero or
        // has the same sign as the dividend and has the absolute value less than the absolute value of the divisor.
        assert(r0 == 3) { "$r0 == 3" }
        assert(r1 == -13) { "$r1 == -13" }
    }

    @Test
    fun testDividendIsZero() {
        // Given the values for a and b:
        val a = 0
        val b = 13

        // Q: What will be the value of r?
        val r = a.rem(b)

        // `rem` calculates the remainder of truncating division of dividend by divisor. The result is either zero or
        // has the same sign as the dividend and has the absolute value less than the absolute value of the divisor.
        assert(r == 0)
    }

    @Test
    fun testRemDivisorIsZero() {
        // Given the values for a and b:
        val a = 42
        val b = 0

        // Q: What will be the result of a.rem(b)? How to handle it?

        val r = try {
            a.rem(b)
        } catch (e: ArithmeticException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(r == Unit)
    }
}