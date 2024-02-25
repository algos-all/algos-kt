package core

import org.junit.jupiter.api.Test

class TestListMinMaxWith {

    @Test
    fun testMinWith() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        // How to find the cheapest product in this list?
        // Warning: you're *not* allowed to use minBy!
        // Warning: the empty-case exception is possible!
        val product1 = products.minWith(compareBy { it.price })
        val product2 = products.minWith { lft, rgt -> lft.price.compareTo(rgt.price) }

        assert(product1.name == "apple")
        assert(product2.name == "apple")
    }

    @Test
    fun testMinWithEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for cheapest product?
        // Warning: you're *not* allowed to use minBy!

        // Approach 1: allow null to be returned
        val product1 = products.minWithOrNull(compareBy { it.price })
        assert(product1 == null)

        // Approach 2: catch the empty-case exception
        val product2 = try {
            products.minWith(compareBy { it.price })
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(product2 == Unit)
    }

    @Test
    fun testMaxWith() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        // How to find the cheapest product in this list?
        // Warning: you're *not* allowed to use maxBy!
        // Warning: the empty-case exception is possible!
        val product1 = products.maxWith(compareBy { it.price })
        val product2 = products.maxWith { lft, rgt -> lft.price.compareTo(rgt.price) }

        assert(product1.name == "mango")
        assert(product2.name == "mango")
    }

    @Test
    fun testMaxWithEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for cheapest product?
        // Warning: you're *not* allowed to use maxBy!

        // Approach 1: allow null to be returned
        val product1 = products.maxWithOrNull(compareBy { it.price })
        assert(product1 == null)

        // Approach 2: catch the empty-case exception
        val product2 = try {
            products.maxWith(compareBy { it.price })
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(product2 == Unit)
    }
}