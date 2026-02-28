package icu.suc.glasscutter

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.world.item.CreativeModeTabs

class Main : ModInitializer {
    override fun onInitialize() {
        initialize()
        registerEvents()
    }

    private fun initialize() {
        GLASSWORK
        GLASS_CUTTER
    }

    private fun registerEvents() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
            .register { g -> g.accept { GLASS_CUTTER } }
    }
}
