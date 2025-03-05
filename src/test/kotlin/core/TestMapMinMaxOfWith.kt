package core

import org.junit.jupiter.api.Test

class TestMapMinMaxOfWith {

    @Test
    fun testMaxOfWith() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("cucumber", 44)

        // Q: How to find the longest name of any product?
        val name = map.maxOfWith(compareBy { it.length }) { it.value.name }

        assert(name == "cucumber")
    }

    @Test
    fun testMaxOfWithOrNull() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("cucumber", 44)

        // Q: How to find the longest name of any product? Allow null to be returned.
        val name = map.maxOfWithOrNull(compareBy { it.length }) { it.value.name }

        assert(name == "cucumber")
    }

    @Test
    fun testMaxOfWithEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for longest name of any product?

        // Approach 1: allow null to be returned:
        val price1 = map.maxOfWithOrNull(compareBy { it.length }) { it.value.name }
        assert(price1 == null)

        // Approach 2: catch the empty-case exception:
        val price2 = try {
            map.maxOfWith(compareBy { it.length }) { it.value.name }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(price2 == Unit)
    }

    @Test
    fun testMinOfWith() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("tangerine", 44)

        // Q: How to find the shortest name of any product?
        val name = map.minOfWith(compareBy { it.length }) { it.value.name }

        assert(name == "apple")
    }

    @Test
    fun testMinOfWithOrNull() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("tangerine", 44)

        // Q: How to find the shortest name of all products? Allow null to be returned.
        val name = map.minOfWithOrNull(compareBy { it.length }) { it.value.name }

        assert(name == "apple")
    }

    @Test
    fun testMinOfWithEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for shortest name of any product?

        // Approach 1: allow null to be returned:
        val price1 = map.minOfWithOrNull(compareBy { it.length }) { it.value.name }
        assert(price1 == null)

        // Approach 2: catch the empty-case exception:
        val price2 = try {
            map.minOfWith(compareBy { it.length }) { it.value.name }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(price2 == Unit)
    }
}