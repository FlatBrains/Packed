package classes.minecraft.subtypes.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Face(
    val uv: Array<Float>,
    val texture: String,
    val cullface: Direction? = null,
    val rotation: Int? = null,
    @SerialName("tintindex") val tintIndex: Int? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Face

        if (rotation != other.rotation) return false
        if (tintIndex != other.tintIndex) return false
        if (!uv.contentEquals(other.uv)) return false
        if (texture != other.texture) return false
        if (cullface != other.cullface) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rotation ?: 0
        result = 31 * result + (tintIndex ?: 0)
        result = 31 * result + uv.contentHashCode()
        result = 31 * result + texture.hashCode()
        result = 31 * result + (cullface?.hashCode() ?: 0)
        return result
    }
}

/*

Face:
  uv: Int[4]
  texture: String
  cullface: String? -> "up", "down", "north", "east", "south", "west"
  rotation: Int? -> 0, 90, 180, 270
  tintindex: Int?


 */