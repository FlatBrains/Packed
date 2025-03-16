package classes.minecraft.subtypes.models

import kotlinx.serialization.Serializable

@Serializable
data class Transformation(
    val translation: Array<Float>? = null,
    val rotation: Array<Float>? = null,
    val scale: Array<Float>? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Transformation

        if (translation != null) {
            if (other.translation == null) return false
            if (!translation.contentEquals(other.translation)) return false
        } else if (other.translation != null) return false
        if (rotation != null) {
            if (other.rotation == null) return false
            if (!rotation.contentEquals(other.rotation)) return false
        } else if (other.rotation != null) return false
        if (scale != null) {
            if (other.scale == null) return false
            if (!scale.contentEquals(other.scale)) return false
        } else if (other.scale != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = translation?.contentHashCode() ?: 0
        result = 31 * result + (rotation?.contentHashCode() ?: 0)
        result = 31 * result + (scale?.contentHashCode() ?: 0)
        return result
    }
}
