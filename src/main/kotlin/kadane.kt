import java.lang.IllegalArgumentException

/**
 * Given a non-empty array of numbers, find a contiguous sub-array with the largest sum
 *
 * @return the largest sum of the sub-array
 * @link https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm
 */
// TODO: extend to the 2D matrix case!
fun maxSubArray(numbers: IntArray): Int {
    if (numbers.isEmpty()) {
        throw IllegalArgumentException("numbers must not be an empty array")
    }

    var nextSum = numbers[0]
    var bestSum = numbers[0]
    for (i in 1 until numbers.size) {
        nextSum = Integer.max(numbers[i], numbers[i] + nextSum)
        bestSum = Integer.max(bestSum, nextSum)
    }

    return bestSum
}
