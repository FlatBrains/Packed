package classes.minecraft.lists.generic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class HeadKind {

    @SerialName("skeleton") Skeleton,
    @SerialName("wither_skeleton") WitherSkeleton,
    @SerialName("player") Player,
    @SerialName("zombie") Zombie,
    @SerialName("creeper") Creeper,
    @SerialName("piglin") Piglin,
    @SerialName("dragon") Dragon,

}

