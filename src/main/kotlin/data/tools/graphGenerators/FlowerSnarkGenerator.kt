package data.tools.graphGenerators

import data.tools.graphGenerators.algorithms.flowerSnark
import model.graph_model.Graph


object FlowerSnarkGenerator : GraphGenerator {

    override fun generate(size: Int, maxWeight: Int?, isDirected: Boolean): Graph {
        return flowerSnark(size)
    }
}
