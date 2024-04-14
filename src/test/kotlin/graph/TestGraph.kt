package graph

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.expectThat
import strikt.assertions.*

typealias TransposeType = (graph: Graph) -> Graph

class TestGraph {

    companion object {
        @JvmStatic
        fun transpose(): List<TransposeType> {
            return listOf<TransposeType>(::transposeV1, ::transposeV2, ::transposeV3)
        }
    }

    @ParameterizedTest
    @MethodSource("transpose")
    fun `empty graph`(transpose: TransposeType) {
        assert(transpose(Graph()).isEmpty())
    }

    @ParameterizedTest
    @MethodSource("transpose")
    fun `one node`(transpose: TransposeType) {
        val graphOne = Graph()
        graphOne[42] = mutableListOf()

        val graphTwo = transpose(graphOne)

        expectThat(graphTwo)
            .hasSize(1)
            .containsKey(42)
        expectThat(graphTwo[42])
            .isA<MutableList<Int>>()
            .isEmpty()
    }

    @ParameterizedTest
    @MethodSource("transpose")
    fun `one edge`(transpose: TransposeType) {
        val graphOne = Graph()
        graphOne[42] = mutableListOf()
        graphOne[43] = mutableListOf()
        graphOne[42]?.add(43)

        val graphTwo = transpose(graphOne)

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

    @ParameterizedTest
    @MethodSource("transpose")
    fun `simple cycle`(transpose: TransposeType) {
        val graphOne = Graph()
        graphOne[42] = mutableListOf(43)
        graphOne[43] = mutableListOf(42)

        val graphTwo = transpose(graphOne)

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