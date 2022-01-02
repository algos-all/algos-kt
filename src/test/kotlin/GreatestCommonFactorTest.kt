import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GreatestCommonFactorTest {
    @Test
    fun `greatest common factor of 1 and 2 is 1`() {
        assert(gcf(1, 2) == 1)
    }

    @Test
    fun `greatest common factor of 2 and 1 is 1`() {
        assert(gcf(2, 1) == 1)
    }

    @Test
    fun `greatest common factor of 1 and 0 is 1`() {
        assert(gcf(1, 0) == 1)
    }

    @Test
    fun `greatest common factor of 0 and 1 is 1`() {
        assert(gcf(0, 1) == 1)
    }

    @Test
    fun `greatest common factor of 12 and 16 is 4`() {
        assert(gcf(12, 16) == 4)
        assert(gcf(16, 12) == 4)
    }

    @Test
    fun `greatest common factor of 78 and 18 is 6`() {
        assert(gcf(78, 18) == 6)
        assert(gcf(18, 78) == 6)
    }

    @Test
    fun `extended greatest common factor of 1 and 2 is (1, 1, 0)`() {
        assert(xgcf(1, 2).contentEquals(arrayOf(1, 1, 0)))
    }

    @Test
    fun `extended greatest common factor of 2 and 1 is (1, 0, 1)`() {
        assert(xgcf(2, 1).contentEquals(arrayOf(1, 0, 1)))
    }

    @Test
    fun `extended greatest common factor of 12 and 16 is (4, -1, 1)`() {
        assert(xgcf(12, 16).contentEquals(arrayOf(4, -1, 1)))
        assert(xgcf(16, 12).contentEquals(arrayOf(4, 1, -1)))
    }

    @Test
    fun `extended greatest common factor of 78 and 18 is (6, 1, -4)`() {
        assert(xgcf(78, 18).contentEquals(arrayOf(6, 1, -4)))
        assert(xgcf(18, 78).contentEquals(arrayOf(6, -4, 1)))
    }
}
