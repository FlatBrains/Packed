package frontend.panels

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
        
        
        Spacer(Modifier.weight(1F))
        SidebarButton.bottom.forEach {
            it.render(Modifier.align(Alignment.CenterHorizontally))
        }
        
    }
}