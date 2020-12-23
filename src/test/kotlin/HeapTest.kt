import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeapTest {

    @Test
    fun `heap with no elements`() {
        val heap = Heap<Int>()

        assert(heap.isEmpty())
    }

    @Test
    fun `heap with one element`() {
        val heap = Heap(mutableListOf(1))

        assert(!heap.isEmpty())
        assert(heap.peek() == 1)
    }

    @Test
    fun `heap poll with one element`() {
        val heap = Heap(mutableListOf(42))

        assert(heap.poll() == 42)
        assert(heap.isEmpty())
    }

    @Test
    fun `heap poll with two elements`() {
        val heap = Heap(mutableListOf(42, 43))

        assert(heap.poll() == 42)
        assert(heap.poll() == 43)
        assert(heap.isEmpty())
    }

    @Test
    fun `heap poll with two elements, reversed`() {
    }
}