package data.tools.graphGenerators.factory

import data.tools.graphGenerators.GraphGenerator.GraphGeneratorType
import data.tools.graphGenerators.FlowerSnarkGenerator
import data.tools.graphGenerators.RandomTreeGenerator
import data.tools.graphGenerators.StarGenerator

object GraphGeneratorFactoryImpl : GraphGeneratorFactory {

    override fun getGraphGenerator(type: GraphGeneratorType) = when (type) {
        GraphGeneratorType.RandomTree -> RandomTreeGenerator
        GraphGeneratorType.FlowerSnark -> FlowerSnarkGenerator
        GraphGeneratorType.StarDirected -> StarGenerator.StartDirectedGenerator
        GraphGeneratorType.StarUndirected -> StarGenerator.StartUndirectedGenerator
    }
}