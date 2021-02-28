package graph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import strikt.api.expectThat
import strikt.assertions.containsExactly

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestBreadthFirstSearch {
    @Test
    fun `one node`() {
        val graph = Graph()
        graph[42] = mutableListOf()

        expectThat(bfs(graph, 42))
            .containsExactly(42)
    }

    @Test
    fun `one edge`() {
        val graph = Graph()
        graph[42] = mutableListOf(43)
        graph[43] = mutableListOf()

        expectThat(bfs(graph, 42))
            .containsExactly(42, 43)
        expectThat(bfs(graph, 43))
            .containsExactly(43)
    }

    @Test
    fun `simple chain`() {
        val graph = Graph()
        graph[42] = mutableListOf(43)
        graph[43] = mutableListOf(44)
        graph[44] = mutableListOf()

        expectThat(bfs(graph, 42))
            .containsExactly(42, 43, 44)
        expectThat(bfs(graph, 43))
            .containsExactly(43, 44)
        expectThat(bfs(graph, 44))
            .containsExactly(44)
    }

    @Test
    fun `simple fork one`() {
        val graph = Graph()
        graph[1] = mutableListOf(3)
        graph[2] = mutableListOf(3)
        graph[3] = mutableListOf(4)
        graph[4] = mutableListOf()

        expectThat(bfs(graph, hashSetOf(1, 2)))
            .containsExactly(1, 2, 3, 4)
    }
}