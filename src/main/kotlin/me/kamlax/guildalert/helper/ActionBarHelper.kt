package me.kamlax.guildalert.helper

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player

object ActionBarHelper {
    fun sendActionBar(player: Player, message: String) {
        val player = player as CraftPlayer
        val chatBaseComponent = IChatBaseComponent.ChatSerializer.a(ChatColorHelper.fixColor("{\"text\": \"$message\"}"))
        val packetplayeroutchat = PacketPlayOutChat(chatBaseComponent, 2.toByte())
        player.handle.playerConnection.sendPacket(packetplayeroutchat)
    }
}