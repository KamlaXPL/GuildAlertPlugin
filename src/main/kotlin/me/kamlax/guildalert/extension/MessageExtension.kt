package me.kamlax.guildalert.extension

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player

fun Player.sendUsage() {
    sendColoredMessage("&8>> &7Poprawne uzycie: &6/goglos <chat|title|subtitle|actionbar> <tekst>")
}

fun String.fixColor() = ChatColor.translateAlternateColorCodes('&', this
    .replace(">>", "»")
    .replace("<<", "«"))

fun CommandSender.sendColoredMessage(message: String) = sendMessage(message.fixColor())

fun Player.sendActionBar(message: String) {
    val iChatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"${message.fixColor()}\"}")
    val packetPlayOutChat = PacketPlayOutChat(iChatBaseComponent, 2)

    (this as CraftPlayer).handle.playerConnection.sendPacket(packetPlayOutChat)
}