package search

/**
 * Implement the Boyer-Moore-Horspool string search algorithm
 *
 * Worst-case complexity is O(nm)
 *
 * @return if the pattern was found, return the index
 *         otherwise, return the length of the text
 * @see: https://en.wikipedia.org/wiki/Boyer-Moore-Horspool_algorithm
 */
fun search(text: String, pattern: String): Int {
    // Step 1: prepare
    val jumpTable = HashMap<Char, Int>()

    pattern.forEachIndexed { i, c -> jumpTable[c] = pattern.length - i - 1 }

    // Step 2: search
    var leftToRight = 0
    while (text.length - leftToRight >= pattern.length) {
        var rightToLeft = pattern.length - 1
        while (text[leftToRight + rightToLeft] == pattern[rightToLeft]) {
            if (rightToLeft == 0) {
                // Found pattern in text:
                return leftToRight
            }

            --rightToLeft
        }

        leftToRight += jumpTable.getOrDefault(text[leftToRight + pattern.length - 1], pattern.length)
    }

    // Failed to find pattern in text:
    return text.length
}

