fun <T> sink(xs: MutableList<T>, index: Int): MutableList<T> where T : Comparable<T> {
    if (index < 0 || index >= xs.size / 2) {
        return xs
    }

    var i = index

    do {
        val leftChild = 2 * i
        val rightChild = leftChild + 1

        val child = when {
            rightChild == xs.size -> leftChild
            xs[leftChild] < xs[rightChild] -> leftChild
            else -> rightChild
        }

        xs[i] = xs[child].also { xs[child] = xs[i] }

        i = child
    } while (leftChild < xs.size)

    return xs
}