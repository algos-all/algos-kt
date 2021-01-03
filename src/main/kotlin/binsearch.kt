/**
 * Perform binary search for a specific value in the given sorted list
 *
 * @param xs a sorted list
 * @param x the target value
 * @return an index if the value is found, or null if not
 */
fun <T> binarySearch0(xs: List<T>, x: T): Int? where T : Comparable<T> {
    var (lft, rgt) = listOf(0, xs.size - 1)

    while (lft <= rgt) {
        val mid = lft + (rgt - lft) / 2

        when {
            xs[mid] == x -> {
                return mid
            }
            xs[mid] < x -> {
                lft = mid + 1
            }
            xs[mid] > x -> {
                rgt = mid - 1
            }
        }
    }

    return null
}


/**
 * Perform binary search for a specific value in the given sorted list
 *
 * @param xs a sorted list
 * @param x the target value
 * @return an index if the value is found, or null if not
 */
fun <T> binarySearch1(xs: List<T>, x: T): Int? where T : Comparable<T> {
    var (lft, rgt) = listOf(0, xs.size)

    while (lft < rgt) {
        val mid = lft + (rgt - lft) / 2

        when {
            xs[mid] == x -> {
                return mid
            }
            xs[mid] < x -> {
                lft = mid + 1
            }
            xs[mid] > x -> {
                rgt = mid
            }
        }
    }

    return null
}