package io.github.frostzie.bedwars_sounds.features

import io.github.frostzie.bedwars_sounds.BedWarsSounds
import net.minecraft.client.Minecraft

object SoundTest {
    fun playTestSound(soundName: String?) {
        soundName?.let {
            // Get volume from config (0-100) and convert to 0.0-1.0 range
            val volumePercent = BedWarsSounds.config.soundCategory.soundVolume
            val volume = volumePercent / 100f

            Minecraft.getMinecraft().thePlayer?.playSound(it, volume, 1.0f)
        }
    }
}