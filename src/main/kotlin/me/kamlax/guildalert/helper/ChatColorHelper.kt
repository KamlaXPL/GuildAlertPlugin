package me.kamlax.guildalert.helper

import org.bukkit.ChatColor

object ChatColorHelper {
    fun fixColor(message: String): String {
        return ChatColor.translateAlternateColorCodes('&', message
            .replace(">>", "»")
            .replace("<<", "«"))
    }
}