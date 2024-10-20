package core

import org.junit.jupiter.api.RepeatedTest

class TestScopeFunctionAlso {

    @RepeatedTest(value = 10)
    fun testAlsoMainUseCase() {
        fun computeRandomInteger(l: Int, r: Int): Int {
            return (l..r).random().also { println("$it") }
        }

        assert(computeRandomInteger(0, 9) < 10)
    }
}