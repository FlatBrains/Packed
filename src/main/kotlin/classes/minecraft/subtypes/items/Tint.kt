package classes.minecraft.subtypes.items

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

@Serializable
sealed class Tint

//minecraft:constant, minecraft:dye, minecraft:firework, minecraft:grass, minecraft:map_color, minecraft:potion, minecraft:team or minecraft:custom_model_data

@Serializable
@SerialName("minecraft:constant")
data class ConstantTint(
    val value: TintValue
) : Tint()

@Serializable
@SerialName("minecraft:dye")
data class DyeTint(
    val default: TintValue
) : Tint()

@Serializable
@SerialName("minecraft:firework")
data class FireworkTint(
    val default: TintValue
) : Tint()

@Serializable
@SerialName("minecraft:grass")
data class GrassTint(
    val temperature: Float,
    val downfall: Float,
) : Tint()

@Serializable
@SerialName("minecraft:map_color")
data class MapColorTint(
    val default: TintValue
) : Tint()

@Serializable
@SerialName("minecraft:potion")
data class PotionTint(
    val default: TintValue
) : Tint()

@Serializable
@SerialName("minecraft:team")
data class TeamTint(
    val default: TintValue
) : Tint()

@Serializable
@SerialName("minecraft:custom_model_data")
data class CustomModelData(
    val index: Int? = null,
    val default: TintValue
) : Tint()



@Serializable(with = TintValueSerializer::class)
sealed class TintValue {
    data class IntValue(val value: Int) : TintValue()
    data class FloatArrayValue(val value: List<Float>) : TintValue() {
        init {
            require(value.size == 3) { "FloatArray must contain exactly 3 elements" }
            value.map { it.coerceIn(0F, 1F) }
        }
    }
}

object TintValueSerializer : KSerializer<TintValue> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Value", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: TintValue) {
        when (value) {
            is TintValue.IntValue -> encoder.encodeInt(value.value)
            is TintValue.FloatArrayValue -> encoder.encodeSerializableValue(ListSerializer(Float.serializer()), value.value)
        }
    }

    override fun deserialize(decoder: Decoder): TintValue {
        val input = decoder.decodeSerializableValue(JsonElement.serializer())
        return if (input is JsonArray) {
            val list = input.map { it.jsonPrimitive.float }
            require(list.size == 3) { "FloatArray must contain exactly 3 elements" }
            TintValue.FloatArrayValue(list)
        } else {
            TintValue.IntValue(input.jsonPrimitive.int)
        }
    }

}
