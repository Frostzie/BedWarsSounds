package io.github.frostzie.bedwars_sounds.features

import io.github.frostzie.bedwars_sounds.BedWarsSounds
import io.github.frostzie.bedwars_sounds.config.KillMessageTemplate
import io.github.frostzie.bedwars_sounds.config.SoundOptions
import io.github.frostzie.bedwars_sounds.utils.LoggerProvider
import io.github.frostzie.bedwars_sounds.utils.NameDetection
import net.minecraft.client.Minecraft
import net.minecraft.util.EnumChatFormatting
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

class PlaySound {

    private val logger = LoggerProvider.getLogger("BedWarsSounds")
    private val killMessages: List<String> by lazy {
        KillMessageTemplate.getAllMessages()
    }

    init {
        logger.info("Loaded ${killMessages.size} kill message templates from enum")
    }

    @SubscribeEvent
    fun onChatReceived(event: ClientChatReceivedEvent) {
        // Check if mod is enabled
        if (!BedWarsSounds.config.mainCategory.enableMod) {
            return
        }

        // Skip action bar messages (type 2)
        if (event.type.toInt() == 2) {
            return
        }

        val rawMessage = event.message.unformattedText
        val cleanMessage = stripColorCodes(rawMessage)
        val playerName = NameDetection.getPlayerName()

        if (playerName.isBlank()) {
            return
        }
        val isFinalKill = cleanMessage.contains("FINAL KILL!")
        val isBedBreak = cleanMessage.contains("BED DESTRUCTION > ")

        if (isBedBreak && cleanMessage.contains(playerName)) {
            //logger.info("Matched bed break message by player: '$cleanMessage'")
            playSound("BedBreak")
            return
        }

        // Split message to get the part after the victim name
        val parts = cleanMessage.split(" ", limit = 2)
        if (parts.size > 1) {
            val messageWithoutVictim = parts[1]

            // Replace PLAYER placeholder with actual player name
            for (template in killMessages) {
                val formattedTemplate = template.replace("PLAYER", playerName)

                if (messageWithoutVictim.startsWith(formattedTemplate)) {
                    // If it's a final kill, play final kill sound if configured
                    //logger.info("Matched kill message: '$cleanMessage'")
                    if (isFinalKill && getSoundName("FinalKill") != null) {
                        //logger.info("Playing FinalKill sound.")
                        playSound("FinalKill")
                    } else {
                        // Otherwise determine the kill type and play that sound
                        val killType = KillMessageTemplate.getKillType(template)
                        //logger.info("Kill type is '$killType'. Playing sound.")
                        killType?.let { playSound(it) }
                    }
                    return
                }
            }
        }
    }

    /**
     * Strips all Minecraft formatting codes from a string (§ codes and legacy &)
     */
    private fun stripColorCodes(text: String): String {
        return EnumChatFormatting.getTextWithoutFormattingCodes(text) ?: text
    }

    /**
     * Gets the sound name for an event type, prioritizing custom text field over dropdown
     */
    private fun getSoundName(eventType: String): String? {
        val soundCategory = BedWarsSounds.config.soundCategory
        val customSoundCategory = BedWarsSounds.config.customSoundCategory

        val (customField, dropdownField) = when (eventType) {
            "NormalKill" -> customSoundCategory.normalKillSoundCustom to soundCategory.normalKillSound
            "VoidKill" -> customSoundCategory.voidKillSoundCustom to soundCategory.voidKillSound
            "BowKill" -> customSoundCategory.bowKillSoundCustom to soundCategory.bowKillSound
            "GroundKill" -> customSoundCategory.groundKillSoundCustom to soundCategory.groundKillSound
            "GolemKill" -> customSoundCategory.golemKillSoundCustom to soundCategory.golemKillSound
            "BedBreak" -> customSoundCategory.bedBreakSoundCustom to soundCategory.bedBreakSound
            "FinalKill" -> customSoundCategory.finalKillSoundCustom to soundCategory.finalKillSound
            else -> {
                logger.warning("Unknown event type: $eventType")
                return null
            }
        }

        // Priority: custom text field > dropdown enum
        return when {
            // If custom field has content, use it
            customField.isNotBlank() -> customField
            // Otherwise use dropdown, but only if not NONE
            dropdownField != SoundOptions.NONE -> dropdownField.soundName
            // No sound selected
            else -> null
        }
    }

    private fun playSound(eventType: String) {
        val soundName = getSoundName(eventType) ?: return
        // Get volume from config (0-100) and convert to 0.0-1.0 range
        val volumePercent = BedWarsSounds.config.soundCategory.soundVolume
        val volume = volumePercent / 100f

        try {
            val player = Minecraft.getMinecraft().thePlayer
            player?.playSound(soundName, volume, 1.0f)
        } catch (e: Exception) {
            logger.warning("Failed to play sound $soundName: ${e.message}")
        }
    }
}