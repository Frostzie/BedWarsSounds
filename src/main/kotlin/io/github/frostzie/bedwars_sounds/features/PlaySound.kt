package io.github.frostzie.bedwars_sounds.features

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import io.github.frostzie.bedwars_sounds.BedWarsSounds
import io.github.frostzie.bedwars_sounds.utils.LoggerProvider
import io.github.frostzie.bedwars_sounds.utils.NameDetection
import net.minecraft.client.Minecraft
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

            // Use a JsonReader and enable lenient mode so slightly malformed/loose JSON is accepted
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
        val chatMessage = event.message.unformattedText
        val playerName = NameDetection.getPlayerName()
        if (playerName.isBlank()) {
            return
        }

        if (killMessageTemplates.isEmpty()) {
            logger.warning("No kill message templates loaded, skipping message checking.")
            return
        }

        for ((eventType, template) in killMessageTemplates) {
            if (messageMatches(template, chatMessage, playerName)) {
                logger.info("Match found for eventType: '$eventType'")
                playSound(eventType)
                return
            }
        }
    }

    private fun messageMatches(template: String, message: String, playerName: String): Boolean {
        val numberPattern = Regex(" #\\S+")

        val finalTemplate = template.replace("PLAYER", playerName).replace(" #", "")
        val cleanedMessage = numberPattern.replace(message, "")

        val isMatch = cleanedMessage.contains(finalTemplate)
        if (isMatch) {
            logger.info("[Debug] Matched: Cleaned template: '$finalTemplate' in Cleaned message: '$cleanedMessage'")
        }
        return isMatch
    }

    private fun playSound(eventType: String) {
        val soundCategory = BedWarsSounds.config.soundCategory
        val soundToPlay = when (eventType) {
            "NormalKill" -> soundCategory.normalKillSound
            "VoidKill" -> soundCategory.voidKillSound
            "BowKill" -> soundCategory.bowKillSound
            "GroundKill" -> soundCategory.groundKillSound
            "GolemKill" -> soundCategory.golemKillSound
            "BedBreak" -> soundCategory.bedBreakSound
            "CustomFinal" -> soundCategory.customFinalSound
            else -> null
        }

        soundToPlay?.getSoundName()?.let {
            logger.info("Kill event '$eventType' detected! Playing sound '$it'")
            Minecraft.getMinecraft().thePlayer?.playSound(it, 1.0f, 1.0f)
        }
    }
}