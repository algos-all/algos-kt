package core

import org.junit.jupiter.api.Test

class TestScopeFunctionApply {

    @Test
    fun testApplyMainUseCase() {
        val xs = mutableListOf<Int>()

        xs.apply {
            add(1)
            add(2)
            add(3)
        }.apply {
            remove(3)
        }

        assert(xs == listOf(1, 2))
    }
}