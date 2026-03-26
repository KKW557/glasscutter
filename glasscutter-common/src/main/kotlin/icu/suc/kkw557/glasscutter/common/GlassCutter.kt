@file:JvmName("ClassCutter")

package icu.suc.kkw557.glasscutter.common

import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.component.Tool

const val MOD_ID = "assets/glasscutter"

fun identifier(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, path)

object Items {
    @JvmField
    val GLASSCUTTER: Item = Items.registerItem(
        ResourceKey.create(
            Registries.ITEM,
            identifier("assets/glasscutter")
        )
    ) { properties ->
        Item(
            properties.durability(1486).component(
                DataComponents.TOOL,
                Tool(
                    listOf(
                        Tool.Rule.minesAndDrops(
                            BuiltInRegistries.acquireBootstrapRegistrationLookup(
                                BuiltInRegistries.BLOCK
                            ).getOrThrow(Tags.Block.GLASSWORK), 1024.0F
                        )
                    ), 1.0F, 1, true
                )
            )
        )
    }

    @JvmStatic
    fun register() {
    }
}

object Tags {
    object Block {
        @JvmField
        val GLASSWORK: TagKey<net.minecraft.world.level.block.Block> = TagKey.create(
            Registries.BLOCK,
            identifier("glasswork")
        )

        @JvmStatic
        fun register() {

        }
    }

    @JvmStatic
    fun register() {
        Block.register()
    }
}