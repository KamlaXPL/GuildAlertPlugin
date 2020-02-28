package me.kamlax.guildalert

import me.kamlax.guildalert.command.GuildAlertCommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        getCommand("goglos").executor = GuildAlertCommand()
    }
}