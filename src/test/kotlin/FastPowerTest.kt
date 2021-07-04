import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.math.pow
import kotlin.math.roundToInt

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FastPowerTest {
    private val functions = listOf<(x: Int, n: Int) -> Int>(
        { x, n -> fpow0(x, n) },
        { x, n -> fpow1(x, n) },
    )

    @RepeatedTest(value = 100)
    fun `anything to the power of 0 is 1`() {
        val x = (-1024..+1024).random()
        functions.forEach { fastPower ->
            assert(fastPower(x, 0) == 1)
        }
    }

    @RepeatedTest(value = 100)
    fun `anything to the power of 1 is itself`() {
        val x = (-1024..+1024).random()
        functions.forEach { fastPower ->
            assert(fastPower(x, 1) == x)
        }
    }

    @RepeatedTest(value = 500)
    fun `fast power works`() {
        val x = (0..+42).random()
        val n = (0..5).random()
        functions.forEach { fastPower ->
            assert(fastPower(x, n) == x.toDouble().pow(n).roundToInt()) {
                "${fastPower(x, n)} is not ${x.toDouble().pow(n).roundToInt()}"
            }
        }
    }

    @RepeatedTest(value = 256)
    fun `fast power (large power)`() {
        val x = (2..3).random()
        val n = (2..15).random()
        functions.forEach{ fastPower ->
            assert(fastPower(x, n) == x.toDouble().pow(n).roundToInt()) {
                "${fastPower(x, n)} is not ${x.toDouble().pow(n).roundToInt()}"
            }
        }
    }

    @Test
    fun `fast power for powers of two`() {
        functions.forEach { fastPower -> assert(fastPower(2, 6) == 64) }
        functions.forEach { fastPower -> assert(fastPower(2, 7) == 128) }
        functions.forEach { fastPower -> assert(fastPower(2, 8) == 256) }
        functions.forEach { fastPower -> assert(fastPower(2, 9) == 512) }
        functions.forEach { fastPower -> assert(fastPower(2, 10) == 1024) }
    }
}
