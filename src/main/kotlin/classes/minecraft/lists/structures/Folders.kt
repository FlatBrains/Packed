package classes.minecraft.lists.structures

enum class Folders(val fileExtension: String) {
    Items(".json"),
    Models(".json"),
    Textures(".png");

    override fun toString(): String {
        return when(this) {
            Items -> "items"
            Models -> "models"
            Textures -> "textures"
        }
    }
}