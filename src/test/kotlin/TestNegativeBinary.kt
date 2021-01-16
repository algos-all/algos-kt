import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestNegativeBinary {
    @Test
    fun `can convert zero to negative binary`() {
        assert(toNegativeBinary(0).contentEquals(IntArray(1) { 0 }))
        assert(toNegativeBinaryR(0).contentEquals(IntArray(1) { 0 }))
    }

    @Test
    fun `can convert one to negative binary`() {
        assert(toNegativeBinary(1).contentEquals(IntArray(1) { 1 }))
        assert(toNegativeBinaryR(1).contentEquals(IntArray(1) { 1 }))
    }

    @Test
    fun `can convert two to negative binary`() {
        assert(toNegativeBinary(2).contentEquals(intArrayOf(1, 1, 0)))
        assert(toNegativeBinaryR(2).contentEquals(intArrayOf(0, 1, 1)))
    }

    @Test
    fun `addition generally works`() {
        for (x in -100..+100) {
            for (y in -100..+100) {
                assert(fromNegativeBinary(addNegativeBinary(toNegativeBinary(x), toNegativeBinary(y))) == x + y)
            }
        }
    }

    @Test
    fun `subtraction generally works`() {
        for (x in -100..+100) {
            for (y in -100..+100) {
                assert(fromNegativeBinary(subNegativeBinary(toNegativeBinary(x), toNegativeBinary(y))) == x - y)
            }
        }
    }

    @Test
    fun `addition of boundaries works`() {
        assert(
            addNegativeBinary(toNegativeBinary(Int.MIN_VALUE), toNegativeBinary(Int.MAX_VALUE)).contentEquals(
                intArrayOf(1, 1)
            )
        )
    }

    @Test
    fun `subtraction of boundaries works`() {
        assert(
            subNegativeBinary(toNegativeBinary(Int.MAX_VALUE), toNegativeBinary(Int.MAX_VALUE)).contentEquals(
                intArrayOf(0)
            )
        )
        assert(
            subNegativeBinary(toNegativeBinary(Int.MIN_VALUE), toNegativeBinary(Int.MIN_VALUE)).contentEquals(
                intArrayOf(0)
            )
        )
    }
}