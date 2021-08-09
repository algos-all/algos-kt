import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathTest {
    @Test
    fun `binomial coefficient for zeros`() {
        assert(binomialCoefficient(0, 0) == 0)
        assert(binomialCoefficient(0, 42) == 0)
        assert(binomialCoefficient(42, 0) == 1)
        assert(binomialCoefficient(0, 1337) == 0)
        assert(binomialCoefficient(1337, 0) == 1)
    }

    @Test
    fun `binomial coefficient for ones`() {
        assert(binomialCoefficient(1, 42) == 0)
        assert(binomialCoefficient(42, 1) == 42)
        assert(binomialCoefficient(1337, 1) == 1337)
    }

    @Test
    fun `binomial coefficient for five`() {
        assert(binomialCoefficient(5, 1) == 5)
        assert(binomialCoefficient(5, 2) == 10)
        assert(binomialCoefficient(5, 3) == 10)
        assert(binomialCoefficient(5, 4) == 5)
    }

    @Test
    fun `binomial coefficient for Int overflow`() {
        assert(binomialCoefficient(58, 8) == 1916797311)
    }
}