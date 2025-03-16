package classes.minecraft.subtypes.items

import classes.minecraft.lists.generic.HeadKind
import classes.minecraft.lists.generic.WoodType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class SpecialModel


// minecraft:banner
// minecraft:bed
// minecraft:chest
// minecraft:conduit
// minecraft:decorated_pot
// minecraft:head
// minecraft:shield
// minecraft:shulker_box
// minecraft:standing_sign
// minecraft:hanging_sign
// minecraft:trident

@Serializable
@SerialName("minecraft:banner")
data class SpecialModelBanner( val color: String ) : SpecialModel()

@Serializable
@SerialName("minecraft:bed")
data class SpecialModelBed( val texture: String ) : SpecialModel()

@Serializable
@SerialName("minecraft:chest")
data class SpecialModelChest( val texture: String, val openness: Float? = null ) : SpecialModel()

@Serializable
@SerialName("minecraft:conduit")
data object SpecialModelConduit : SpecialModel()

@Serializable
@SerialName("minecraft:decorated_pot")
data object SpecialModelDecoratedPot : SpecialModel()

@Serializable
@SerialName("minecraft:head")
data class SpecialModelHead(val kind: HeadKind, val texture: String? = null, val animation: Float? = null ) : SpecialModel()

@Serializable
@SerialName("minecraft:shield")
data object SpecialModelShield : SpecialModel()

@Serializable
@SerialName("minecraft:shulker_box")
data class SpecialModelShulkerBox( val texture: String, val openness: Float? = null, val orientation: String? = null ) : SpecialModel()

@Serializable
@SerialName("minecraft:standing_sign")
data class SpecialModelStandingSign(@SerialName("wood_type") val woodType: WoodType, val texture: String? = null) : SpecialModel()

@Serializable
@SerialName("minecraft:hanging_sign")
data class SpecialModelHangingSign(@SerialName("wood_type") val woodType: WoodType, val texture: String? = null) : SpecialModel()


@Serializable
@SerialName("minecraft:trident")
data object SpecialModelTrident : SpecialModel()
