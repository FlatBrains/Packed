package frontend.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import frontend.Mocha
import frontend.Shapes
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, DelicateCoroutinesApi::class)
@Composable
fun Modifier.addHoverEffect(
    content: @Composable BoxScope.() -> Unit
): Modifier {
    var isHovered by remember { mutableStateOf(false) }
    var hoverPosition by remember { mutableStateOf(Offset.Zero) }
    
    var isStable by remember { mutableStateOf(false) } // Tracks stability state
    val coroutineScope = rememberCoroutineScope()
    
    var itemSize by remember { mutableStateOf(IntSize.Zero) }
    
    LaunchedEffect(isHovered, hoverPosition) {
        if (isHovered) {
            coroutineScope.launch {
                delay(800) // Wait for 5 seconds
                if (isHovered) {
                    isStable = true // Hover has been stable for 5 seconds
                }
            }
        } else {
            isStable = false // Reset stability state when hover ends
        }
    }
    
    
    
    if (isHovered && isStable) {
        Popup(
            alignment = Alignment.TopStart,
            offset = IntOffset(hoverPosition.x.toInt(), hoverPosition.y.toInt()) - IntOffset(itemSize.width/2,60),
            properties = PopupProperties(focusable = false)
        ) {
            Box(modifier =
                    Modifier.background(color = Mocha.Base, Shapes.small)
                        .onGloballyPositioned { itemSize = it.size }
                        .padding(3.dp)
                
            ) {
                content()
            }
        }
    }
    

    
    return this
        .onPointerEvent(PointerEventType.Move) {
            hoverPosition = it.changes.first().position
            isStable = false
            
            
        }
        .onPointerEvent(PointerEventType.Enter) {
            isHovered = true
            isStable = false
        }
        .onPointerEvent(PointerEventType.Exit) {
            isHovered = false
            isStable = false
        }
    

}