package backend

import androidx.compose.runtime.mutableStateOf
import backend.debug.LogFormatter
import backend.debug.logger
import classes.minecraft.Item
import classes.minecraft.Model
import classes.packed.Cache
import classes.packed.HistoryElement
import common.FileUtils.extractFiles
import common.Utilities.openFileWithSpecificApp
import frontend.App
import frontend.AppState
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.File
import java.util.logging.ConsoleHandler

object Backend {

    var itemSelection = mutableStateOf<File?>(null)

    data class Pack(
        val root: String,
        val namespace: String,
        val name: String = File(root).name,
        val base: String = "$root/assets/$namespace",
        val items: String = "$base/items",
        val itemModels: String = "$base/models/item",
        val itemTextures: String = "$base/textures/item"
    ) {
        companion object {
            var current: Pack? = null
            
            val root get() = current!!.root
            val namespace get() = current!!.namespace
            val name get() = current!!.name
            val base get() = current!!.base
            val items get() = current!!.items
            val itemModels get() = current!!.itemModels
            val itemTextures get() = current!!.itemTextures
        }
    }

    fun verifyPack(root: File, namespace: String): Boolean {
        val state = root.exists() &&
                !root.isFile &&
                File(root, "assets").exists() &&
                !File(root, "assets").isFile &&
                File(root, "assets/$namespace").exists() &&
                !File(root, "assets/$namespace").isFile &&
                File(root, "assets/$namespace/items").exists() &&
                !File(root, "assets/$namespace/items").isFile

        if (state) logger.info("Successfully verified $root@$namespace")
        else       logger.info("Failed to verify $root@$namespace")

        return state
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun launch(root: File, namespace: String)  {
        if (verifyPack(root, namespace)) {
            Pack.current = Pack(root.path.replace("\\", "/"), namespace)
            //logger.info("Verified pack!")

            logger.info("Launching app:")
            logger.info("Pack Path: $root")
            logger.info("Namespace: $namespace")


            updateHistory(root, namespace)


            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    App.setState(AppState.LOADING)
                }

                withContext(Dispatchers.IO) {
                    loadItems()
                    //loadModels()
                }

                App.setState(AppState.MAIN)
            }

        } else {
            logger.warning("Failed to verify pack!")
        }
    }
    
    @OptIn(DelicateCoroutinesApi::class)
    fun returnToHome()  {
        
        Pack.current = null
        
        logger.info("Returning back to home")
        
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                App.setState(AppState.LOADING)
            }
            
            withContext(Dispatchers.IO) {
                loadedItems.clear()
                //loadModels()
            }
            
            App.setState(AppState.HOME)
        }
    }


    const val BLOCKBENCH = "C:/Users/manue/AppData/Local/Programs/Blockbench/Blockbench.exe"
    const val ASEPRITE   = "D:/files/Programs/Aseprite/Aseprite/aseprite.exe"



    val loadedItems =  mutableMapOf<File, Item>()
    val loadedModels =  mutableMapOf<File, Model>()

    fun loadItems() {
        val itemsFiles = mutableMapOf<File, String>()
        
        if (Backend.Pack.current == null) { return }

        File(Backend.Pack.current!!.items).extractFiles().forEach {
            itemsFiles[it] = it.readText()
        }

        itemsFiles.forEach {
            loadedItems[it.key] = CustomJson.decodeFromString<Item>(it.value)
        }

    }

    fun loadModels() {
        val modelFiles = mutableMapOf<File, String>()

        File(Backend.Pack.itemModels).extractFiles().filter { it.extension == "json" }.forEach {
            modelFiles[it] = it.readText()
        }

        modelFiles.forEach {
            loadedModels[it.key] = CustomJson.decodeFromString<Model>(it.value)
        }

    }

    var cache: Cache = Cache(mutableListOf())

    fun loadCache() {

        val userHome = System.getProperty("user.home")
        val file = File(userHome, ".flatbrains/packed/cache.json")

        try {
            cache = Json.decodeFromString<Cache>(file.readText())
            logger.severe("Successfully loaded cache!")

        } catch (e: Throwable) {
            logger.warning("Failed to load cache!")
        }

        logger.info(cache.history.toString())

    }

    fun saveCache() {

        logger.info("Saving cache")
        val userHome = System.getProperty("user.home")
        val file = File(userHome, ".flatbrains/packed/cache.json").also { it.createNewFile() }

        logger.info(cache.toString())
        logger.info(Json.encodeToJsonElement(cache).toString())

        file.writeText(Json.encodeToJsonElement(cache).toString())


    }

    fun updateHistory(root: File, namespace: String) {
        logger.info("Updating history")
        
        cache.history.removeAll { it.path.replace("\\", "/") == root.path.replace("\\", "/") && it.namespace == namespace }
        cache.history.addFirst(HistoryElement(root.path.replace("\\", "/"), namespace))
        if(cache.history.size > 20) {
            cache.history.removeLast()
        }
        
        saveCache()
    }

    init {
        val consoleHandler = ConsoleHandler()
        consoleHandler.formatter = LogFormatter
        logger.setUseParentHandlers(false) // Disable default handlers
        logger.addHandler(consoleHandler)
        loadCache()
    }

    // Custom Formatter class

    fun openWithBlockbench(file: File) {
        openFileWithSpecificApp(
            file, BLOCKBENCH
        )
    }

    fun openWithNotepad(file: File) {
        openFileWithSpecificApp(
            file, "notepad.exe"
        )
    }
}