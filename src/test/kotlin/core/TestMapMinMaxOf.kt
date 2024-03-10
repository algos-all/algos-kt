package core

import org.junit.jupiter.api.Test

class TestMapMinMaxOf {

    @Test
    fun testMaxOf() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the largest price for all products?
        val price = map.maxOf { entry -> entry.value.price }

        assert(price == 44)
    }

    @Test
    fun testMaxOfOrNull() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the largest price for all products? Allow null to be returned.
        val price = map.maxOfOrNull { entry -> entry.value.price }

        assert(price == 44)
    }

    @Test
    fun testMaxOfEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for largest price?

        // Approach 1: allow null to be returned:
        val price1 = map.maxOfOrNull { it.value.price }
        assert(price1 == null)

        // Approach 2: catch the empty-case exception:
        val price2 = try {
            map.maxOf { it.value.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(price2 == Unit)
    }

    @Test
    fun testMinOf() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the smallest price for all products?
        val price = map.minOf { entry -> entry.value.price }

        assert(price == 42)
    }

    @Test
    fun testMinOfOrNull() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("mango", 44)

        // Q: How to find the smallest price for all products? Allow null to be returned.
        val price = map.minOfOrNull { entry -> entry.value.price }

        assert(price == 42)
    }

    @Test
    fun testMinOfEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for smallest price?

        // Approach 1: allow null to be returned:
        val price1 = map.minOfOrNull { it.value.price }
        assert(price1 == null)

        // Approach 2: catch the empty-case exception:
        val price2 = try {
            map.minOf { it.value.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(price2 == Unit)
    }
}