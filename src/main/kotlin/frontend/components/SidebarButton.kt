package frontend.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import backend.Backend
import backend.debug.logger
import frontend.Mocha

class SidebarButton(
    private val onClick: () -> Unit,
    private val icon: @Composable () -> Unit,
) {




    @Composable
    fun render(modifier: Modifier = Modifier) {
        IconButton(onClick = onClick, modifier = modifier.size(45.dp).padding(2.5.dp), content = icon)
    }
    
    companion object {
        
        val bottom = listOf(
            SidebarButton({ Backend.returnToHome() }) { Image(Icons.AutoMirrored.Filled.ArrowBack, null, colorFilter = ColorFilter.tint(color = Mocha.Text)) }
        )
        
        //val bottom = listOf(
        //    SidebarButton()
        //)
    }
}