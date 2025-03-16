package tasks

import backend.debug.logger
import classes.minecraft.Key


enum class ItemTemplate(val value: (String) -> String) {
    None({"{}"}),
    BasicModel({"""
        {
            "model": {
                "type": "minecraft:model",
                "model": "$it",
            }
        }
    """.trimIndent()}),

    CMDTintedModel({"""
        {
            "model": {
                "type": "minecraft:model",
                "model": "$it",
                "tints": [
                    {
                        "type": "minecraft:custom_model_data",
                        "index": 0,
                        "default": 16777215
                    }
                ]
            }
        }
    """.trimIndent()}),

    DyeTintedModel({"""
        {
            "model": {
                "type": "minecraft:model",
                "model": "$it",
                "tints": [
                    {
                        "type": "minecraft:dye",
                        "index": 0,
                        "default": 16777215
                    }
                ]
            }
        }
    """.trimIndent()})
}


fun createItem(id: Key, template: ItemTemplate = ItemTemplate.BasicModel ) {

    val json = template.value(id.toString())

    logger.info(json)

}