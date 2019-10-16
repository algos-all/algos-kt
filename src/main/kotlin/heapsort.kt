fun <T> sink(xs: MutableList<T>, index: Int): MutableList<T> where T : Comparable<T> {
    if (index < 0 || index >= xs.size / 2) {
        return xs
    }

    var i = index

    do {
        val leftChild = 2 * i + 1
        val rightChild = leftChild + 1

        val child = when {
            rightChild == xs.size -> leftChild
            xs[leftChild] < xs[rightChild] -> leftChild
            else -> rightChild
        }

        if (xs[i] <= xs[child]) {
            break
        }

        xs[i] = xs[child].also { xs[child] = xs[i] }

        i = child
    } while (i < xs.size / 2)

    return xs
}

fun <T> heapify(xs: MutableList<T>): MutableList<T> where T : Comparable<T> {
    for (i in xs.size / 2 downTo 0) {
        sink(xs, i)
    }

    return xs
}