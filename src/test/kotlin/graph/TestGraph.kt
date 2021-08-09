package graph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import strikt.api.expectThat
import strikt.assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestGraph {
    @Test
    fun `empty graph`() {
        assert(transposeV2(Graph()).isEmpty())
    }

    @Test
    fun `one node`() {
        val graphOne = Graph()
        graphOne[42] = mutableListOf()

        val graphTwo = transposeV2(graphOne)

        expectThat(graphTwo)
            .hasSize(1)
            .containsKey(42)
        expectThat(graphTwo[42])
            .isA<MutableList<Int>>()
            .isEmpty()
    }

    @Test
    fun `one edge`() {
        val graphOne = Graph()
        graphOne[42] = mutableListOf()
        graphOne[43] = mutableListOf()
        graphOne[42]?.add(43)

        val graphTwo = transposeV2(graphOne)

        expectThat(graphTwo)
            .isA<Graph>()
            .hasSize(2)
            .containsKeys(42, 43)
        expectThat(graphTwo[42])
            .isA<MutableList<Int>>()
            .isEmpty()
        expectThat(graphTwo[43])
            .isA<MutableList<Int>>()
            .hasSize(1)
            .containsExactly(42)
    }

    @Test
    fun `simple cycle`() {
        val graphOne = Graph()
        graphOne[42] = mutableListOf(43)
        graphOne[43] = mutableListOf(42)

        val graphTwo = transposeV2(graphOne)

        expectThat(graphTwo)
            .isA<Graph>()
            .hasSize(2)
            .containsKeys(42, 43)
        expectThat(graphTwo[42])
            .isA<MutableList<Int>>()
            .hasSize(1)
            .containsExactly(43)
        expectThat(graphTwo[43])
            .isA<MutableList<Int>>()
            .hasSize(1)
            .containsExactly(42)
    }
}