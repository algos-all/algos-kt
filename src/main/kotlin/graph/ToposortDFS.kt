package graph

/**
 * Perform a topological sort of a directed graph using the Tarjan's algorithm
 *
 * A topological sort is possible if and only if the graph has no cycles
 *
 * @return a list of the vertices such that for every directed edge from vertex
 *         u to vertex v in the graph, u comes before v in the ordering.
 * @see: https://en.wikipedia.org/wiki/Topological_sorting
 * @see: https://en.wikipedia.org/wiki/Topological_sorting#Depth-first_search
 */
fun toposortDFS(graph: Graph): List<Int> {
    val transposed = transposeV2(graph)
    val initial = graph.keys.filter { transposed[it]?.isEmpty() == true }
    return dfs(graph, initial.toHashSet()).reversed()
}