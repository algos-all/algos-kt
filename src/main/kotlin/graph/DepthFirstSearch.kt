package graph

/**
 * Given a graph, run depth first search starting at a random node
 *
 * @return the order in which the nodes were visited
 */
fun dfs(graph: Graph): List<Int> {
    return if (graph.isEmpty()) listOf() else dfs(graph, graph.keys.random())
}

/**
 * Given a graph and a starting node, run depth first search
 *
 * @return the order in which the nodes were visited
 */
fun dfs(graph: Graph, node: Int): List<Int> {
    return dfs(graph, hashSetOf(node))
}

/**
 * Given a graph and a set of starting nodes, run depth first search
 *
 * @return the order in which the nodes were visited
 */
fun dfs(graph: Graph, nodes: HashSet<Int>): List<Int> {
    return dfs(graph, nodes, hashSetOf())
}

/**
 * Run depth first search on a graph given a starting node and a skip set
 *
 * @param node the node to start from
 * @param skips the nodes *not* to visit
 * @return the order in which the nodes were visited
 */
fun dfs(graph: Graph, node: Int, skips: HashSet<Int>): List<Int> {
    return dfs(graph, hashSetOf(node), skips)
}

/**
 * Run depth first search on a graph gives a starting set and a skip set
 *
 * @param nodes the nodes to start from
 * @param skips the nodes *not* to visit
 * @return the order in which the nodes were visited
 */
fun dfs(graph: Graph, nodes: HashSet<Int>, skips: HashSet<Int>): List<Int> {
    val order = mutableListOf<Int>()

    for (node in nodes) {
        if (!skips.contains(node)) {
            skips.add(node)

            graph[node]?.forEach {
                if (!skips.contains(it)) {
                    order.addAll(dfs(graph, hashSetOf(it), skips))
                }
            }

            order.add(node)
        }
    }

    return order
}