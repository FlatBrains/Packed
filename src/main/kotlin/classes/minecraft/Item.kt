package classes.minecraft

import classes.minecraft.lists.items.*
import classes.minecraft.subtypes.items.Case
import classes.minecraft.subtypes.items.RangeDispatchEntry
import classes.minecraft.subtypes.items.SpecialModel
import classes.minecraft.subtypes.items.Tint
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Item(
    val model: ItemModel,
    @SerialName("hand_animation_on_swap") val handAnimationOnSwap: Boolean? = null,
)


// minecraft:model, minecraft:composite, minecraft:condition, minecraft:select, minecraft:range_dispatch, minecraft:empty, minecraft:bundle/selected_item or minecraft:special


@Serializable
sealed class ItemModel {
    abstract val modelPaths: List<String>
}


@Serializable
@SerialName("minecraft:model")
data class ItemModelModel(
    val model: String,
    val tints: List<Tint>? = null
): ItemModel() {
    override val modelPaths: List<String> = listOf(model)
}


@Serializable
@SerialName("minecraft:composite")
data class ItemModelComposite(
    val models: List<ItemModel>
): ItemModel() {
    override val modelPaths: List<String> = models.map { it.modelPaths }.flatten()
}


@Serializable
@SerialName("minecraft:condition")
data class ItemModelCondition(
    val property: Condition,
    @SerialName("on_true") val onTrue: ItemModel,
    @SerialName("on_false") val onFalse: ItemModel,

    val predicate: String? = null,
    val value: String? = null,
    val component: String? = null,
    @SerialName("ignore_default") val ignoreName: Boolean? = null,
    val keybind: String? = null,
    val index: Int? = null,

): ItemModel() {
    override val modelPaths: List<String> = listOf(onTrue.modelPaths, onFalse.modelPaths).flatten()
}

@Serializable
@SerialName("minecraft:select")
data class ItemModelSelect(
    val property: SelectProperty,
    val cases: List<Case>,
    val fallback: ItemModel,

    @SerialName("block_state_property") val blockStateProperty: String? = null,
    val component: String? = null,
    val locale: String? = null,
    @SerialName("time_zone") val timeZone: String? = null,
    val pattern: String? = null,
    val index: Int? = null,

): ItemModel() {
    override val modelPaths: List<String> = listOf(fallback.modelPaths, cases.map { it.model.modelPaths }.flatten() ).flatten()
}

@Serializable
@SerialName("minecraft:range_dispatch")
data class ItemModelRangeDispatch(
    val entries: List<RangeDispatchEntry>,
    val scale: Float? = null,
    val fallback: ItemModel? = null,
    val property: RangeDispatchProperty,

    val target: RangeDispatchTarget? = null,
    val source: RangeDispatchSource? = null,
    val wobble: Boolean? = null,
    val normalize: Boolean? = null,
    val period: Float? = null,
    val remaining: Boolean? = null,
    val index: Int? = null



): ItemModel() {
    override val modelPaths: List<String> = listOfNotNull(fallback?.modelPaths, entries.map { it.model.modelPaths }.flatten()).flatten()
}

@Serializable
@SerialName("minecraft:special")
data class ItemModelSpecial(
    val model: SpecialModel,
    val base: String,
): ItemModel() {
    override val modelPaths: List<String> = listOf(base)
}

@Serializable
@SerialName("minecraft:bundle/selected_item")
data object ItemModelBundleSelectedItem : ItemModel() { override val modelPaths: List<String> = listOf() }

@Serializable
@SerialName("minecraft:empty")
data object ItemModelEmpty : ItemModel() { override val modelPaths: List<String> = listOf() }



