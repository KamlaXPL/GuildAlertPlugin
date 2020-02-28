package me.kamlax.guildalert.helper

import org.bukkit.ChatColor

object ChatColorHelper {
    fun fixColor(message: String) = ChatColor.translateAlternateColorCodes('&', message
        .replace(">>", "»")
        .replace("<<", "«"))
}