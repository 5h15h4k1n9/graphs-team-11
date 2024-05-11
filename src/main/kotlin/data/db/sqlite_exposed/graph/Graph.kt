package data.db.sqlite_exposed.graph

import data.db.sqlite_exposed.edge.Edge
import data.db.sqlite_exposed.edge.Edges
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Graph(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Graph>(Graphs)

    val name by Graphs.name
    var data by Graphs.data
    var size by Graphs.size
    val edges by Edge referrersOn Edges.graphId
}