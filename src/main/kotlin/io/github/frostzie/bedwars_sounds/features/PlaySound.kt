package io.github.frostzie.bedwars_sounds.features

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import io.github.frostzie.bedwars_sounds.BedWarsSounds
import io.github.frostzie.bedwars_sounds.config.SoundOptions
import io.github.frostzie.bedwars_sounds.utils.LoggerProvider
import io.github.frostzie.bedwars_sounds.utils.NameDetection
import net.minecraft.client.Minecraft
import net.minecraft.util.EnumChatFormatting
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.io.File

class PlaySound {

    private val logger = LoggerProvider.getLogger("BedWarsSounds")
    private val killMessageTemplates: Map<String, String> by lazy {
        loadKillMessageTemplates()
    }

    private fun loadKillMessageTemplates(): Map<String, String> {
        val messagesFile = File("config/BedWarsSounds/KillMessages.json")

        return try {
            val gson = GsonBuilder().create()
            val type = object : TypeToken<Map<String, Map<String, String>>>() {}.type

            if (!messagesFile.isFile) {
                logger.warning("KillMessages.json not found at ${messagesFile.path}")
                return emptyMap()
            }

            JsonReader(messagesFile.reader()).use { jsonReader ->
                jsonReader.isLenient = true
                val nestedMap: Map<String, Map<String, String>> = gson.fromJson(jsonReader, type)
                val templates = nestedMap.values.flatMap { it.entries }.associate { it.key to it.value }
                logger.info("Successfully loaded ${templates.size} kill message templates.")
                templates
            }
        } catch (e: Exception) {
            logger.warning("Error parsing KillMessages.json: ${e.message}")
            e.printStackTrace()
            emptyMap()
        }
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

        val chatMessage = event.message.unformattedText
        val playerName = NameDetection.getPlayerName()

        if (playerName.isBlank()) {
            return
        }

        if (killMessageTemplates.isEmpty()) {
            return
        }

        for ((eventType, template) in killMessageTemplates) {
            if (messageMatches(template, chatMessage, playerName)) {
                //logger.info("Match found for eventType: '$eventType'")

                val cleanMessage = stripColorCodes(chatMessage)
                if (cleanMessage.contains("FINAL KILL") &&
                    getSoundName("FinalKill") != null) {
                    playSound("FinalKill")
                } else {
                    playSound(eventType)
                }
                return // Only trigger one sound per message
            }
        }
    }

    /**
     * Checks if a chat message matches a kill message template.
     *
     * Expected format: "VictimName kill by PLAYER."
     * Where PLAYER is replaced with the actual player name.
     *
     * The # symbol in templates is a placeholder for numbers/text (e.g., "final #3", "Bed was #1 destroyed")
     */
    private fun messageMatches(template: String, message: String, playerName: String): Boolean {
        // Strip all Minecraft color/formatting codes from the message
        val cleanMessage = stripColorCodes(message)

        // Replace PLAYER placeholder with the actual player name
        val processedTemplate = template.replace("PLAYER", playerName)

        // Remove the # placeholder from template for matching
        val templateWithoutHash = processedTemplate.replace(" #", "")

        // Remove the actual dynamic content from the cleaned message (numbers/text after certain keywords)
        val cleanedMessage = cleanMessage.replace(Regex(" #\\S+"), "")

        // Check if the cleaned message contains the template
        val isMatch = cleanedMessage.contains(templateWithoutHash, ignoreCase = true)

        //if (isMatch) {
        //    logger.info("[Match] Template: '$templateWithoutHash' found in Message: '$cleanedMessage'")
        //}

        return isMatch
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

        // Determine which fields to check based on event type
        val (customField, dropdownField) = when (eventType) {
            "NormalKill" -> soundCategory.normalKillSoundCustom to soundCategory.normalKillSound
            "VoidKill" -> soundCategory.voidKillSoundCustom to soundCategory.voidKillSound
            "BowKill" -> soundCategory.bowKillSoundCustom to soundCategory.bowKillSound
            "GroundKill" -> soundCategory.groundKillSoundCustom to soundCategory.groundKillSound
            "GolemKill" -> soundCategory.golemKillSoundCustom to soundCategory.golemKillSound
            "BedBreak" -> soundCategory.bedBreakSoundCustom to soundCategory.bedBreakSound
            "CustomKill" -> soundCategory.customKillSoundCustom to soundCategory.customKillSound
            "FinalKill" -> soundCategory.customFinalSoundCustom to soundCategory.customFinalSound
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

        val player = Minecraft.getMinecraft().thePlayer
        player?.playSound(soundName, volume, 1.0f)
    }
}