package me.jesusmx.bungee.commands;

import me.jesusmx.bungee.BungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class BungeeCommand extends Command {

    public BungeeCommand() {
        super("test");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args[0].equalsIgnoreCase("reload")) {
            BungeeUtils.getInstance().getConfigYML().reload();
        }

    }
}
