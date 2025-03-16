package classes.minecraft.subtypes.items

import classes.minecraft.ItemModel
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Case(
    @Contextual @SerialName("when") val whenValue: JsonElement,
    val model: ItemModel
)