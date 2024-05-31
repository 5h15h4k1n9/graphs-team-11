package data.tools.graphGenerators

import model.graph_model.Graph


interface GraphGenerator {

    fun generate(size: Int, maxWeight: Int? = null, isDirected: Boolean = true): Graph

    enum class GraphGeneratorType {
        RandomTree, FlowerSnark, StarDirected, StarUndirected;

        override fun toString(): String = when(this) {
            RandomTree -> "Random Tree"
            FlowerSnark -> "Flower Snark"
            StarDirected -> "Star Directed"
            StarUndirected -> "Star Undirected"
        }

        companion object {
            val DEFAULT_GENERATOR = RandomTree

            @JvmStatic
            fun getAll() = listOf(RandomTree, FlowerSnark, StarDirected, StarUndirected)
        }
    }
}