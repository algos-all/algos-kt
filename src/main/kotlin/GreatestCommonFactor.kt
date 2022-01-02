/**
 * Compute the greatest common factor of a pair of integers a and b
 *
 * @param a the first integer in the pair
 * @param b the second integer in the pair
 * @return the greatest common factor of the pair of integers
 */
fun gcf(a: Int, b: Int): Int {
    var (x, y) = listOf(a, b)

    while (y != 0) {
        x = y.also { y = x % y }
    }

    return x
}

/**
 * Compute the extended greatest common factor of a pair of integers a and b
 *
 * @param a the first integer in the pair
 * @param b the second integer in the pair
 * @return (gcd, x, y) such that: a * x + b * y == gcd (Bezout's identity)
 */
fun xgcf(a: Int, b: Int): Array<Int> {
    var (x, y) = listOf(a, b)
    var (s1, s2) = listOf(1, 0)
    var (t1, t2) = listOf(0, 1)

    while (y != 0) {
        val (q, r) = listOf(x / y, x % y)
        x = y.also { y = r }

        s2 = s1 - q * s2.also { s1 = s2 }
        t2 = t1 - q * t2.also { t1 = t2 }
    }

    return arrayOf(x, s1, t1)
}
