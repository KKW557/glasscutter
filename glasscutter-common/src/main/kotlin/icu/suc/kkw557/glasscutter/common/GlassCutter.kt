@file:JvmName("ClassCutter")

package icu.suc.kkw557.glasscutter.common

import net.minecraft.core.Registry
import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.component.Tool

const val MOD_ID = "glasscutter"

fun identifier(path: String): Identifier = Identifier.fromNamespaceAndPath(MOD_ID, path)

object Items {
    @JvmField
    val GLASSCUTTER = register("glasscutter") { properties ->
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
    fun <T : Item> register(id: String, function: (Item.Properties) -> T) = register(id, function, Item.Properties())

    @JvmStatic
    fun <T : Item> register(
        id: String,
        function: (Item.Properties) -> T,
        properties: Item.Properties
    ) = register(identifier(id), function, properties)

    @JvmStatic
    fun <T : Item> register(
        id: Identifier,
        function: (Item.Properties) -> T,
        properties: Item.Properties
    ): T {
        val key = ResourceKey.create(Registries.ITEM, id)
        return Registry.register(
            BuiltInRegistries.ITEM,
            key,
            function(properties.setId(key))
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