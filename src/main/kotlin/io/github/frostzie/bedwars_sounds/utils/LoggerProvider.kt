package io.github.frostzie.bedwars_sounds.utils

import java.util.logging.Logger

object LoggerProvider {
    private const val MAIN = "BedWars-Sounds"

    fun getLogger(name: String): Logger {
        val fullName = "$MAIN: $name"
        return Logger.getLogger(fullName)
    }
}