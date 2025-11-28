package io.github.frostzie.bedwars_sounds.commands

import io.github.frostzie.bedwars_sounds.BedWarsSounds
import io.github.frostzie.bedwars_sounds.commands.SimpleCommand.ProcessCommandRunnable
import net.minecraft.command.ICommandSender
import net.minecraftforge.client.ClientCommandHandler

class CommandManager {

    init {
        registerCommand("bedWarsSoundsConfig") {
            BedWarsSounds.configManager.openConfigGui()
        }
    }

    private fun registerCommand(name: String, function: (Array<String>) -> Unit) {
        ClientCommandHandler.instance.registerCommand(SimpleCommand(name, createCommand(function)))
    }

    private fun createCommand(function: (Array<String>) -> Unit) = object : ProcessCommandRunnable() {
        override fun processCommand(sender: ICommandSender?, args: Array<String>?) {
            if (args != null) function(args.asList().toTypedArray())
        }
    }
}