package frontend.components

import backend.Backend
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.Utilities.openFileWithSpecificApp
import frontend.Icon
import java.io.File

class SidebarButton(
    private val icon: Icon,
    private val onClick: () -> Unit,
) {




    @Composable
    fun render(modifier: Modifier = Modifier) {
        IconButton(onClick = onClick, modifier = modifier.size(45.dp).padding(2.5.dp)) { Image(icon.painter(), null) }
    }

    companion object {
        val buttons = listOf(
            SidebarButton(Icon.Blockbench) {
                openFileWithSpecificApp(
                    File("D:/files/Documents/1.21.4/assets/minecraft/models/item/emerald.json"), Backend.BLOCKBENCH
                )
            },
            SidebarButton(Icon.Blockbench) {
                openFileWithSpecificApp(
                    File("D:/files/Documents/1.21.4/assets/minecraft/models/item/diamond.json"), Backend.BLOCKBENCH
                )
            },
        )
    }
}