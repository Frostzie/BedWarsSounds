package io.github.frostzie.bedwars_sounds.config

import net.minecraft.client.Minecraft
import net.minecraft.client.audio.SoundHandler
import net.minecraft.util.ResourceLocation

object SoundRegistry {
    private val customSounds = mutableMapOf<String, String>()

    init {
        // Add default sounds
        customSounds["None"] = ""
        customSounds["Boomer"] = "bedwars_sounds:boomer"
        customSounds["Bruh"] = "bedwars_sounds:bruh"
        customSounds["Gotcha"] = "bedwars_sounds:gotcha"
        customSounds["Noice"] = "bedwars_sounds:noice"
        customSounds["Okey"] = "bedwars_sounds:okey"
        customSounds["Oof"] = "bedwars_sounds:oof"
        customSounds["Quack"] = "bedwars_sounds:quack"
        customSounds["SkeppyJSP"] = "bedwars_sounds:skeppyjsp"
    }

    /**
     * Scans loaded resource packs for custom bedwars_sounds sounds
     * Call this after resource packs are loaded
     */
    fun scanForCustomSounds() {
        try {
            val soundHandler = Minecraft.getMinecraft().soundHandler
            val soundRegistry = getSoundRegistry(soundHandler)

            // Iterate through all registered sounds
            for (key in soundRegistry.keys) {
                val resourceLocation = key

                // Check if it's a bedwars_sounds sound and not already registered
                if (resourceLocation.resourceDomain == "bedwars_sounds") {
                    val soundName = resourceLocation.resourcePath
                    val displayName = formatDisplayName(soundName)

                    if (!customSounds.containsValue("bedwars_sounds:$soundName")) {
                        customSounds[displayName] = "bedwars_sounds:$soundName"
                        println("Discovered custom sound: $displayName -> bedwars_sounds:$soundName")
                    }
                }
            }
        } catch (e: Exception) {
            println("Error scanning for custom sounds: ${e.message}")
            e.printStackTrace()
        }
    }

    /**
     * Uses reflection to access the private sndRegistry field
     */
    private fun getSoundRegistry(soundHandler: SoundHandler): Map<ResourceLocation, *> {
        return try {
            val field = SoundHandler::class.java.getDeclaredField("sndRegistry")
            field.isAccessible = true
            @Suppress("UNCHECKED_CAST")
            field.get(soundHandler) as Map<ResourceLocation, *>
        } catch (e: Exception) {
            println("Failed to access sndRegistry via reflection: ${e.message}")
            emptyMap<ResourceLocation, Any>()
        }
    }

    /**
     * Converts "my_custom_sound" to "My Custom Sound"
     */
    private fun formatDisplayName(soundName: String): String {
        return soundName
            .split("_")
            .joinToString(" ") { it.capitalize() }
    }
}