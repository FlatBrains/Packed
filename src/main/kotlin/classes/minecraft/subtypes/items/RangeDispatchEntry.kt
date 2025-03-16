package classes.minecraft.subtypes.items

import classes.minecraft.ItemModel
import kotlinx.serialization.Serializable

@Serializable
data class RangeDispatchEntry(
    val threshold: Float,
    val model: ItemModel,
)
