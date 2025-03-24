package frontend.modifiers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import frontend.Mocha
import frontend.Typography


@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun Modifier.rightClickMenu(
    content: @Composable ColumnScope.() -> Unit
): Modifier {
    
    var open by remember { mutableStateOf(false) }
    var mousePosition by remember { mutableStateOf(IntOffset(0, 0)) }
    
    var currentOffset by remember { mutableStateOf(IntOffset(0, 0)) }
    
    if(open) {
        Popup(
            onDismissRequest = { open = false },
            alignment = androidx.compose.ui.Alignment.TopStart,
            offset = currentOffset
        ) {
            Column(
                Modifier
                    .background(Mocha.Surface0, MaterialTheme.shapes.small)
                    .padding(10.dp)
            ) {
                LocalTextStyle.providesDefault(Typography.body1)
                content()
            }
        }
    }
    
    
    return this
        .onClick(
            matcher = PointerMatcher.mouse(PointerButton.Secondary),
            onClick = {
                currentOffset = mousePosition
                open = true
            }
        )
        .onPointerEvent(PointerEventType.Move) {
            val offset = it.changes.first().position
            
            mousePosition = IntOffset(offset.x.toInt(), offset.y.toInt())
        }
}
