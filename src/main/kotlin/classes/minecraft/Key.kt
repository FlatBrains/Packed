package classes.minecraft

import backend.Backend
import common.Utilities.runIf
import classes.minecraft.lists.structures.Folders
import java.io.File

data class Key(val namespace: String, val value: String) {

    override fun toString(): String {
        return "$namespace:$value"
    }

    fun toString(namespace: Boolean = true): String {
        return if (namespace) toString() else value
    }

    fun toPath(type: Folders): String {
        return "${Backend.Pack.current.root}/assets/$namespace/$type/$value${type.fileExtension}"
    }

    companion object {
        private val namespaceRegex: Regex = Regex(".+(?=:)")
        private val valueRegex:     Regex = Regex("(?<=:).+")

        fun String.toKey(): Key {
            return Key(
                namespaceRegex.find(this)?.value ?: throw IllegalArgumentException("Failed to find namespace of path: $this"),
                valueRegex.find(this)?.value ?: throw IllegalArgumentException("Failed to find value of path: $this")
            )
        }

        fun String.toPackPath(type: Folders): String {
            return this.toKey().toPath(type)
        }

        fun File.toKey(): Key {
            //if (!this.toString().contains("assets")) throw IllegalArgumentException("Invalid file path given: $this")
            val split = this.absolutePath.replace("\\", "/").split("/assets/")
            if (split.size < 2) throw IllegalArgumentException("File path didn't contain an \"assets\" folder: $this")
            if (split.size > 2) throw IllegalArgumentException("Path can't contain multiple \"assets\" folders :/ $this")

            // "C:\Users\manue\Dropbox\LAMBA PACK\resourcepacks\LAMBDA    \assets\   lambda\items\light.json"
            val split2 = split.last().split("/")

            val namespace = split2.first()
            val value = split2.subList(2, split2.size).joinToString("/").replace(Regex("\\..*"), "")

            return Key(namespace, value)

        }

        fun File.toPackPath(type: Folders): String {
            return this.toKey().toPath(type)
        }

        fun File.toKeyString(namespace: Boolean = false, underscores: Boolean = false): String {

            return this.toKey().toString(namespace).runIf(underscores) { it.replace("_", " ") }
        }
    }
}
