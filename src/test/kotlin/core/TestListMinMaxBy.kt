package core

import org.junit.jupiter.api.Test

class TestListMinMaxBy {

    @Test
    fun testMinBy() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("cucumber", 44))

        // How to find the cheapest product in this list?
        // Warning: the empty-case exception is possible!
        val product = products.minBy { it.price }

        assert(product.name == "apple")
    }

    @Test
    fun testMinByEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for least expensive product?

        // Approach 1: allow null to be returned
        val product1 = products.minByOrNull { it.price }
        assert(product1 == null)

        // Approach 2: catch the empty-case exception
        val product2 = try {
            products.minBy { it.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(product2 == Unit)
    }

    @Test
    fun testMaxBy() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("cucumber", 44))

        // How to find the most expensive product in this list?
        // Warning: the empty-case exception is possible!
        val product = products.maxBy { it.price }

        assert(product.name == "cucumber")
    }

    @Test
    fun testMaxByEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for most expensive product?

        // Approach 1: allow null to be returned
        val product1 = products.maxByOrNull { it.price }
        assert(product1 == null)

        // Approach 2: catch the empty-case exception
        val product2 = try {
            products.maxBy { it.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(product2 == Unit)
    }
}