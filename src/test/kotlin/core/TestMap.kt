package core

import org.junit.jupiter.api.Test

class TestMap {
    @Test
    fun testAssignment() {
        val m = HashMap<Int, List<Int>>()
        m[0] = arrayListOf(1, 2, 3)
        val x = m[0]
        assert(x !== null && x.isNotEmpty())
    }

    @Test
    fun testUpdate() {
        val n = 42
        val xs = IntArray(n) { idx -> 2 * idx }
        for (i in xs.indices) {
            assert(xs[i] == 2 * i)
        }
    }
}