package classes.minecraft.subtypes.models

import kotlinx.serialization.Serializable

@Serializable
data class ElementRotation(
    val origin: Array<Float>,
    val axis: Axis,
    val angle: Float,
    val rescale: Boolean? = null
)
