class Heap<T> where T : Comparable<T> {
    private val elements: MutableList<T> = mutableListOf()
    private var comparator: Comparator<T>

    constructor() {
        comparator = Comparator { x, y -> x.compareTo(y) }
    }

    constructor(comparator: Comparator<T>) {
        this.comparator = comparator
    }

    constructor(collection: MutableCollection<T>) : this() {
        elements.addAll(collection)

        heapify(elements)
    }

    constructor(collection: MutableCollection<T>, comparator: Comparator<T>): this() {
        elements.addAll(collection)
        this.comparator = comparator

        heapify(elements, comparator)
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun add(element: T) {
        elements.add(element)

        swim(elements, elements.lastIndex, comparator)
    }

    fun peek(): T? {
        if (elements.isEmpty()) {
            return null
        }

        return elements[0]
    }

    fun poll(): T {
        var element = elements.removeAt(elements.lastIndex)

        if (elements.isEmpty()) {
            return element
        }

        element = elements[0].also { elements[0] = element }

        sink(elements, 0, comparator)

        return element
    }
}