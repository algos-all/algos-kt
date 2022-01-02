fun fpow0(x: Int, n: Int): Int {
    return when {
        n < 0 -> throw IllegalArgumentException("Power must be non-negative")
        n == 0 -> 1
        n == 1 -> x
        x == 0 -> 0
        else -> fpow0(x * x, n / 2) * if (n % 2 == 0) 1 else x
    }
}


fun fpow1(x: Int, n: Int): Int {
    return when {
        n < 0 -> throw IllegalArgumentException("Power must be non-negative")
        n == 0 -> 1
        n == 1 -> x
        x == 0 -> 0
        else -> {
            var a = x
            var b = 1
            var m = n
            while (m != 1) {
                b *= if (m % 2 == 0) 1 else a
                a *= a
                m /= 2
            }

            a * b
        }
    }
}