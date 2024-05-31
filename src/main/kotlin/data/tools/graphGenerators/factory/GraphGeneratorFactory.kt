package data.tools.graphGenerators.factory

import data.tools.graphGenerators.GraphGenerator

interface GraphGeneratorFactory {

    fun getGraphGenerator(type: GraphGenerator.GraphGeneratorType): GraphGenerator
}