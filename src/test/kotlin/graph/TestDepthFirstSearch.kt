package graph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import strikt.api.expectThat
import strikt.assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDepthFirstSearch {
    @Test
    fun `empty graph`() {
        val graph = Graph()
        expectThat(dfs(graph))
            .isA<List<Int>>()
            .isEmpty()
    }

    @Test
    fun `one node`() {
        val graph = Graph()
        graph[42] = mutableListOf()
        expectThat(dfs(graph))
            .isA<List<Int>>()
            .containsExactly(42)
    }

    @Test
    fun `one edge`() {
        val graph = Graph()
        graph[42] = mutableListOf(43)
        graph[43] = mutableListOf()
        expectThat(dfs(graph, 42))
            .isA<List<Int>>()
            .containsExactly(43, 42)
    }

    @Test
    fun `simple chain`() {
        val graph = Graph()
        graph[42] = mutableListOf(43)
        graph[43] = mutableListOf(44)
        graph[44] = mutableListOf()

        expectThat(dfs(graph, 42))
            .isA<List<Int>>()
            .containsExactly(44, 43, 42)
    }

    @Test
    fun `simple fork`() {
        val graph = Graph()
        graph[1] = mutableListOf(3)
        graph[2] = mutableListOf(3)
        graph[3] = mutableListOf(4)
        graph[4] = mutableListOf()

        expectThat(dfs(graph, 1))
            .isA<List<Int>>()
            .containsExactly(4, 3, 1)
        expectThat(dfs(graph, 2))
            .isA<List<Int>>()
            .containsExactly(4, 3, 2)
    }

    @Test
    fun `fully connected square`() {
        val graph = Graph()
        graph[1] = mutableListOf(2, 3, 4)
        graph[2] = mutableListOf(1, 3, 4)
        graph[3] = mutableListOf(1, 2, 4)
        graph[4] = mutableListOf(1, 2, 3)

        for (source in (1 .. 4)) {
            expectThat(dfs(graph, source))
                .isA<List<Int>>()
                .hasSize(4)
                .contains(1, 2, 3, 4)
        }
    }
}