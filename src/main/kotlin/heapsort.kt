fun <T> swim(xs: MutableList<T>, index: Int): MutableList<T> where T : Comparable<T> {
    return swim(xs, index) { x, y -> x.compareTo(y) }
}

fun <T> swim(xs: MutableList<T>, index: Int, comparator: Comparator<T>): MutableList<T> {
    var i = index

    while (i != 0) {
        val parent = (i - 1) / 2

        if (comparator.compare(xs[parent], xs[index]) <= 0) {
            break
        }

        xs[parent] = xs[index].also { xs[index] = xs[parent] }

        i = parent
    }

    return xs
}

fun <T> sink(xs: MutableList<T>, index: Int): MutableList<T> where T : Comparable<T> {
    return sink(xs, index) { x, y -> x.compareTo(y) }
}

fun <T> sink(xs: MutableList<T>, index: Int, comparator: Comparator<T>): MutableList<T> {
    if (index < 0 || index >= xs.size && index != 0) {
        throw IllegalArgumentException("index must be in [0, xs.size), was $index, which is not in [0, ${xs.size})")
    }

    var (i, lftChild) = listOf(index, 2 * index + 1)

    while (lftChild < xs.size) {
        val rgtChild = lftChild + 1

        val child = if (rgtChild < xs.size && comparator.compare(xs[rgtChild], xs[lftChild]) < 0) {
            rgtChild
        } else {
            lftChild
        }

        if (comparator.compare(xs[i], xs[child]) <= 0) {
            break
        }

        xs[i] = xs[child].also { xs[child] = xs[i] }

        i = child; lftChild = 2 * child + 1
    }

    return xs
}

fun <T> heapify(xs: MutableList<T>): MutableList<T> where T : Comparable<T> {
    return heapify(xs) { x, y -> x.compareTo(y) }
}

fun <T> heapify(xs: MutableList<T>, comparator: Comparator<T>): MutableList<T> {
    for (i in xs.size / 2 downTo 0) {
        sink(xs, i, comparator)
    }

    return xs
}