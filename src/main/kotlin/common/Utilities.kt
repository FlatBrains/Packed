package common

import classes.minecraft.Key.Companion.toKey
import java.io.File
import java.io.IOException

object Utilities {
    fun Array<Float>.toPackedRGB(): Int {
        require(size >= 3) { "Color array must have at least 3 elements (R, G, B)" }
        val r = (this[0].coerceIn(0.0f, 1.0f) * 255).toInt()
        val g = (this[1].coerceIn(0.0f, 1.0f) * 255).toInt()
        val b = (this[2].coerceIn(0.0f, 1.0f) * 255).toInt()
        return (r shl 16) or (g shl 8) or b
    }

    fun openFileWithSpecificApp(file: File, appPath: String) {
        try {
            val processBuilder = ProcessBuilder(appPath, file.absolutePath)
            processBuilder.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun <T: Any>  T.runIf(condition: Boolean, function: (T) -> Unit ): T {
        if (condition) {
            function(this)
        }

        return this
    }

    fun searchItems(query: String, elements: List<File>): List<File> {
        return elements.filter { it.toKey().toString(false).replace("/", "").replace("_", "").contains(query.replace(" ", ""), ignoreCase = true ) || query.isBlank() }
    }
}