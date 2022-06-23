package me.jesusmx.bungee.commands.server;

import me.jesusmx.bungee.BungeeUtils;
import me.jesusmx.bungee.utils.CC;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FindCommand extends Command {

    public FindCommand() {
        super("find", "bungeecord.command.find", "findplayer", "find player", "look", "lookup", "where", "whereis");
    }
    
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(CC.translate("&cUsage: /find <player>"));
            return;
        }
        ProxiedPlayer player = BungeeUtils.getInstance().getProxy().getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(CC.translate("&c" + args[0] + " is currently not on the network."));
            return;
        }
        sender.sendMessage(CC.translate("&9" + player.getName() + " &eis currently on &9" + player.getServer().getInfo().getName() + "&e."));
    }
}
