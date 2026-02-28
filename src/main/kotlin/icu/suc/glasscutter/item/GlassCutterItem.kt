package icu.suc.glasscutter.item

import icu.suc.glasscutter.GLASSWORK
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import net.minecraft.world.item.component.Tool

class GlassCutterItem(properties: Properties) : Item(properties) {
    companion object {
        @JvmStatic
        fun createToolProperties(): Tool {
            val lookup = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK)
            return Tool(listOf(Tool.Rule.minesAndDrops(lookup.getOrThrow(GLASSWORK), 1024.0F)), 1.0F, 1, true)
        }
    }
}
