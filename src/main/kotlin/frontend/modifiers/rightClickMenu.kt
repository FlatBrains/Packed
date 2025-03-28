package frontend.modifiers

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.window.PopupProperties
import frontend.Mocha
import frontend.Shapes
import frontend.Typography
import frontend.components.ContextMenuScope


@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun Modifier.rightClickMenu(
    content: @Composable ContextMenuScope.() -> Unit
): Modifier {
    
    var open by remember { mutableStateOf(false) } // state
    var mousePosition by remember { mutableStateOf(IntOffset(0, 0)) } // current, up to date
    var currentOffset by remember { mutableStateOf(IntOffset(0, 0)) } // pinned cache
    
    if(open) {
        Popup(
            onDismissRequest = { open = false },
            alignment = androidx.compose.ui.Alignment.TopStart,
            offset = currentOffset,
            properties = PopupProperties(focusable = true)
        ) {
            Column(
                Modifier
                    .border(BorderStroke(1.dp, Mocha.Surface0), Shapes.small)
                    .background(Mocha.Base, MaterialTheme.shapes.small)
                    .padding(10.dp)
                    .width(300.dp)
            ) {
                LocalTextStyle.providesDefault(Typography.body1)
                
                with(ContextMenuScope { open = false } ) {
                    content()
                }
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