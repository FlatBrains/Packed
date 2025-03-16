package classes.minecraft.lists.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GuiLight {
    @SerialName("front") Front,
    @SerialName("side" ) Side
}