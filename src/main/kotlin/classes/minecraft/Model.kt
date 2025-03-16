package classes.minecraft

import classes.minecraft.lists.models.GuiLight
import classes.minecraft.subtypes.models.Display
import classes.minecraft.subtypes.models.Element
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Model(
    val credit: String? = null,
    val parent: String? = null,
    @SerialName("texture_size") val textureSize: Array<Int>? = null,
    val textures: Map<String, String>? = null,
    val elements: List<Element>? = null,
    @SerialName("gui_light") val guiLight: GuiLight? = null,
    val display: Display? = null,
    val groups: Array<JsonElement>? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Model

        if (credit != other.credit) return false
        if (parent != other.parent) return false
        if (textureSize != null) {
            if (other.textureSize == null) return false
            if (!textureSize.contentEquals(other.textureSize)) return false
        } else if (other.textureSize != null) return false
        if (textures != other.textures) return false
        if (elements != other.elements) return false
        if (guiLight != other.guiLight) return false
        if (display != other.display) return false
        if (groups != null) {
            if (other.groups == null) return false
            if (!groups.contentEquals(other.groups)) return false
        } else if (other.groups != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = credit?.hashCode() ?: 0
        result = 31 * result + (parent?.hashCode() ?: 0)
        result = 31 * result + (textureSize?.contentHashCode() ?: 0)
        result = 31 * result + textures.hashCode()
        result = 31 * result + (elements?.hashCode() ?: 0)
        result = 31 * result + (guiLight?.hashCode() ?: 0)
        result = 31 * result + (display?.hashCode() ?: 0)
        result = 31 * result + (groups?.contentHashCode() ?: 0)
        return result
    }
}


/*

credit: String?
parent: String?,
texture_size: Int[2]?
textures: Map<String, String>
elements: List<Element>?
gui_light: String -> "front", "side"?
display: Display?
groups: Int|Group?


Group:
  name: String
  origin: Float[3]
  color: Int
  children: Int[]

Display:
  thirdperson_righthand: Transformation
  thirdperson_lefthand: Transformation
  firstperson_righthand: Transformation
  firstperson_lefthand: Transformation
  ground: Transformation
  gui: Transformation
  head: Transformation
  fixed: Transformation

Transformation:
  translation: Float[3]?
  rotation: Float[3]?
  scale: Float[3]?

Element:
 from: Float[3]
 to: Float[3]
 rotation: Rotation
 shade: Boolean
 light_emission: Int
 faces: Map<String, Face> -> "up", "down", "north", "east", "south", "west"

Rotation:
  origin: Float[3]
  axis: string -> "x", "y", "z"
  angle: Float
  rescale: Boolean?

Face:
  uv: Int[4]
  texture: String
  cullface: String? -> "up", "down", "north", "east", "south", "west"
  rotation: Int? -> 0, 90, 180, 270
  tintindex: Int?










 */