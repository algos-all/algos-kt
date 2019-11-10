fun <T> swim(xs: MutableList<T>, index: Int): MutableList<T> where T : Comparable<T> {
    return swim(xs, index, Comparator { x, y -> x.compareTo(y) })
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
    return sink(xs, index, Comparator { x, y -> x.compareTo(y) })
}

fun <T> sink(xs: MutableList<T>, index: Int, comparator: Comparator<T>): MutableList<T> {
    if (index < 0 || xs.size <= 2 * index + 1) {
        return xs
    }

    var i = index

    do {
        val leftChild = 2 * i + 1
        val rightChild = leftChild + 1

        val child = when {
            rightChild == xs.size -> leftChild
            comparator.compare(xs[leftChild], xs[rightChild]) < 0 -> leftChild
            else -> rightChild
        }

        if (comparator.compare(xs[i], xs[child]) <= 0) {
            break
        }

        xs[i] = xs[child].also { xs[child] = xs[i] }

        i = child
    } while (xs.size > 2 * i + 1)

    return xs
}

fun <T> heapify(xs: MutableList<T>): MutableList<T> where T : Comparable<T> {
    return heapify(xs, Comparator { x, y -> x.compareTo(y) })
}

fun <T> heapify(xs: MutableList<T>, comparator: Comparator<T>): MutableList<T> {
    for (i in xs.size / 2 downTo 0) {
        sink(xs, i, comparator)
    }

    return xs
}