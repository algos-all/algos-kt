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
