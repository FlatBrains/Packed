package classes.minecraft

import classes.minecraft.lists.structures.Folders
import java.io.File

data class Texture(val path: File, val mcmeta: File? = null) {
    companion object {
        fun Key.toTexture(): Texture {
            val path = File(this.toPath(Folders.Textures))
            val mcmeta = File(this.toPath(Folders.Textures) + ".mcmeta")

            if (!path.exists()) {
                throw IllegalArgumentException("Key must contain a valid path to a texture! \"$path\"")
            }

            if (mcmeta.exists()) {
                return Texture(path, mcmeta)
            }

            return Texture(path, null)
        }

        fun File.toTexture(): Texture {
            val mcmeta = File(this.absolutePath + ".mcmeta")

            if (!this.exists()) {
                throw IllegalArgumentException("Key must contain a valid path to a texture! \"$path\"")
            }

            if (mcmeta.exists()) {
                return Texture(this, mcmeta)
            }

            return Texture(this, null)
        }
    }
}