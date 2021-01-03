import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinarySearchTest {
    private val functions = listOf<(xs: List<Int>, x: Int) -> Int?>(
        { xs, x -> binarySearch0(xs, x) },
        { xs, x -> binarySearch1(xs, x) },
    )

    @Test
    fun `test empty`() {
        functions.forEach { binarySearch -> assert(binarySearch(emptyList(), 42) == null) }
    }

    @Test
    fun `test single present`() {
        functions.forEach { binarySearch -> assert(binarySearch(listOf(42), 42) == 0) }
    }

    @Test
    fun `test single missing`() {
        functions.forEach { binarySearch -> assert(binarySearch(listOf(42), -1) == null) }
    }

    @RepeatedTest(value = 100)
    fun `test random present`() {
        val size = 11
        val lft = -1024
        val rgt = +1024

        val i = (0 until size).random()
        val xs = IntArray(size) { (lft..rgt).random() }.sorted()

        functions.forEach { binarySearch ->
            val j = binarySearch(xs, xs[i])

            assert(j != null)
            assert(xs[i] == xs[j!!])
        }
    }

    @RepeatedTest(value = 100)
    fun `test random missing`() {
        val size = 11
        val lft = -1024
        val rgt = +1024

        val xs = IntArray(size) { (lft..rgt).random() }.sorted()

        var x = (lft until rgt).random()
        while (xs.contains(x)) {
            x = (lft until rgt).random()
        }

        functions.forEach { binarySearch ->
            val j = binarySearch(xs, x)

            assert(j == null)
        }
    }
}