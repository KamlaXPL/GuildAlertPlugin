package me.kamlax.guildalert.extension

import me.kamlax.guildalert.helper.ChatColorHelper
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

fun CommandSender.msg(message: String) = sendMessage(ChatColorHelper.fixColor(message))

fun Player.sendUsage() {
    msg("&8>> &7Poprawne uzycie: &6/goglos <chat|title|subtitle|actionbar> <tekst>")
}