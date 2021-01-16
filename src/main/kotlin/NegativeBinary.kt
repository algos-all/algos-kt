/**
 * Convert an integer to negative binary representation, most significant bit first
 */
fun toNegativeBinary(x: Int): IntArray {
    return toNegativeBinaryR(x).reversedArray()
}

/**
 * Convert an integer to a negative binary representation, least significant bit first
 */
fun toNegativeBinaryR(x: Int): IntArray {
    var y = x
    val bits = mutableListOf<Int>()
    while (y != 0) {
        val r = y.rem(-2)
        bits.add(if (r < 0) r + 2 else r)

        y = y.div(-2) + if (r < 0) 1 else 0
    }

    return if (bits.isEmpty()) IntArray(1) { 0 } else bits.toIntArray()
}

/**
 * Convert from a negative binary representation to an integer, most significant bit first
 */
fun fromNegativeBinary(xs: IntArray): Int {
    return fromNegativeBinaryR(xs.reversedArray())
}

/**
 * Convert from a negative binary representation to an integer, least significant bit first
 */
fun fromNegativeBinaryR(xs: IntArray): Int {
    var n = 0
    var y = 1
    for (x in xs) {
        n += x * y
        y *= -2
    }

    return n
}

/**
 * Add two negative binary numbers, most significant bit first
 */
fun addNegativeBinary(xs: IntArray, ys: IntArray): IntArray {
    if (xs.size > ys.size) {
        return addNegativeBinary(ys, xs)
    }

    return addNegativeBinaryR(xs.reversedArray(), ys.reversedArray()).reversedArray()
}

/**
 * Add two negative binary numbers, least significant bit first
 */
fun addNegativeBinaryR(xs: IntArray, ys: IntArray): IntArray {
    var carry = 0
    val maxSize = Integer.max(xs.size, ys.size)

    val zs = mutableListOf<Int>()
    for (i in 0 until maxSize) {
        val x = if (i < xs.size) xs[i] else 0
        val y = if (i < ys.size) ys[i] else 0

        when (x + y + carry) {
            -1 -> {
                carry = 1
                zs.add(1)
            }
            +0 -> {
                carry = 0
                zs.add(0)
            }
            +1 -> {
                carry = 0
                zs.add(1)
            }
            +2 -> {
                carry = -1
                zs.add(0)
            }
            +3 -> {
                carry = -1
                zs.add(1)
            }
        }
    }

    while (carry != 0) {
        when (carry) {
            -1 -> {
                carry = 1
                zs.add(1)
            }
            +1 -> {
                carry = 0
                zs.add(1)
            }
            +2 -> {
                carry = -1
                zs.add(0)
            }
            +3 -> {
                carry = -1
                zs.add(1)
            }
        }
    }

    val result = zs.dropLastWhile { x -> x == 0 }.toIntArray()
    return if (result.isEmpty()) IntArray(1) { 0 } else result
}

/**
 * Subtract two negative binary numbers, most significant bit first
 */
fun subNegativeBinary(xs: IntArray, ys: IntArray): IntArray {
    return subNegativeBinaryR(xs.reversedArray(), ys.reversedArray()).reversedArray()
}

/**
 * Subtract two negative binary numbers, least significant bit first
 */
fun subNegativeBinaryR(xs: IntArray, ys: IntArray): IntArray {
    var carry = 0
    val maxSize = Integer.max(xs.size, ys.size)

    val zs = mutableListOf<Int>()
    for (i in 0 until maxSize) {
        val x = if (i < xs.size) xs[i] else 0
        val y = if (i < ys.size) ys[i] else 0

        when (x - y + carry) {
            -2 -> {
                carry = 1
                zs.add(0)
            }
            -1 -> {
                carry = 1
                zs.add(1)
            }
            +0 -> {
                carry = 0
                zs.add(0)
            }
            +1 -> {
                carry = 0
                zs.add(1)
            }
            +2 -> {
                carry = -1
                zs.add(0)
            }
        }
    }

    while (carry != 0) {
        when (carry) {
            -2 -> {
                carry = 1
                zs.add(0)
            }
            -1 -> {
                carry = 1
                zs.add(1)
            }
            +1 -> {
                carry = 0
                zs.add(1)
            }
            +2 -> {
                carry = -1
                zs.add(0)
            }
        }
    }

    val result = zs.dropLastWhile { x -> x == 0 }.toIntArray()
    return if (result.isEmpty()) IntArray(1) { 0 } else result
}

