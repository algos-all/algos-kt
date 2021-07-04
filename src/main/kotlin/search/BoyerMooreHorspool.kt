package search

/**
 * Implement the Boyer-Moore-Horspool string search algorithm
 *
 * Worst-case complexity is O(nm). It is reached on the following input data:
 *  - a needle of an 'a' char followed by n - 1 'z' chars
 *  - a haystack that consists exclusively of 'z' chars
 * This leads to n - 1 successful comparisons, then a failure. The search then
 * advances one character and the comparisons repeat.
 *
 * The more robust version of this algorithm is Boyer-Moore
 *
 * @return if the pattern was found, return the index
 *         otherwise, return the length of the text
 * @see: https://en.wikipedia.org/wiki/Boyer-Moore-Horspool_algorithm
 */
fun searchBMH(text: String, pattern: String): Int {
    // Step 1: prepare
    val jumpTable = HashMap<Char, Int>()
    val lastIndex = pattern.lastIndex

    pattern.forEachIndexed { i, c -> jumpTable[c] = lastIndex - i }

    // Step 2: search
    var leftToRight = 0
    while (text.length - leftToRight >= pattern.length) {
        var rightToLeft = lastIndex
        while (text[leftToRight + rightToLeft] == pattern[rightToLeft]) {
            if (rightToLeft == 0) {
                // Found pattern in text:
                return leftToRight
            }

            --rightToLeft
        }

        leftToRight += jumpTable.getOrDefault(text[leftToRight + lastIndex], lastIndex) + 1
    }

    // Failed to find pattern in text:
    return text.length
}

