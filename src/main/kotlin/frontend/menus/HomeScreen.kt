package frontend.menus

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import frontend.DarkColorPalette
import frontend.Shapes
import frontend.Typography
import frontend.panels.home.openPack
import frontend.panels.home.recentPacks
import org.jetbrains.compose.splitpane.ExperimentalSplitPaneApi
import org.jetbrains.compose.splitpane.HorizontalSplitPane
import org.jetbrains.compose.splitpane.rememberSplitPaneState
import java.awt.Cursor

@OptIn(ExperimentalMaterialApi::class, ExperimentalSplitPaneApi::class)
@Preview
@Composable
fun HomeScreen() {
    
    
    val splitterState = rememberSplitPaneState(0.5F)
    
    MaterialTheme(colors = DarkColorPalette, shapes = Shapes, typography = Typography ) {
        Surface(color = MaterialTheme.colors.background ) {
            
            Row(modifier = Modifier.fillMaxSize()) {
                HorizontalSplitPane(splitPaneState = splitterState) {
                    first( 500.dp) { recentPacks() }
                    second(400.dp) { openPack() }
                    splitter {
                        handle {
                            Box(
                                Modifier
                                    .markAsHandle()
                                    .pointerHoverIcon(PointerIcon(Cursor(Cursor.E_RESIZE_CURSOR)))
                                    .width(11.dp)
                                    .fillMaxHeight()
                            ) {}
                        }
                    }
                }
            }
        }
    }


        //Row(modifier = Modifier.fillMaxSize().background(Mocha.Crust), horizontalArrangement = Arrangement.Center ) {}
    
}
