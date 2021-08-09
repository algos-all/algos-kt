package graph

/**
 * Perform a topological sort of a directed graph using the Kahn's algorithm
 *
 * A topological sort is possible if and only if the graph has no cycles
 *
 * @return a list of the vertices such that for every directed edge from vertex
 *         u to vertex v in the graph, u comes before v in the ordering.
 * @see: https://en.wikipedia.org/wiki/Topological_sorting
 * @see: https://en.wikipedia.org/wiki/Topological_sorting#Kahn's_algorithm
 */
fun toposortBFS(graph: Graph): List<Int> {
    val transposed = transposeV2(graph)
    val initial = graph.keys.filter { transposed[it]?.isEmpty() == true }
    return bfs(graph, initial.toHashSet())
}