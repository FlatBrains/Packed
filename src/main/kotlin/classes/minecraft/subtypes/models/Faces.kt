package classes.minecraft.subtypes.models

import kotlinx.serialization.Serializable

@Serializable
data class Faces(
    val up: Face? = null,
    val down: Face? = null,
    val north: Face? = null,
    val east: Face? = null,
    val south: Face? = null,
    val west: Face? = null,
)