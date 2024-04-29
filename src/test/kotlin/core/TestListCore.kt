package core

import org.junit.jupiter.api.Test

class TestListCore {
    @Test
    fun testListSize() {
        // Given a list:
        val xs = listOf(1, 2, 3)

        // Q: How to get the number of elements in the list?
        assert(xs.size == 3)
    }

    @Test
    fun testListIndexOf() {
        // Given a list:
        val xs = listOf(1, 2, 3, 1, 2, 3)

        // Q: How to get the index of the first element that is equal to given element (e.g. "2")?
        assert(xs.indexOf(2) == 1)
    }

    @Test
    fun testListIndexOfFirstLast() {
        // Given a list:
        val xs = listOf(4, 6, 13, 8, 10, 17)

        // Q: How to get the index of the first odd element?
        // Q: How to get the index of the last odd element?
        assert(xs.indexOfFirst { it % 2 == 1 } == 2)
        assert(xs.indexOfLast { it % 2 == 1 } == 5)
    }

    @Test
    fun testEmptyListLastIndex() {
        // Given an empty list:
        val xs = emptyList<Int>()

        // Q: What is the value of idx?
        val idx = xs.lastIndex

        assert(idx == -1)
    }
}