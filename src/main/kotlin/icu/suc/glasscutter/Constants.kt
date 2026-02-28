@file:JvmName("Constants")

package icu.suc.glasscutter

import icu.suc.glasscutter.item.GlassCutterItem
import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Block

@JvmField
val GLASSWORK: TagKey<Block> = TagKey.create(
    Registries.BLOCK,
    Identifier.fromNamespaceAndPath("glasscutter", "glasswork")
)

@JvmField
val GLASS_CUTTER: Item = Items.registerItem(
    ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("glasscutter", "glasscutter")),
    ::GlassCutterItem, Item.Properties().durability(1486).component(
        DataComponents.TOOL,
        GlassCutterItem.createToolProperties()
    )
)
