package backend

import classes.minecraft.*
import classes.minecraft.subtypes.items.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

val CustomJson = Json {

    serializersModule = SerializersModule {
        polymorphic(Tint::class) {
            subclass(ConstantTint::class, ConstantTint.serializer())
            subclass(DyeTint::class, DyeTint.serializer())
            subclass(FireworkTint::class, FireworkTint.serializer())
            subclass(GrassTint::class, GrassTint.serializer())
            subclass(MapColorTint::class, MapColorTint.serializer())
            subclass(PotionTint::class, PotionTint.serializer())
            subclass(TeamTint::class, TeamTint.serializer())
            subclass(CustomModelData::class, CustomModelData.serializer())
        }

        polymorphic(SpecialModel::class) {
            subclass(SpecialModelBanner::class, SpecialModelBanner.serializer())
            subclass(SpecialModelBed::class, SpecialModelBed.serializer())
            subclass(SpecialModelChest::class, SpecialModelChest.serializer())
            subclass(SpecialModelConduit::class, SpecialModelConduit.serializer())
            subclass(SpecialModelDecoratedPot::class, SpecialModelDecoratedPot.serializer())
            subclass(SpecialModelHead::class, SpecialModelHead.serializer())
            subclass(SpecialModelShield::class, SpecialModelShield.serializer())
            subclass(SpecialModelShulkerBox::class, SpecialModelShulkerBox.serializer())
            subclass(SpecialModelStandingSign::class, SpecialModelStandingSign.serializer())
            subclass(SpecialModelHangingSign::class, SpecialModelHangingSign.serializer())
            subclass(SpecialModelTrident::class, SpecialModelTrident.serializer())
        }

        polymorphic(ItemModel::class) {
            subclass(ItemModelModel::class, ItemModelModel.serializer())
            subclass(ItemModelComposite::class, ItemModelComposite.serializer())
            subclass(ItemModelCondition::class, ItemModelCondition.serializer())
            subclass(ItemModelSelect::class, ItemModelSelect.serializer())
            subclass(ItemModelRangeDispatch::class, ItemModelRangeDispatch.serializer())
            subclass(ItemModelSpecial::class, ItemModelSpecial.serializer())
            subclass(ItemModelBundleSelectedItem::class, ItemModelBundleSelectedItem.serializer())
            subclass(ItemModelEmpty::class, ItemModelEmpty.serializer())
        }
    }
}