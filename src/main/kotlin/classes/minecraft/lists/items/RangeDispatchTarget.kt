package classes.minecraft.lists.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RangeDispatchTarget {

    @SerialName("spawn"    ) Spawn,
    @SerialName("lodestone") Lodestone,
    @SerialName("recovery" ) Recovery,
    @SerialName("none"     ) None,

}