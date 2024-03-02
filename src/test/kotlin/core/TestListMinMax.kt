package core

import org.junit.jupiter.api.Test
import java.util.NoSuchElementException

class TestListMinMax {
    @Test
    fun testMin() {
        // Given a list:
        val xs = mutableListOf(42, 43, 44)

        // How to find the minimum element in this list?
        // Warning: the empty-case exception is possible!
        val result = xs.min()

        assert(result == 42)
    }

    @Test
    fun testMinEmptyCase() {
        // Given an empty list:
        val xs = emptyList<Int>()

        // How to handle an empty list when searching for smallest element?

        // Approach 1: allow null to be returned
        val result1 = xs.minOrNull()
        assert(result1 == null)

        // Approach 2: catch the empty-case exception
        val result2 = try {
            xs.min()
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(result2 == Unit)
    }

    @Test
    fun testMax() {
        // Given a list:
        val xs = mutableListOf(42, 43, 44)

        // How to find the maximum element in this list?
        // Warning: the empty-case exception is possible!
        val result = xs.max()

        assert(result == 44)
    }

    @Test
    fun testMaxEmptyCase() {
        // Given an empty list:
        val xs = emptyList<Int>()

        // How to handle an empty list when searching for largest element?

        // Approach 1: allow null
        val result1 = xs.maxOrNull()
        assert(result1 == null)

        // Approach 2: catch the empty-case exception
        val result2 = try {
            xs.max()
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(result2 == Unit)
    }
}