package core

import org.junit.jupiter.api.Test

class TestMapMinMaxWith {

    @Test
    fun testMaxWith() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("cucumber", 44)

        // Q: How to find the entry with the largest price?
        // Q: You are not allowed to use maxBy!
        val entry1 = map.maxWith(compareBy { it.value.price })
        val entry2 = map.maxWith { lft, rgt -> lft.value.price.compareTo(rgt.value.price) }

        assert(entry1.key == 44)
        assert(entry1.value == Product("cucumber", 44))
        assert(entry2.key == 44)
        assert(entry2.value == Product("cucumber", 44))
    }

    @Test
    fun testMaxWithOrNull() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("cucumber", 44)

        // Q: How to find the entry with the largest price?
        // Q: You are not allowed to use maxBy! Allow null to be returned!
        val entry1 = map.maxWithOrNull(compareBy { it.value.price })
        val entry2 = map.maxWithOrNull { lft, rgt -> lft.value.price.compareTo(rgt.value.price) }

        assert(entry1?.key == 44)
        assert(entry1?.value == Product("cucumber", 44))
        assert(entry2?.key == 44)
        assert(entry2?.value == Product("cucumber", 44))
    }

    @Test
    fun testMaxWithEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for most expensive product?

        // Approach 1: allow null to be returned:
        val entry1 = map.maxWithOrNull(compareBy { it.value.price })
        assert(entry1 == null)

        // Approach 2: catch the empty-case exception:
        val entry2 = try {
            map.maxBy { it.value.price }
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(entry2 == Unit)
    }

    @Test
    fun testMinWith() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("cucumber", 44)

        // Q: How to find the entry with the smallest price?
        // Q: You are not allowed to use minBy!
        val entry1 = map.minWith(compareBy { it.value.price })
        val entry2 = map.minWith() { lft, rgt -> lft.value.price.compareTo(rgt.value.price) }

        assert(entry1.key == 42)
        assert(entry1.value == Product("apple", 42))
        assert(entry2.key == 42)
        assert(entry2.value == Product("apple", 42))
    }

    @Test
    fun testMinWithOrNull() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()
        map[42] = Product("apple", 42)
        map[43] = Product("banana", 43)
        map[44] = Product("cucumber", 44)

        // Q: How to find the entry with the smallest price?
        // Q: You are not allowed to use minBy!
        val entry1 = map.minWithOrNull(compareBy { it.value.price })
        val entry2 = map.minWithOrNull { lft, rgt -> lft.value.price.compareTo(rgt.value.price) }

        assert(entry1?.key == 42)
        assert(entry1?.value == Product("apple", 42))
        assert(entry2?.key == 42)
        assert(entry2?.value == Product("apple", 42))
    }

    @Test
    fun testMinWithEmptyCase() {
        // Given a non-empty map:
        data class Product(val name: String, val price: Int)

        val map = HashMap<Int, Product>()

        // Q: How to handle an empty map when searching for most expensive product?

        // Approach 1: allow null to be returned:
        val entry1 = map.minWithOrNull(compareBy { it.value.price })
        assert(entry1 == null)

        // Approach 2: catch the empty-case exception:
        val entry2 = try {
            map.minWith(compareBy { it.value.price })
        } catch (e: NoSuchElementException) {
            assert(true)
        } catch (e: Throwable) {
            assert(false)
        }

        assert(entry2 == Unit)
    }
}