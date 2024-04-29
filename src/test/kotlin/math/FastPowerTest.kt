package math

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.pow
import kotlin.math.roundToInt

typealias FastPowerType = (x: Int, n: Int) -> Int

class FastPowerTest {

    companion object {
        data class FastPowerWithIndex(val fastPower: FastPowerType, val index: Int)

        @JvmStatic
        fun fastPower(): List<FastPowerType> {
            return listOf<FastPowerType>(::fastPower0, ::fastPower1, ::fastPower2)
        }

        @JvmStatic
        fun fastPowerWithIndex(): List<FastPowerWithIndex> {
            return fastPower().flatMap { function ->
                (0 until 500).map { index -> FastPowerWithIndex(function, index) }
            }
        }
    }

    @ParameterizedTest
    @MethodSource("fastPowerWithIndex")
    fun `anything to the power of 0 is 1`(fastPowerWithIndex: FastPowerWithIndex) {
        val fastPower = fastPowerWithIndex.fastPower

        val x = (-1024..1024).random()
        assert(fastPower(x, 0) == 1)
    }

    @ParameterizedTest
    @MethodSource("fastPowerWithIndex")
    fun `anything to the power of 1 is itself`(fastPowerWithIndex: FastPowerWithIndex) {
        val fastPower = fastPowerWithIndex.fastPower

        val x = (-1024..1024).random()
        assert(fastPower(x, 1) == x)
    }

    @ParameterizedTest
    @MethodSource("fastPowerWithIndex")
    fun `fast power works`(fastPowerWithIndex: FastPowerWithIndex) {
        val fastPower = fastPowerWithIndex.fastPower

        val x = (0..42).random()
        val n = (0..5).random()
        assert(fastPower(x, n) == x.toDouble().pow(n).roundToInt()) {
            "${fastPower(x, n)} is not ${x.toDouble().pow(n).roundToInt()}"
        }
    }

    @ParameterizedTest
    @MethodSource("fastPowerWithIndex")
    fun `fast power (large power)`(fastPowerWithIndex: FastPowerWithIndex) {
        val fastPower = fastPowerWithIndex.fastPower

        val x = (2..3).random()
        val n = (2..15).random()
        assert(fastPower(x, n) == x.toDouble().pow(n).roundToInt()) {
            "${fastPower(x, n)} is not ${x.toDouble().pow(n).roundToInt()}"
        }
    }

    @ParameterizedTest
    @MethodSource("fastPower")
    fun `fast power for powers of two`(fastPower: (x: Int, n: Int) -> Int) {
        assert(fastPower(2, 6) == 64)
        assert(fastPower(2, 7) == 128)
        assert(fastPower(2, 8) == 256)
        assert(fastPower(2, 9) == 512)
        assert(fastPower(2, 10) == 1024)
    }
}
