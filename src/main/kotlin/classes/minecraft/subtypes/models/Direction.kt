package classes.minecraft.subtypes.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Direction {
    @SerialName("up"    ) Up,
    @SerialName("down"  ) Down,
    @SerialName("north" ) North,
    @SerialName("east"  ) East,
    @SerialName("south" ) South,
    @SerialName("west"  ) West,
}
