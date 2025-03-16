package classes.minecraft.subtypes.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Element(
    val from: Array<Float>,
    val to: Array<Float>,
    val rotation: ElementRotation? = null,
    val shade: Boolean? = null,
    @SerialName("light_emission") val lightEmission: Int? = null,
    val faces: Faces
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Element

        if (shade != other.shade) return false
        if (lightEmission != other.lightEmission) return false
        if (!from.contentEquals(other.from)) return false
        if (!to.contentEquals(other.to)) return false
        if (rotation != other.rotation) return false
        if (faces != other.faces) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shade?.hashCode() ?: 0
        result = 31 * result + (lightEmission ?: 0)
        result = 31 * result + from.contentHashCode()
        result = 31 * result + to.contentHashCode()
        result = 31 * result + rotation.hashCode()
        result = 31 * result + faces.hashCode()
        return result
    }
}

/*

Element:
 from: Float[3]
 to: Float[3]
 rotation: Rotation
 shade: Boolean?
 light_emission: Int?
 faces: Map<String, Face> ->

 */