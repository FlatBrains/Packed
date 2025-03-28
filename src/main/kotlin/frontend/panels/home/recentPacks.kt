package frontend.panels.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import backend.Backend
import backend.utilities.copyToClipboard
import frontend.Mocha
import frontend.modifiers.rightClickMenu
import java.io.File

@Composable
fun RowScope.recentPacks() {
    
    
    
    Column(modifier = Modifier.fillMaxSize().weight(1F).background(Mocha.Mantle), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Recent Packs", style = MaterialTheme.typography.h1)
            Spacer(Modifier.padding(20.dp))
            Column {
                if (Backend.cache.history.size != 0) {
                    Row(Modifier.fillMaxWidth(0.5F).align(Alignment.CenterHorizontally)) {
                        Spacer(Modifier.width(25.dp))
                        Text(File("Name").name, style = MaterialTheme.typography.subtitle1)
                        Spacer(modifier = Modifier.weight(1F))
                        Text("Namespace", style = MaterialTheme.typography.subtitle1)
                        Spacer(Modifier.width(25.dp))
                    }
                    
                    Spacer(Modifier.height(10.dp))
                    
                    
                    Backend.cache.history.take(9).forEach {
                        Row(Modifier.fillMaxWidth(0.5F)) {
                            TextButton(
                                { Backend.launch(File(it.path), it.namespace) },
                                modifier = Modifier.rightClickMenu {
                                    
                                    
                                    Text("Path:")
                                    Text(it.fullPath, fontSize = 14.sp)
                                    
                                    Spacer(Modifier.height(15.dp))
                                    

                                    Text("Copy:")
                                    
                                    SplitButton(
                                        {
                                            Button(label = "Full Path", icon = Icons.Sharp.FolderCopy) { copyToClipboard(it.fullPath) }
                                        },
                                        {
                                            Button(label = "JŚON", icon = Icons.Sharp.DataObject) { copyToClipboard(it.json) }
                                        })
                                        
                                    SplitButton(
                                        {
                                            Button(label = "Base Path", icon = Icons.Sharp.FolderOpen) { copyToClipboard(it.path) }
                                        },
                                        {
                                            Button(label = "Namespace", icon = Icons.Sharp.VpnKey) { copyToClipboard(it.namespace) }
                                        })
                                        
                                    Button(label = "Remove", icon = Icons.Sharp.Close, theme = Mocha.Red) { Backend.removeHistory(it) }
                                    
                                }
                            ) {
                                Text(File(it.path).name)
                                Spacer(modifier = Modifier.weight(1F))
                                Text(it.namespace)
                            }
                        }
                    }
                } else {
                    Text("None, yet...")
                }
            }
        }
    }
}