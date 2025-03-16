package common

import org.lwjgl.system.MemoryUtil
import org.lwjgl.util.nfd.NativeFileDialog
import java.io.File

object DirectorySelector  {
    fun show(after: (File) -> Unit = {}) {
        val pathPointer = MemoryUtil.memAllocPointer(1)
        try {
            val code = NativeFileDialog.NFD_PickFolder(pathPointer, "")
            when (code) {
                NativeFileDialog.NFD_OKAY -> {
                    val path: String = pathPointer.stringUTF8
                    NativeFileDialog.nNFD_FreePath(pathPointer[0])

                    after(File(path))
                }
                NativeFileDialog.NFD_CANCEL -> null
                NativeFileDialog.NFD_ERROR -> error("An error occurred while executing NativeFileDialog.NFD_PickFolder")
                else -> error("Unknown return code '${code}' from NativeFileDialog.NFD_PickFolder")
            }
        } finally {
            MemoryUtil.memFree(pathPointer)
        }

    }
}