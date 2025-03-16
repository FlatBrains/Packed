package classes.minecraft.lists.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class Condition {

    @SerialName("minecraft:broken"                    ) Broken,
    @SerialName("minecraft:bundle/has_selected_item"  ) BundleHasSelectedItem,
    @SerialName("minecraft:carried"                   ) Carried,
    @SerialName("minecraft:component"                 ) Component,
    @SerialName("minecraft:damaged"                   ) Damaged,
    @SerialName("minecraft:extended_view"             ) ExtendedView,
    @SerialName("minecraft:fishing_rod/cast"          ) FishingRodCast,
    @SerialName("minecraft:has_component"             ) HasComponent,
    @SerialName("minecraft:keybind_down"              ) KeybindDown,
    @SerialName("minecraft:selected"                  ) Selected,
    @SerialName("minecraft:using_item"                ) UsingItem,
    @SerialName("minecraft:view_entity"               ) ViewEntity,
    @SerialName("minecraft:custom_model_data"         ) CustomModelData,

}

