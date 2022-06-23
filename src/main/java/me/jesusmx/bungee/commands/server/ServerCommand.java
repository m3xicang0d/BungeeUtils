package me.jesusmx.bungee.commands.server;

import me.jesusmx.bungee.BungeeUtils;
import me.jesusmx.bungee.utils.CC;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerCommand extends Command {

    public ServerCommand() {
        super("server", "bungeecord.command.server", "connect");
    }
    
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer)commandSender;
            if (player.hasPermission("bungeecord.command.server")) {
                if (args.length == 0) {
                    player.sendMessage(CC.translate("&6You are currently connected to &f" + player.getServer().getInfo().getName() + "&6."));
                    StringBuilder servers = new StringBuilder("&6Servers: &f");
                    boolean first = true;
                    for (String name : BungeeUtils.getInstance().getProxy().getServers().keySet()) {
                        if (first) {
                            servers.append(name);
                        }
                        else {
                            servers.append("&7, &f").append(name);
                        }
                        first = false;
                    }
                    player.sendMessage(CC.translate(servers.toString()));
                    player.sendMessage(CC.translate("&6Connect to a server with &e/server <name>"));
                }
                else if (args.length == 1) {
                    ServerInfo si = BungeeUtils.getInstance().getProxy().getServerInfo(args[0]);
                    if (si != null) {
                        player.sendMessage(CC.translate("&6Connecting you to &f" + si.getName() + "&6!"));
                        player.connect(si);
                    }
                    else {
                        player.sendMessage(CC.translate("&cNo Permission"));
                    }
                }
            }
            else {
                player.sendMessage(CC.translate("&cNo permission."));
            }
        }
    }
}
