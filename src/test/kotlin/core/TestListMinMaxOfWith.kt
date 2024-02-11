package core

import org.junit.jupiter.api.Test

class TestListMinMaxOfWith {

    @Test
    fun testMinOfWith() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.minOfWith(compareBy({ it }, { it })) { it.price }

        assert(product == 42)
    }

    @Test
    fun testMaxOfWith() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.maxOfWith(compareBy({ it }, { it })) { it.price }

        assert(product == 44)
    }
}