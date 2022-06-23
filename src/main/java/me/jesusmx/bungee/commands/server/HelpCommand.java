package me.jesusmx.bungee.commands.server;

import me.jesusmx.bungee.BungeeUtils;
import me.jesusmx.bungee.utils.CC;
import me.jesusmx.bungee.utils.CreatorYML;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HelpCommand extends Command {

    private final CreatorYML config = BungeeUtils.getInstance().getConfigYML();

    public HelpCommand() {
        super("help", "");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        }
        CC.translate(config.getConfiguration().getStringList("HELP.TEXT"));
    }
}
