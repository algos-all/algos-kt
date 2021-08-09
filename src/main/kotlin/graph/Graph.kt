package graph

typealias Graph = HashMap<Int, MutableList<Int>>

/**
 * Given a directed graph, reverse all edges in it
 *
 * See: https://en.wikipedia.org/wiki/Glossary_of_graph_theory#transpose
 */
fun transposeV1(graph: Graph): Graph {
    val result = Graph()

    for ((source, nodes) in graph.entries) {
        result.putIfAbsent(source, mutableListOf())

        for (node in nodes) {
            result.putIfAbsent(node, mutableListOf())
            result[node]?.add(source)
        }
    }

    return result
}

fun transposeV2(graph: Graph): Graph {
    val result = Graph()

    for (node in graph.keys) {
        result.putIfAbsent(node, mutableListOf())

        graph[node]?.forEach {
            result.putIfAbsent(it, mutableListOf())
            result[it]?.add(node)
        }
    }

    return result
}
