package classes.minecraft.lists.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RangeDispatchSource {

    @SerialName("daytime"   ) Daytime,
    @SerialName("moon_phase") MoonPhase,
    @SerialName("random"    ) Random,

}