import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestKadane {
    @Test
    fun `should work for a single element`() {
        assert(maxSubArray(intArrayOf(0)) == 0)
        assert(maxSubArray(intArrayOf(42)) == 42)
        assert(maxSubArray(intArrayOf(-7)) == -7)
    }

    @Test
    fun `should work for whole arrays`() {
        assert(maxSubArray(intArrayOf(1, 2, 3)) == 6)
        assert(maxSubArray(intArrayOf(3, 1, 2)) == 6)
    }

    @Test
    fun `should work for all negative values`() {
        assert(maxSubArray(intArrayOf(-1, -2, -3)) == -1)
        assert(maxSubArray(intArrayOf(-2, -3, -1)) == -1)
    }

    @Test
    fun `from leetcode`() {
        assert(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)) == 6)
    }
}