package io.github.frostzie.bedwars_sounds

import io.github.frostzie.bedwars_sounds.commands.CommandManager
import io.github.frostzie.bedwars_sounds.config.ConfigManager
import io.github.frostzie.bedwars_sounds.config.categories.ModConfig
import io.github.frostzie.bedwars_sounds.features.PlaySound
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = BedWarsSounds.MOD_ID, useMetadata = true)
class BedWarsSounds {

    private val soundPlayer = PlaySound()

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        configManager = ConfigManager()
        MinecraftForge.EVENT_BUS.register(configManager)
        MinecraftForge.EVENT_BUS.register(this)
        MinecraftForge.EVENT_BUS.register(soundPlayer)
    }

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        CommandManager()
    }

    companion object {
        lateinit var configManager: ConfigManager
        const val MOD_ID = "bedwars-sounds"

        @JvmStatic
        val version: String
            get() = Loader.instance().indexedModList[MOD_ID]!!.version

        val config: ModConfig
            get() = configManager.config ?: error("config is null")
    }
}
