package core

import org.junit.jupiter.api.Test

class TestListMinMaxWith {

    @Test
    fun testMinWith() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.minWith { lft, rgt -> lft.price.compareTo(rgt.price) }

        assert(product.name == "apple")
    }

    @Test
    fun testMaxWith() {
        data class Product(val name: String, val price: Int)

        val products = listOf(Product("apple", 42), Product("banana", 43), Product("mango", 44))

        val product = products.maxWith() { lft, rgt -> lft.price.compareTo(rgt.price) }

        assert(product.name == "mango")
    }
}