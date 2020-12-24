import org.junit.jupiter.api.RepeatedTest
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
        val heap = Heap(mutableListOf(42, 43)) { x, y ->
            if (x > y) {
                -1
            } else {
                +1
            }
        }

        assert(heap.poll() == 43)
        assert(heap.poll() == 42)
        assert(heap.isEmpty())
    }

    @Test
    fun `heap poll with five elements`() {
        val heap = Heap(mutableListOf(42, 52, 48, 44, 50))

        assert(heap.poll() == 42)
        assert(heap.poll() == 44)
        assert(heap.poll() == 48)
        assert(heap.poll() == 50)
        assert(heap.poll() == 52)
        assert(heap.isEmpty())
    }

    @Test
    fun `heap poll with five elements, reversed`() {
        val heap = Heap(mutableListOf(42, 52, 48, 44, 50), reverseOrder())

        assert(heap.poll() == 52)
        assert(heap.poll() == 50)
        assert(heap.poll() == 48)
        assert(heap.poll() == 44)
        assert(heap.poll() == 42)
        assert(heap.isEmpty())
    }

    @RepeatedTest(value = 100)
    fun `heap add random fuzz`() {
        val heap = Heap<Int>()
        val list = mutableListOf<Int>()

        for (i in 0 until 10) {
            val element = (-1024..+1024).random()

            heap.add(element)
            list.add(element)

            list.sort()

            val hTop = heap.peek()
            val lTop = list[0]

            assert(hTop == lTop) { "$hTop != $lTop" }
        }
    }

    @RepeatedTest(value = 100)
    fun `heap add random fuzz, reversed`() {
        val heap = Heap<Int>(reverseOrder())
        val list = mutableListOf<Int>()

        for (i in 0 until 10) {
            val element = (-1024..+1024).random()

            heap.add(element)
            list.add(element)

            list.sortWith(reverseOrder())

            val hTop = heap.peek()
            val lTop = list[0]

            assert(hTop == lTop) { "$hTop != $lTop" }
        }
    }

    @RepeatedTest(value = 100)
    fun `heap poll random fuzz`() {
        val n = 10
        val list = mutableListOf<Int>()

        for (i in 0 until n) {
            list.add((-1024..1024).random())
        }

        val heap = Heap(list)

        for (i in 0 until n) {
            list.sort()

            val hTop = heap.poll()
            val lTop = list[0]

            assert(hTop == lTop) { "$hTop != $lTop" }

            list.removeAt(0)
        }
    }

    @RepeatedTest(value = 100)
    fun `heap poll random fuzz, reversed`() {
        val n = 10
        val list = mutableListOf<Int>()

        for (i in 0 until n) {
            list.add((-1024..1024).random())
        }

        val heap = Heap(list, reverseOrder())

        for (i in 0 until n) {
            list.sortWith(reverseOrder())

            val hTop = heap.poll()
            val lTop = list[0]

            assert(hTop == lTop) { "$hTop != $lTop" }

            list.removeAt(0)
        }
    }
}