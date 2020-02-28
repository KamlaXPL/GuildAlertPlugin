package me.kamlax.guildalert.helper

import org.bukkit.ChatColor

object ChatColorHelper {
    fun String.fixColor(): String =
        ChatColor.translateAlternateColorCodes('&', this
            .replace(">>", "»")
            .replace("<<", "«"))
}