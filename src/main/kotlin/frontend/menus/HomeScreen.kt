package frontend.menus

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.FolderOpen
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import backend.Backend
import backend.debug.logger
import common.DirectorySelector
import frontend.DarkColorPalette
import frontend.Mocha
import frontend.Shapes
import frontend.Typography
import frontend.modifiers.rightClickMenu
import java.io.File

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun HomeScreen() {

    var packPathInput by remember { mutableStateOf("") }
    var packPath by remember { mutableStateOf<String?>(null) }
    var namespace by remember { mutableStateOf<String?>(null) }
    var dropDownMenuExpanded by remember { mutableStateOf(false) }
    val verifier = { Backend.verifyPack(File(packPath ?: "null"), namespace ?: "null") }
    var verified by remember { mutableStateOf(verifier()) }

    fun updatePackPathTextField(it: String) {
        packPathInput = it
        packPath = if (File("$it/assets").exists()) it.also { logger.info("Valid pack found!") } else null
        namespace = null
        dropDownMenuExpanded = false
        logger.info("Pack Path Input: $it")
        logger.info("Pack Path: $packPath")
        verified = verifier()
    }


    MaterialTheme(colors = DarkColorPalette, shapes = Shapes, typography = Typography ) {


        Row(modifier = Modifier.fillMaxSize().background(Mocha.Crust), horizontalArrangement = Arrangement.Center ) {

            
            Column(modifier = Modifier.fillMaxHeight().weight(1F).background(Mocha.Mantle), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Recent Packs", color = Mocha.Text, fontSize = 30.sp)
                    Spacer(Modifier.padding(20.dp))
                    Column {
                        if (Backend.cache.history.size != 0) {
                            Row(Modifier.fillMaxWidth(0.5F)) {
                                Spacer(Modifier.width(5.dp))
                                Text(File("Name").name, color = Mocha.Overlay1)
                                Spacer(modifier = Modifier.weight(1F))
                                Text("Namespace", color = Mocha.Overlay1)
                                Spacer(Modifier.width(5.dp))
                            }
                            
                            Spacer(Modifier.height(10.dp))
                            
                            Backend.cache.history.forEach {
                                Row(Modifier.fillMaxWidth(0.5F)) {
                                    TextButton(
                                        { Backend.launch(File(it.path), it.namespace) },
                                        modifier = Modifier.rightClickMenu { Text("${it.path}/assets/${it.namespace}", color = Mocha.Text, fontSize = 10.sp) }
                                    ) {
                                        Text(File(it.path).name, color = Mocha.Text)
                                        Spacer(modifier = Modifier.weight(1F))
                                        Text(it.namespace, color = Mocha.Text)
                                    }
                                    
                                }
                            }
                        } else {
                            Text("None, yet...", color = Mocha.Text)
                        }
                    }
                    
                }
            }
            Column(modifier = Modifier.fillMaxHeight().weight(1F).background(Mocha.Base), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    
                    Text("Open Pack", color = Mocha.Text, fontSize = 30.sp)
                    
                    Spacer(Modifier.padding(20.dp))
                    
                    val textFieldColors: TextFieldColors =
                        if (packPath == null) TextFieldDefaults.textFieldColors(textColor = Mocha.Text)
                        else TextFieldDefaults.textFieldColors(
                            focusedLabelColor = Mocha.Green,
                            unfocusedLabelColor = Mocha.Green,
                            focusedIndicatorColor = Mocha.Green,
                            unfocusedIndicatorColor = Mocha.Green,
                            cursorColor = Mocha.Green,
                            textColor = Mocha.Text
                        )
                    
                    val namespaceFieldColors: TextFieldColors =
                        if (namespace == null) TextFieldDefaults.textFieldColors(textColor = Mocha.Text)
                        else TextFieldDefaults.textFieldColors(
                            focusedLabelColor = Mocha.Green,
                            unfocusedLabelColor = Mocha.Green,
                            focusedIndicatorColor = Mocha.Green,
                            unfocusedIndicatorColor = Mocha.Green,
                            cursorColor = Mocha.Green,
                            textColor = Mocha.Text
                        )
                    
                    val buttonColor: ButtonColors =
                        if (!verified && packPath != null && namespace != null) {
                            ButtonDefaults.buttonColors(
                                disabledContentColor = Mocha.Red,
                                backgroundColor = Mocha.Green,
                                contentColor = Mocha.Crust,
                            )
                        }
                        else {
                            ButtonDefaults.buttonColors(
                                backgroundColor = Mocha.Green,
                            )
                        }
                    
                    
                    
                    Row {
                        Spacer(Modifier.width(56.dp))
                        TextField(packPathInput,
                                  { updatePackPathTextField(it) },
                                  singleLine = true,
                                  label = { Text("Resource Pack") },
                                  trailingIcon = {
                                      if (packPath != null) {
                                          Icon(Icons.Filled.Check, null, tint = Mocha.Green)
                                      } },
                                  colors = textFieldColors,
                                  modifier = Modifier.width(280.dp).height(56.dp)
                        )
                        
                        IconButton({
                            DirectorySelector.show { updatePackPathTextField(it.path) }
                                   }, Modifier.size(56.dp)) {
                            Image(Icons.Outlined.FolderOpen, null, colorFilter = ColorFilter.tint(Mocha.Text))
                        }
                    }
                    
                    
                    
                    Spacer(Modifier.height(10.dp))
                    
                    //Button({ dropDownMenuExpanded = !dropDownMenuExpanded }, enabled = (packPath != null) ) { Text("Namespaces") }
                    ExposedDropdownMenuBox(dropDownMenuExpanded, {
                        if (packPath != null) dropDownMenuExpanded = it else {
                            dropDownMenuExpanded = false; namespace = null; verified = false
                        }
                    }) {
                        // TextField to trigger the dropdown menu
                        TextField(
                            value = namespace ?: "",
                            onValueChange = {},
                            label = { Text("Namespace") },
                            readOnly = true,
                            enabled = (packPath != null),
                            colors = namespaceFieldColors,
                            trailingIcon = {
                                if (namespace != null) {
                                    Icon(Icons.Filled.Check, null, tint = Mocha.Green)
                                } },
                            modifier = Modifier.width(280.dp),
                            singleLine = true
                        )
                        
                        // Exposed Dropdown Menu
                        ExposedDropdownMenu(
                            expanded = dropDownMenuExpanded,
                            onDismissRequest = { dropDownMenuExpanded = false }
                        ) {
                            val options =
                                File(packPath, "assets").listFiles()?.filter { !it.isFile }?.map { it.name } ?: listOf()
                            options.forEach { option ->
                                DropdownMenuItem(
                                    onClick = {
                                        namespace = option
                                        dropDownMenuExpanded = false
                                        logger.info("Selected Namespace: $option")
                                        verified = verifier()
                                    }
                                ) { Text(option) }
                            }
                        }
                    }
                    
                    
                    
                    
                    if (!verified && packPath != null && namespace != null) {
                        Spacer(Modifier.height(10.dp))
                        Text("Failed to verify the pack :/", color = Mocha.Red)
                        Spacer(Modifier.height(10.dp))
                    } else {
                        Spacer(Modifier.height(20.dp))
                    }
                    
                    Button(
                        {
                            Backend.launch(File(packPath!!), namespace!!)
                            
                        },
                        enabled = (packPath != null && namespace != null && verified),
                        colors = buttonColor,
                        border = if (!verified && packPath != null && namespace != null) BorderStroke(2.dp, Mocha.Red) else null
                    ) { Text("Open") }
                }
            }
            
        }
    }
}
