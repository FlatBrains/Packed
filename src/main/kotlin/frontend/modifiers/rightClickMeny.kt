package frontend.modifiers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.onClick
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerButton


@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun Modifier.rightClickMenu(
    content: @Composable BoxScope.() -> Unit
): Modifier {
    
    var open by remember { mutableStateOf(false) }
    
    
    
    
    
    return this.onClick(
            matcher = PointerMatcher.mouse(PointerButton.Secondary),
            onClick = {
                open = true
            }
        )
}