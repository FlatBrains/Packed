package frontend.menus

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import frontend.DarkColorPalette
import frontend.Mocha
import frontend.Shapes
import frontend.Typography
import frontend.panels.editor.Editor
import frontend.panels.editor.Explorer
import frontend.panels.editor.Sidebar
import org.jetbrains.compose.splitpane.ExperimentalSplitPaneApi
import org.jetbrains.compose.splitpane.HorizontalSplitPane
import org.jetbrains.compose.splitpane.rememberSplitPaneState
import java.awt.Cursor

@OptIn(ExperimentalSplitPaneApi::class)
@Composable
@Preview
fun EditorScreen() {

    val splitterState = rememberSplitPaneState(0.4F)

    MaterialTheme(colors = DarkColorPalette, shapes = Shapes, typography = Typography ) {
        Surface(color = MaterialTheme.colors.background ) {

            Row(modifier = Modifier.fillMaxSize()) {

                Sidebar()
                HorizontalSplitPane(splitPaneState = splitterState) {
                    first( 300.dp) { Explorer(Modifier.weight(1F), rememberScrollState()) }
                    second(300.dp) { Editor(  Modifier.weight(1F) ) }
                    splitter {
                        visiblePart {
                            Box(
                                Modifier
                                    .width(1.dp)
                                    .fillMaxHeight()
                                    .background(MaterialTheme.colors.background)
                            )
                        }
                        handle {
                            Box(
                                Modifier
                                    .markAsHandle()
                                    .pointerHoverIcon(PointerIcon(Cursor(Cursor.E_RESIZE_CURSOR)))
                                    .background(Mocha.Overlay0.copy(alpha = 0.2F), MaterialTheme.shapes.small)
                                    .width(9.dp)
                                    .fillMaxHeight()
                            ) {}
                        }
                    }
                }
            }
        }
    }
}