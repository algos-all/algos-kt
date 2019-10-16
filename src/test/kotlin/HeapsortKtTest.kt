import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeapsortKtTest {

    @Test
    fun `sink works for empty list`() {
        assert(sink(mutableListOf<Int>(), 0).isEmpty())
    }

    @Test
    fun `sink works for one element`() {
        assertEquals(sink(mutableListOf(1), 0), mutableListOf(1))
    }

    @Test
    fun `sink works for two elements`() {
        assertEquals(sink(mutableListOf(1, 2), 0), mutableListOf(1, 2))
        assertEquals(sink(mutableListOf(1, 2), 1), mutableListOf(1, 2))
    }

    @Test
    fun `sink works for two elements (swap)`() {
        assertEquals(sink(mutableListOf(2, 1), 0), mutableListOf(1, 2))
    }

    @Test
    fun `sink works for three elements`() {
        assertEquals(sink(mutableListOf(1, 2, 3), 0), mutableListOf(1, 2, 3))
        assertEquals(sink(mutableListOf(1, 2, 3), 1), mutableListOf(1, 2, 3))
        assertEquals(sink(mutableListOf(1, 2, 3), 2), mutableListOf(1, 2, 3))

        assertEquals(sink(mutableListOf(2, 1, 3), 0), mutableListOf(1, 2, 3))
        assertEquals(sink(mutableListOf(2, 1, 3), 1), mutableListOf(2, 1, 3))
        assertEquals(sink(mutableListOf(2, 1, 3), 2), mutableListOf(2, 1, 3))

        assertEquals(sink(mutableListOf(2, 3, 1), 0), mutableListOf(1, 3, 2))
        assertEquals(sink(mutableListOf(2, 3, 1), 1), mutableListOf(2, 3, 1))
        assertEquals(sink(mutableListOf(2, 3, 1), 2), mutableListOf(2, 3, 1))

        assertEquals(sink(mutableListOf(3, 2, 1), 0), mutableListOf(1, 2, 3))
        assertEquals(sink(mutableListOf(3, 2, 1), 1), mutableListOf(3, 2, 1))
        assertEquals(sink(mutableListOf(3, 2, 1), 2), mutableListOf(3, 2, 1))
    }

    @Test
    fun `sink works for four elements`() {
        for (i in 0..3) {
            assertEquals(sink(mutableListOf(1, 2, 3, 4), i), mutableListOf(1, 2, 3, 4))
        }

        assertEquals(sink(mutableListOf(4, 3, 2, 1), 0), mutableListOf(2, 3, 4, 1))
        assertEquals(sink(mutableListOf(4, 3, 2, 1), 1), mutableListOf(4, 1, 2, 3))
        assertEquals(sink(mutableListOf(4, 3, 2, 1), 2), mutableListOf(4, 3, 2, 1))
        assertEquals(sink(mutableListOf(4, 3, 2, 1), 3), mutableListOf(4, 3, 2, 1))
    }

    @Test
    fun `sink works for weird indexes`() {
        assert(sink(mutableListOf<Int>(), -1).isEmpty())
        assert(sink(mutableListOf<Int>(), 42).isEmpty())
    }

    @Test
    fun `sink works for weird indexes (one element)`() {
        assertEquals(sink(mutableListOf(1), -1), mutableListOf(1))
        assertEquals(sink(mutableListOf(1), 42), mutableListOf(1))
    }
}