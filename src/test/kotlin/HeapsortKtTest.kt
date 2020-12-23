import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
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
        assertEquals(mutableListOf(1, 2), sink(mutableListOf(2, 1), 0))
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
    fun `sink throws for weird indexes (empty collection)`() {
        assertThrows(IllegalArgumentException::class.java) { sink(mutableListOf<Int>(), -1) }
        assertThrows(IllegalArgumentException::class.java) { sink(mutableListOf<Int>(), 42) }
    }

    @Test
    fun `sink throws for weird indexes (one element)`() {
        assertThrows(IllegalArgumentException::class.java) { sink(mutableListOf(1), -1) }
        assertThrows(IllegalArgumentException::class.java) { sink(mutableListOf(1), 42) }
    }

    @Test
    fun `heapify works for empty list`() {
        assertEquals(mutableListOf<Int>(), heapify(mutableListOf<Int>()))
    }

    @Test
    fun `heapify works for one element`() {
        assertEquals(mutableListOf(42), heapify(mutableListOf(42)))
    }

    @Test
    fun `heapify works for two elements`() {
        assertEquals(mutableListOf(42, 43), heapify(mutableListOf(43, 42)))
    }
}