package icu.suc.kkw557.glasscutter.fabric

import icu.suc.kkw557.glasscutter.common.Items
import icu.suc.kkw557.glasscutter.common.Tags
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents
import net.minecraft.world.item.CreativeModeTabs

class Main : ModInitializer {
    override fun onInitialize() {
        Items.register()
        Tags.register()
        registerEvents()
    }

    private fun registerEvents() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
            .register { group -> group.accept { Items.GLASSCUTTER } }
    }
}