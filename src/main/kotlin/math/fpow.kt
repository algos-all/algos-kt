package math

/**
 * Raise n to the power of p
 *
 * Use a recursive squaring algorithm to speed up computation
 *
 * @param n the base
 * @param p the power
 * @return the value of n to the power of p
 * @throws IllegalArgumentException if p is negative
 */
fun fastPower0(n: Int, p: Int): Int {
    return when {
        p < 0 -> throw IllegalArgumentException("Power must be non-negative")
        p == 0 -> 1
        p == 1 -> n
        n == 0 -> 0
        else -> fastPower0(n * n, p / 2) * if (p % 2 == 0) 1 else n
    }
}

/**
 * Raise n to the power of p
 *
 * Use an iterative squaring algorithm to speed up computations
 *
 * @param n the base
 * @param p the power
 * @return the value of n to the power of p
 * @throws IllegalArgumentException if p is negative
 */
fun fastPower1(n: Int, p: Int): Int {
    return when {
        p < 0 -> throw IllegalArgumentException("Power must be non-negative")
        p == 0 -> 1
        p == 1 -> n
        n == 0 -> 0
        else -> {
            var a = 1
            var b = n
            var q = p
            while (q != 1) {
                a *= if (q % 2 == 0) 1 else b
                b *= b
                q /= 2
            }

            b * a
        }
    }
}

/**
 * Raise n to the power of p
 *
 * Use an iterative squaring algorithm to speed up computation
 *
 * @param n the base
 * @param p the power
 * @return the value of n to the power of p
 * @throws IllegalArgumentException if p is negative
 */
fun fastPower2(n: Int, p: Int): Int {
    if (p < 0) {
        throw IllegalArgumentException("Power must be non-negative")
    }

    var a = 1
    var b = n
    var q = p

    while (q != 0) {
        if (q % 2 == 1) {
            a *= b
        }

        b *= b
        q /= 2
    }

    return a
}
