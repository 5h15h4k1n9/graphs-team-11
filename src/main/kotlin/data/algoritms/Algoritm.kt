package data.algoritms

import androidx.compose.ui.graphics.Color
import data.Graph
import ui.graph_view.graph_view_actions.NodeViewUpdate

abstract class Algoritm {
    open fun <D>alogRun(graph: Graph<D>): MutableMap<D, NodeViewUpdate<D>> {
        return mutableMapOf()
    }
}