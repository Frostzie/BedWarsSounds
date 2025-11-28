package io.github.frostzie.bedwars_sounds.utils

import io.github.frostzie.bedwars_sounds.BedWarsSounds
import net.minecraft.client.Minecraft

object NameDetection {
    fun getPlayerName(): String {
        val nick = BedWarsSounds.config.mainCategory.nickName
        if (!nick.isNullOrBlank()) {
            return nick
        }
        return Minecraft.getMinecraft().thePlayer?.name ?: ""
    }
}