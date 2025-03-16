package frontend.panels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material.icons.sharp.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import backend.Backend
import classes.minecraft.Key
import frontend.Icon
import frontend.Mocha
import frontend.Shapes
import frontend.components.ScrollableColumn
import classes.minecraft.Key.Companion.toKeyString
import classes.minecraft.Key.Companion.toPackPath
import classes.minecraft.lists.structures.Folders
import tasks.ItemTemplate
import tasks.createItem
import java.io.File

@Composable
fun Editor(modifier: Modifier) {
    Surface(modifier.fillMaxHeight().padding(8.dp), shape = MaterialTheme.shapes.small ) {
        ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {


            //IconButton({ createItem(Key("minecraft", "apple"), ItemTemplate.BasicModel) }) { Image(Icons.Sharp.Create, null) }

            Text("Selected Item", fontSize = 20.sp)
            Text(Backend.itemSelection.value?.toKeyString(true) ?: "None")

            Spacer(Modifier.height(20.dp))

            Text("Models", fontSize = 20F.sp)
            Surface( color = Mocha.Crust, shape = Shapes.small, modifier = Modifier.fillMaxWidth(0.9F) ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp)) {
                    Backend.loadedItems[Backend.itemSelection.value]?.model?.modelPaths?.forEach {

                        Row(
                            Modifier.fillMaxWidth().align(Alignment.Start),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {

                            Text(it, Modifier.align(Alignment.CenterVertically).weight(1F))


                            Row ( horizontalArrangement = Arrangement.spacedBy(8.dp))
                            {
                                IconButton(
                                    onClick = { Backend.openWithNotepad(File(it.toPackPath(Folders.Models))) },
                                    modifier = Modifier.height(50.dp)
                                ) { Image(Icon.Notepad.painter(), null) }

                                IconButton(
                                    onClick = { Backend.openWithBlockbench(File(it.toPackPath(Folders.Models))) },
                                    modifier = Modifier.height(50.dp)
                                ) { Image(Icon.Blockbench.painter(), null) }
                            }


                        }


                    } ?: Text("None")
                }
            }

        }

    }
}