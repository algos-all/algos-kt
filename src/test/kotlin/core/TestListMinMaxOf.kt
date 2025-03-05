package core

import org.junit.jupiter.api.Test

class TestListMinMaxOf {

    @Test
    fun testMinOf() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("cucumber", 44))

        // How to find the smallest product price in the list?
        // Warning: the empty-case exception is possible!
        val price = products.minOf { it.price }

        assert(price == 42)
    }

    @Test
    fun testMinOfEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for smallest price?

        // Approach 1: allow null to be returned
        val price1 = products.minOfOrNull { it.price }
        assert(price1 == null)

        // Approach 2: catch the empty-case exception
        val price2 = try {
            products.minOf { it.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(price2 == Unit)
    }

    @Test
    fun testMaxOf() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("cucumber", 44))

        // How to find the largest product price in the list?
        // Warning: the empty-case exception is possible!
        val price = products.maxOf { it.price }

        assert(price == 44)
    }

    @Test
    fun testMaxOfEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for largest price?

        // Approach 1: allow null to be returned
        val price1 = products.maxOfOrNull { it.price }
        assert(price1 == null)

        // Approach 2: catch the empty-case exception
        val price2 = try {
            products.maxOf { it.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(price2 == Unit)
    }
}