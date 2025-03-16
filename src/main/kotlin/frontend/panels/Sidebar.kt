package frontend.panels

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import frontend.components.SidebarButton

@Preview
@Composable
fun Sidebar() {
    Column(modifier = Modifier.width(50.dp).fillMaxHeight()) {
        SidebarButton.buttons.forEach {
            it.render(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}