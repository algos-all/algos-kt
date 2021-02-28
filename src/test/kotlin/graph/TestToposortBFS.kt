package graph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.containsExactly
import strikt.assertions.isA
import strikt.assertions.isEmpty

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestToposortBFS {
    @Test
    fun `toposort empty graph`() {
        val graph = Graph()
        expectThat(toposortBFS(graph))
            .isA<List<Int>>()
            .isEmpty()
    }

    @Test
    fun `toposort single node`() {
        val graph = Graph()
        graph[42] = mutableListOf()
        expectThat(toposortBFS(graph))
            .isA<List<Int>>()
            .containsExactly(42)
    }

    @Test
    fun `toposort one edge`() {
        val graph = Graph()
        graph[42] = mutableListOf(43)
        graph[43] = mutableListOf()
        expectThat(toposortBFS(graph))
            .isA<List<Int>>()
            .containsExactly(42, 43)
    }

    @Test
    fun `toposort a simple fork`() {
        val graph = Graph()
        graph[1] = mutableListOf(3)
        graph[2] = mutableListOf(3)
        graph[3] = mutableListOf(4)
        graph[4] = mutableListOf()

        val order = toposortBFS(graph)
        expectThat(order)
            .isA<List<Int>>()
        expectThat(order.subList(0, 2))
            .contains(2, 1)
        expectThat(order.subList(2, 4))
            .containsExactly(3, 4)
    }
}