package core

import org.junit.jupiter.api.Test

class TestListMinMaxOf {

    @Test
    fun testMinOf() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.minOf { it.price }

        assert(product == 42)
    }

    @Test
    fun testMaxOf() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.maxOf { it.price }

        assert(product == 44)
    }
}