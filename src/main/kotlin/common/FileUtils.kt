package common

import backend.Backend
import backend.debug.logger
import java.io.File

object FileUtils {


    fun File.extractFiles(): List<File> {

        val files = mutableListOf<File>()

        try {
            this.listFiles()?.forEach {
                if (it.isFile) {
                    files.add(it)
                }
                files.addAll(it.extractFiles())
            }
        } catch (e: Throwable) {
            logger.severe("extractFiles()")
            e.printStackTrace()
        }


        return files
    }

    fun File.countDepth(root: File): Int {
        if (!this.absolutePath.startsWith(root.absolutePath)) {
            throw IllegalArgumentException("The file is not within the root directory.")
        }

        var current = this
        var depth = 0

        while (current != root) {
            current = current.parentFile ?: break
            depth++
        }

        return depth
    }

}