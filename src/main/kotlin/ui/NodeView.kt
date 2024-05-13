package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import model.graph_model.NodeViewClass
import kotlin.math.roundToInt

@Composable
fun <D> NodeView(
    nodeView: NodeViewClass<D>,
    mainOffset: Offset,
    toAbsoluteOffset: (Offset) -> Offset,
    toNotAbsoluteOffset: (Offset) -> Offset,
    selected: SnapshotStateMap<D, Boolean>,
    isShifted: MutableState<Boolean>,
    scaleFactor: Float
) {
    var offset by remember { mutableStateOf(toAbsoluteOffset(nodeView.offset)) }

    Box(Modifier.offset {
        IntOffset(
            ((offset.x - mainOffset.x) * scaleFactor).roundToInt(),
            ((offset.y - mainOffset.y) * scaleFactor).roundToInt()
        )
    }.background(
        MaterialTheme.colors.background,
    ).border(
        if (selected.getOrDefault(nodeView.value, false)) 4.dp else 2.dp,
        color = nodeView.color,
        shape = CircleShape,
    ).size((nodeView.radius * scaleFactor).dp).pointerInput(Unit) {
        detectDragGestures { change, dragAmount ->
            change.consume()
            // there is a problem with the offset calculation
            offset += dragAmount / scaleFactor
            nodeView.offset = toNotAbsoluteOffset(offset)
        }
    }.onPlaced { offset = toAbsoluteOffset(nodeView.offset) }.selectable(selected.getOrDefault(nodeView.value, false)) {
            if (!isShifted.value) {
                selected.forEach { selected.remove(it.key) }
                selected[nodeView.value] = true
            } else {
                selected[nodeView.value] = !selected.getOrDefault(nodeView.value, false)
            }
        }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = nodeView.value.toString(),
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier.wrapContentSize(unbounded = true)
        )
    }
}