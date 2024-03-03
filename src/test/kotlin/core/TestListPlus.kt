package core

import org.junit.jupiter.api.Test

class TestListPlus {

    @Test
    fun testListPlus() {
        // Given two lists:
        val xs = listOf(1, 2, 3)
        val ys = listOf(4, 5, 6)

        // Q: How to merge these two lists together? Will that create new lists?
        // A: Yes, in both cases this creates a brand-new list:
        val ms = xs + ys
        val ns = ys + xs

        assert(ms == listOf(1, 2, 3, 4, 5, 6))
        assert(ns == listOf(4, 5, 6, 1, 2, 3))
    }

    @Test
    fun testListPlusAssign() {
        // Given two lists:
        var xs = listOf(1, 2, 3)
        val ys = listOf(4, 5, 6)

        // Q: How to merge these two lists together? Will that create new lists?
        // A: Yes, this creates a new list first and then re-assigns it to `xs`:
        xs += ys

        assert(xs == listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun testMutableListPlusAssign() {
        // Given two lists:
        val xs = mutableListOf(1, 2, 3)
        val ys = mutableListOf(4, 5, 6)

        // Q: How to merge these two lists together? Will that create new lists?
        // Q: You are not allowed to use `addAll`.
        // A: No, these lists are mutable and will be merged in-place:
        xs += ys

        assert(xs == listOf(1, 2, 3, 4, 5, 6)) { "$xs" }
    }
}