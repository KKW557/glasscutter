@file:JvmName("ClassCutter")

package icu.suc.glasscutter

import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.component.Tool
import net.minecraft.world.level.block.Block

@JvmField
val GLASSWORK: TagKey<Block> = TagKey.create(
    Registries.BLOCK,
    Identifier.fromNamespaceAndPath("glasscutter", "glasswork")
)

@JvmField
val GLASSCUTTER: Item = Items.registerItem(
    ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath("glasscutter", "glasscutter")
    )
) { properties ->
    Item(
        properties.durability(1486)
            .component(
                DataComponents.TOOL,
                Tool(
                    listOf(
                        Tool.Rule.minesAndDrops(
                            BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK)
                                .getOrThrow(GLASSWORK), 1024.0F
                        )
                    ), 1.0F, 1, true
                )
            )
    )
}