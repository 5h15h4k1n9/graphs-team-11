package data.tools.graphGenerators

import model.graph_model.Graph


interface GraphGenerator {

    fun generate(size: Int, maxWeight: Int? = null, isDirected: Boolean = true): Graph
 }