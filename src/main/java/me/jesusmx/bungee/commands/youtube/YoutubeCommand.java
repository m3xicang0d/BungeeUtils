package me.jesusmx.bungee.commands.youtube;

import me.jesusmx.bungee.BungeeUtils;
import me.jesusmx.bungee.utils.CC;
import me.jesusmx.bungee.utils.CreatorYML;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class YoutubeCommand extends Command {

    private final CreatorYML config = BungeeUtils.getInstance().getConfigYML();

    public YoutubeCommand() {
        super("youtube", "", "yt", "youtuber");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        }
        config.getConfiguration().getStringList("YOUTUBE.TEXT").stream().map(CC::translate).forEach(sender::sendMessage);
    }
}
