package data.tools.graphGenerators.factory

import data.tools.graphGenerators.AbstractGraphGenerator
import data.tools.graphGenerators.GraphGenerator

interface GraphGeneratorFactory {

    fun getGraphGenerator(type: AbstractGraphGenerator.GraphGeneratorType): GraphGenerator
}