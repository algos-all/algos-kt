package core

import org.junit.jupiter.api.Test

class TestListAdd {
    @Test
    fun testMutableListAdd() {
        // Given a list:
        val xs = mutableListOf(1, 2, 3)

        // Q: How to add elements 5, 6 and 7 to it one-by-one?
        // Q: You are not allowed to use `+`.
        xs.add(4)
        xs.add(5)
        xs.add(6)

        assert(xs == listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun testMutableListAddAll() {
        // Given two lists:
        val xs = mutableListOf(1, 2, 3)
        val ys = mutableListOf(4, 5, 6)

        // Q: How to merge these two lists together? Will that create new lists?
        // Q: You are not allowed to use `+` or `+=`.
        // A: No, these lists are mutable and will be merged in-place:
        xs.addAll(ys)

        assert(xs == listOf(1, 2, 3, 4, 5, 6)) { "$xs" }
    }
}