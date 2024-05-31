package data.tools.graphGenerators

abstract class AbstractGraphGenerator : GraphGenerator {

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