package model.graph_model.graph_model_actions


class Update(
    val nodeViewUpdate: MutableMap<String, NodeViewUpdate> = mutableMapOf(),
    val vertViewUpdate: MutableMap<String, MutableMap<String, VertViewUpdate>> = mutableMapOf()
) {
    operator fun plus(other: Update): Update {

        val sumUpdate = Update()

        for ((node, _) in this.nodeViewUpdate) {
            if (node in other.nodeViewUpdate) {
                sumUpdate.nodeViewUpdate[node] = NodeViewUpdate(
                    offset = other.nodeViewUpdate[node]?.offset ?: this.nodeViewUpdate[node]?.offset,
                    radius = other.nodeViewUpdate[node]?.radius ?: this.nodeViewUpdate[node]?.radius,
                    color = other.nodeViewUpdate[node]?.color ?: this.nodeViewUpdate[node]?.color,
                    shape = other.nodeViewUpdate[node]?.shape ?: this.nodeViewUpdate[node]?.shape,
                    alpha = other.nodeViewUpdate[node]?.alpha ?: this.nodeViewUpdate[node]?.alpha
                )
            } else {
                sumUpdate.nodeViewUpdate[node] = this.nodeViewUpdate[node]!!
            }
        }
        for ((node, _) in other.nodeViewUpdate) {
            if (node !in sumUpdate.nodeViewUpdate) sumUpdate.nodeViewUpdate[node] = other.nodeViewUpdate[node]!!
        }

        for ((u, verts) in this.vertViewUpdate) {
            sumUpdate.vertViewUpdate[u] = mutableMapOf()
            for ((v, update) in verts) {
                var exist = false
                if (u in other.vertViewUpdate) {
                    val otherVerts = other.vertViewUpdate[u]!!
                    if (v in otherVerts) {
                        exist = true
                        sumUpdate.vertViewUpdate[u]?.set(
                            v,
                            VertViewUpdate(
                                color = other.vertViewUpdate[u]?.get(v)?.color ?: update.color,
                                alpha = other.vertViewUpdate[u]?.get(v)?.alpha ?: update.alpha
                            )
                        )
                    }
                }
                if (!exist) {
                    sumUpdate.vertViewUpdate[u]?.set(v, update)
                }
            }
        }

        for ((u, verts) in other.vertViewUpdate) {
            for ((v, update) in verts) {
                var exist = false
                if (u in sumUpdate.vertViewUpdate) {
                    val otherVerts = sumUpdate.vertViewUpdate[u]!!
                    if (v in otherVerts) {
                        exist = true
                    }
                }
                if (!exist) {
                    sumUpdate.vertViewUpdate[u]?.set(v, update)
                }
            }
        }
        return sumUpdate
    }
}