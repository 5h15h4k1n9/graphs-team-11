package data.graph_save

import model.graph_model.Graph

class GraphLoaderUnified(val path: String) {

    var graph: Graph<String> = Graph()
    init {
        when {
            path.endsWith(".graphml") -> {graph = GraphLoaderML(path).graph}
        }
    }
}