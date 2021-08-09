/**
 * Compute the number of ways to choose k elements out of a pile of n elements
 *
 * The choice happens:
 * a) without repetition (i.e. cannot choose the same element twice)
 * b) without order (i.e. the element is chosen or not, doesn't matter when)
 *
 * @param n the size of the pile (0 or more)
 * @param k the number of elements to choose (0 or more)
 * @return the number of ways to choose k elements out of a pile of n elements
 */
fun binomialCoefficient(n: Int, k: Int): Int {
    // Input arguments are outside of sensible range, return 0 to show that no choice is possible
    if (n <= 0 || k < 0 || k > n) {
        return 0
    }

    if (k == 0 || k == n) {
        return 1
    }

    return (0 until Integer.min(k, n - k)).fold(1L) { total, next ->
        total * (n - next) / (next + 1)
    }.toInt()
}