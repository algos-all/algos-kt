package core

import org.junit.jupiter.api.Test

class TestMapMinMaxBy {

    @Test
    fun testMaxBy() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the entry with the largest price?
        val entry = map.maxBy { entry -> entry.value.price }

        assert(entry.key == 44)
        assert(entry.value == Product("mango", 44))
    }

    @Test
    fun testMaxByEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for most expensive product?

        // Approach 1: allow null to be returned:
        val entry1 = map.maxByOrNull { it.value.price }
        assert(entry1 == null)

        // Approach 2: catch the empty-case exception:
        val entry2 = try {
            map.maxBy { it.value.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(entry2 == Unit)
    }

    @Test
    fun testMaxByOrNull() {
        // Given a possibly empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the entry with the largest price? Allow null to be returned.
        val entry = map.maxByOrNull { it.value.price }

        assert(entry != null)
        assert(entry?.key == 44)
        assert(entry?.value?.price == 44)
    }

    @Test
    fun testMinBy() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the entry with the smallest price?
        val entry = map.minBy { entry -> entry.value.price }

        assert(entry.key == 42)
        assert(entry.value == Product("apple", 42))
    }

    @Test
    fun testMinByEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for least expensive product?

        // Approach 1: allow null to be returned:
        val entry1 = map.minByOrNull { it.value.price }
        assert(entry1 == null)

        // Approach 2: catch the empty-case exception:
        val entry2 = try {
            map.minBy { it.value.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(entry2 == Unit)
    }

    @Test
    fun testMinByOrNull() {
        // Given a possibly empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the entry with the smallest price? Allow null to be returned.
        val entry = map.minByOrNull { it.value.price }

        assert(entry?.key == 42)
        assert(entry?.value == Product("apple", 42))
    }
}