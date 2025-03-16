package classes.minecraft.subtypes.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Axis {
    @SerialName("x") X,
    @SerialName("y") Y,
    @SerialName("z") Z,
}