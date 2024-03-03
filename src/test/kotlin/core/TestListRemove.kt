package core

import org.junit.jupiter.api.Test

class TestListRemove {
    @Test
    fun testListRemove() {
        // Given a list:
        val xs = mutableListOf(1, 2, 3, 2, 4, 2)

        // Q: What will the following code produce? What will be the state of the list?
        val result = xs.remove(2)

        assert(result)
        assert(xs == listOf(1, 3, 2, 4, 2)) { "$xs" }
    }

    @Test
    fun testListRemoveAll() {
        // Given a list:
        val xs = mutableListOf(1, 2, 3, 2, 4, 2)

        // Q: What will the following code produce? What will be the state of the list?
        val result = xs.removeAll(listOf(2))

        assert(result)
        assert(xs == listOf(1, 3, 4)) { "$xs" }
    }

    @Test
    fun testListRemoveIf() {
        // Given a list:
        val xs = mutableListOf(1, 2, 3, 2, 4, 2)

        // Q: How to remove all even integers from the list?
        val result = xs.removeIf { it % 2 == 0 }

        assert(result)
        assert(xs == listOf(1, 3)) { "$xs" }
    }

    @Test
    fun testListRemoveFirstAndLast() {
        // Given a list:
        val xs = mutableListOf(1, 2, 3)

        // Q: How to remove first and last elements from the list?
        // Warning: you must handle the NoSuchElementException!
        val resultFirst = xs.removeFirst()
        val resultLast = xs.removeLast()

        assert(resultFirst == 1)
        assert(resultLast == 3)
        assert(xs == listOf(2))
    }

    @Test
    fun testEmptyListRemoveFirstAndLast() {
        // Given a list:
        val xs = mutableListOf<Int>()

        // Q: How to handle an empty list when removing first and/or last element?

        // Approach 1: allow null to be returned
        val resultFirstOrNull = xs.removeFirstOrNull()
        val resultLastOrNull = xs.removeLastOrNull()

        // Approach 2: catch the empty-case exception
        val resultFirst = try {
            xs.removeFirst()
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        val resultLast = try {
            xs.removeLast()
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(resultFirstOrNull == null)
        assert(resultLastOrNull == null)
        assert(resultFirst == Unit)
        assert(resultLast == Unit)
    }
}