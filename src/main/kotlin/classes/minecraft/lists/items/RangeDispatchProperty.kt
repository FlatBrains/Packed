package classes.minecraft.lists.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RangeDispatchProperty {

    @SerialName("minecraft:bundle/fullness"   ) BundleFullness,
    @SerialName("minecraft:compass"           ) Compass,
    @SerialName("minecraft:cooldown"          ) Cooldown,
    @SerialName("minecraft:count"             ) Count,
    @SerialName("minecraft:crossbow/pull"     ) CrossbowPull,
    @SerialName("minecraft:damage"            ) Damage,
    @SerialName("minecraft:time"              ) Time,
    @SerialName("minecraft:use_cycle"         ) UseCycle,
    @SerialName("minecraft:use_duration"      ) UseDuration,
    @SerialName("minecraft:custom_model_data" ) CustomModelData,

}