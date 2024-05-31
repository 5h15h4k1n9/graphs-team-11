package data.tools.graphGenerators

import data.tools.graphGenerators.algorithms.randomTree
import model.graph_model.Graph

object RandomTreeGenerator : GraphGenerator {

    override fun generate(size: Int, maxWeight: Int?, isDirected: Boolean): Graph {
        maxWeight?.let {
            randomTree(size, maxWeight, isDirected)
        }

        return randomTree(size, DEFAULT_WEIGHT, isDirected)
    }

    private const val DEFAULT_WEIGHT = 1
}