package graph

/**
 * Given a graph, run breadth first search starting at a random node
 *
 * @return the order in which the nodes were visited
 */
fun bfs(graph: Graph): List<Int> {
    return if (graph.isEmpty()) listOf() else bfs(graph, graph.keys.random())
}

/**
 * Given a graph and a starting node, run breadth first search
 *
 * @param node the node to start from
 * @return the order in which the nodes were visited
 */
fun bfs(graph: Graph, node: Int): List<Int> {
    return bfs(graph, hashSetOf(node))
}

/**
 * Given a graph and a set of starting nodes, run breadth first search
 *
 * @param nodes the nodes to use as search sources
 * @return the order in which the nodes were visited
 */
fun bfs(graph: Graph, nodes: HashSet<Int>): List<Int> {
    val order = mutableListOf<Int>()
    val skips = HashSet<Int>()

    while (nodes.isNotEmpty()) {
        val nextRound = HashSet<Int>()

        for (node in nodes) {
            skips.add(node)
            order.add(node)

            graph[node]?.filter { !skips.contains(it) }?.forEach {
                nextRound.add(it)
            }
        }

        nodes.clear()
        nodes.addAll(nextRound)
    }

    return order
}