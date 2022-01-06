package math

/**
 * Manual division: division without the "/" operator
 */
fun mDivide(n: Int, d: Int): Int {
    if (n < 0 || d < 0) {
        throw IllegalArgumentException("must be non-negative")
    }
    if (d == 0) {
        throw IllegalArgumentException("divisor must be != 0")
    }
    if (n == 0) {
        return 0
    }

    var t = n;
    var b = 0;
    while (t != 0) {
        t = t shr 1
        b += 1
    }

    var r = 0;
    var q = 0;
    for (i in b - 1 downTo 0) {
        r = r shl 1
        q = q shl 1
        r = r or ((n shr i) and 1)
        if (r >= d) {
            q = q or 1
            r -= d
        }
    }

    return q
}