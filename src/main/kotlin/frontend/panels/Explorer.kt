package frontend.panels

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.InsertDriveFile
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.FolderOpen
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import backend.Backend
import backend.debug.logger
import common.Utilities.searchItems
import frontend.components.Image
import frontend.components.ScrollableLazyColumn
import java.io.File

@Preview
@Composable
fun Explorer(modifier: Modifier, scrollState: ScrollState) {
    var query by remember { mutableStateOf("") }
    val filteredItems = searchItems(query, Backend.loadedItems.map { it.key })

    //filteredItems.forEach { Global.logger.info(it.path) }


    data class Folder(
        val folders: MutableMap<String, Folder> = mutableMapOf(),
        val files: MutableMap<String, String> = mutableMapOf()
    )
    {
        fun initFolders(path: List<String> ): Folder {
            if (path.isEmpty()) return this

            var current = this
            path.forEach {
                if (current.folders[it] == null) { current.folders[it] = Folder() }
                current = current.folders[it] ?: Folder().also { logger.severe("wtf????") }
            }

            return current

        }

        @Composable
        fun render(name: String? = null, depth: Int = 0 ) {

            var open by remember { mutableStateOf(true) }

            Column() {

                if (name != null) TextButton( { open = !open }, Modifier.fillMaxWidth()) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )  {

                        Spacer(Modifier.width(20.dp * (depth-1)))
                        Icon(if (open) Icons.Outlined.FolderOpen else Icons.Outlined.Folder, null, modifier = Modifier.size(24.dp))
                        Spacer(Modifier.width(5.dp))
                        Text(name)
                    }
                }


                if (open) Column {

                    folders.forEach { Row { it.value.render(it.key, depth + 1) } }

                    files.forEach { file ->

                        TextButton({ Backend.itemSelection.value = File(file.value) }, Modifier.fillMaxWidth()) {

                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(Modifier.width(20.dp * depth))
                                Image(Icons.AutoMirrored.Outlined.InsertDriveFile)
                                Spacer(Modifier.width(5.dp))
                                Text(file.key)

                            }
                        }
                    }
                }
            }
        }
    }

    val structure = Folder()

    filteredItems.forEach {


        val split = it.path.replace("\\", "/").replace("${Backend.Pack.base}/", "").split("/")

        //logger.info(split.toString())
        //logger.info(Backend.Pack.current.items)

        val path = split.subList(0, split.size-1)

        structure.initFolders(path).files[it.name] = it.path

        //logger.info(structure.toString())
    }



    Column(modifier = modifier.fillMaxHeight().padding(8.dp)) {
        TextField(
            value = query,
            onValueChange = { query = it },
            leadingIcon = { Icon(Icons.Filled.Search, null) },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        )

        Spacer(Modifier.height(10.dp))

        Surface(color = MaterialTheme.colors.surface, shape = MaterialTheme.shapes.small) {
            ScrollableLazyColumn(contentPadding = PaddingValues(0.dp)) {
                items(1) { structure.render() }
            }
        }
    }
}