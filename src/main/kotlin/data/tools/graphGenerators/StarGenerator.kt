package data.tools.graphGenerators

import data.tools.graphGenerators.algorithms.starDirected
import data.tools.graphGenerators.algorithms.starUndirected

sealed class StarGenerator: GraphGenerator {

    data object StartUndirectedGenerator : StarGenerator() {
        override fun generate(size: Int, maxWeight: Int?, isDirected: Boolean) = starDirected(size)

    }

    data object StartDirectedGenerator: StarGenerator() {
        override fun generate(size: Int, maxWeight: Int?, isDirected: Boolean) = starUndirected(size)
    }
}