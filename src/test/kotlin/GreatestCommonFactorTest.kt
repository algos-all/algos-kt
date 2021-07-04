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
}
