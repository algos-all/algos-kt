package search

/**
 * Given the string, compute its Z-function zs
 *
 * Z-function computes a list zs that has the same length as the given string.
 * Every value zs[i] is the maximum length of a substring that begins at index
 * i and matches the prefix of the string.
 *
 * To compute the list efficiently, let's keep the [lft, rgt] indices of the
 * rightmost segment match. To compute the value of the Z-function at index i,
 * consider two possibilities:
 *
 * Case 1: i > rgt -- the current position is outside the rightmost segment
 *
 *   Compute zs[i] with the trivial algorithm. Please note that the [lft, rgt]
 *   rightmost segment will have to move to [i, i + zs[i]] afterwards.
 *
 * Case 2: i <= rgt -- the current position is inside the rightmost segment
 *
 *   Use the already computed Z-values to initialize zs[i], and then increase
 *   zs[i] to the correct value if the substring matches.
 *
 *   Observe that s[lft, rgt] exactly matches s[0, rgt - lft], so the initial
 *   approximation could be zs[i - lft]. However, zs[i - lft] can be too large:
 *
 *   a a a a b a a
 *   ------------^
 *   7 3 2 1 0 2 ?
 *
 *   The initial value for ? becomes zs[6 - 5] = 3, which is past the end of s.
 *   So clamp the initial value: zs[i] = Integer.min(rgt - i + 1, zs[i - lft])
 *
 * See: https://cp-algorithms.com/string/z-function.html
 */
fun zFunction(s: String): IntArray {
    val zs = IntArray(s.length)
    var (lft, rgt) = listOf(0, 0)
    for (i in s.indices) {
        if (i <= rgt) {
            zs[i] = Integer.min(rgt - i + 1, zs[i - lft])
        }
        while (i + zs[i] < s.length && s[zs[i]] == s[i + zs[i]]) {
            ++zs[i]
        }
        if (i + zs[i] - 1 > rgt) {
            lft = i
            rgt = i + zs[i] - 1
        }
    }
    return zs
}