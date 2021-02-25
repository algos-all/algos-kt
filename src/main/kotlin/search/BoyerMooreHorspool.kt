package search

/**
 * Implement the Boyer-Moore-Horspool string search algorithm
 *
 * Worst-case complexity is O(nm): on a case where a needle of an 'a' byte followed by n - 1 'z' bytes in a haystack
 * consisting of m 'z' bytes. This will do n - 1 successful comparisons, then fail, advance one character and repeat.
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

