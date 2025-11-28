package io.github.frostzie.bedwars_sounds.features

import net.minecraft.client.Minecraft

object SoundTest {
    fun playTestSound(soundName: String?) {
        soundName?.let {
            Minecraft.getMinecraft().thePlayer?.playSound(it, 1.0f, 1.0f)
        }
    }
}
