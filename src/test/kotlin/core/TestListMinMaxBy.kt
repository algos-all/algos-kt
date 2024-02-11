package core

import org.junit.jupiter.api.Test

class TestListMinMaxBy {

    @Test
    fun testMinBy() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.minBy { it.price }

        assert(product.name == "apple")
    }

    @Test
    fun testMaxBy() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.maxBy { it.price }

        assert(product.name == "mango")
    }
}