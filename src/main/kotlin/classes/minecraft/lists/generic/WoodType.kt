package classes.minecraft.lists.generic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class WoodType {
    @SerialName("oak"       ) Oak,
    @SerialName("spruce"    ) Spruce,
    @SerialName("birch"     ) Birch,
    @SerialName("acacia"    ) Acacia,
    @SerialName("cherry"    ) Cherry,
    @SerialName("jungle"    ) Jungle,
    @SerialName("dark_oak"  ) DarkOak,
    @SerialName("pale_oak"  ) PaleOak,
    @SerialName("mangrove"  ) Mangrove,
    @SerialName("bamboo"    ) Bamboo,
    @SerialName("crimson"   ) Crimson,
    @SerialName("warped"    ) Warped
}
