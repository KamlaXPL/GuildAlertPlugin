package me.kamlax.guildalert.command

import me.kamlax.guildalert.extension.sendActionBar
import me.kamlax.guildalert.extension.sendColoredMessage
import me.kamlax.guildalert.extension.sendUsage
import net.dzikoysk.funnyguilds.basic.user.User
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class GuildAlertCommand : CommandExecutor {
    private val timeMap = hashMapOf<UUID, Long>()

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            val user = User.get(sender)
            if (!user.hasGuild()) {
                sender.sendColoredMessage("&4Blad: &cNie posiadasz gildii!")
                return true
            }
            if (!user.isOwner) {
                sender.sendColoredMessage("&4Blad: &cNie jestes zalozycielem gildii!")
                return true
            }
            if (args.size < 2) {
                sender.sendUsage()
                return true
            }
            if (timeMap[sender.uniqueId] ?: 0 < System.currentTimeMillis()) {
                timeMap[sender.uniqueId] = System.currentTimeMillis() + 30000L
                val message = StringUtils.join(args, " ", 1, args.size)
                when (args[0].toLowerCase()) {
                    "chat" -> user.guild.onlineMembers.forEach { sender.sendColoredMessage(message) }
                    "title" -> user.guild.onlineMembers.forEach { sender.sendTitle(message, "") }
                    "subtitle" -> user.guild.onlineMembers.forEach { sender.sendTitle("", message) }
                    "actionbar" -> user.guild.onlineMembers.forEach { sender.sendActionBar(message) }
                }
            } else sender.sendColoredMessage("&4Blad: &cTej komendy mozesz uzywac co 30 sekund!")
        }
        return true
    }
}