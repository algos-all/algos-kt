package core

import org.junit.jupiter.api.Test

class TestListMinMaxOfWith {

    @Test
    fun testMinOfWith() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("amla", 42), Product("banana", 43), Product("mango", 44))

        // How to find the name of the product that has the shortest length?
        // Warning: the empty-case exception is possible!
        val name = products.minOfWith(compareBy { it.length }) { it.name }

        assert(name == "amla")
    }

    @Test
    fun testMinOfWithEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for the name of product that has the shortest length?

        // Approach 1: allow null to be returned
        val name1 = products.minOfWithOrNull(compareBy { it.length }) { it.name }
        assert(name1 == null)

        // Approach 2: catch the empty-case exception
        val name2 = try {
            products.minOfWithOrNull(compareBy { it.length }) { it.name }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(name2 == Unit)
    }

    @Test
    fun testMaxOfWith() {
        // Given the following non-empty list of products:
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("amla", 42), Product("banana", 43), Product("mango", 44))

        // How to find the name of the product that has the biggest length?
        // Warning: the empty-case exception is possible!
        val name = products.maxOfWith(compareBy { it.length }) { it.name }

        assert(name == "banana")
    }

    @Test
    fun testMaxOfWithEmptyCase() {
        // Given an empty list of products:
        data class Product(val name: String, val price: Int)

        val products = emptyList<Product>()

        // How to handle an empty list when searching for the name of product that has the shortest length?

        // Approach 1: allow null to be returned
        val name1 = products.maxOfWithOrNull(compareBy { it.length }) { it.name }
        assert(name1 == null)

        // Approach 2: catch the empty-case exception
        val name2 = try {
            products.maxOfWithOrNull(compareBy { it.length }) { it.name }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }

        assert(name2 == Unit)
    }

}