package classes.minecraft.subtypes.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Display(
    @SerialName("thirdperson_righthand") val thirdPersonRightHand: Transformation? = null,
    @SerialName("thirdperson_lefthand")  val thirdPersonLeftHand:  Transformation? = null,
    @SerialName("firstperson_righthand") val firstPersonRightHand: Transformation? = null,
    @SerialName("firstperson_lefthand")  val firstPersonLeftHand:  Transformation? = null,
    val ground: Transformation? = null,
    val gui: Transformation? = null,
    val head: Transformation? = null,
    val fixed: Transformation? = null,
)