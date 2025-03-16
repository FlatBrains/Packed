package classes.minecraft.lists.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SelectProperty {
    @SerialName("minecraft:block_state"         ) BlockState,
    @SerialName("minecraft:charge_type"         ) ChargeType,
    @SerialName("minecraft:component"           ) Component,
    @SerialName("minecraft:context_dimension"   ) ContextDimension,
    @SerialName("minecraft:context_entity_type" ) ContextEntityType,
    @SerialName("minecraft:display_context"     ) DisplayContext,
    @SerialName("minecraft:local_time"          ) LocalTime,
    @SerialName("minecraft:main_hand"           ) MainHand,
    @SerialName("minecraft:trim_material"       ) TrimMaterial,
    @SerialName("minecraft:custom_model_data"   ) CustomModelData,
}