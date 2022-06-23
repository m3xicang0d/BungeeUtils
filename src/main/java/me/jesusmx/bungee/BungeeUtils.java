package me.jesusmx.bungee;

import lombok.Getter;
import lombok.Setter;
import me.jesusmx.bungee.commands.BungeeCommand;
import me.jesusmx.bungee.commands.media.DiscordCommand;
import me.jesusmx.bungee.commands.media.TeamSpeakCommand;
import me.jesusmx.bungee.commands.media.TelegramCommand;
import me.jesusmx.bungee.commands.media.TwitterCommand;
import me.jesusmx.bungee.commands.server.*;
import me.jesusmx.bungee.commands.youtube.FamousCommand;
import me.jesusmx.bungee.commands.youtube.MediaCommand;
import me.jesusmx.bungee.commands.youtube.PartnerCommand;
import me.jesusmx.bungee.commands.youtube.YoutubeCommand;
import me.jesusmx.bungee.handlers.BungeeHandler;
import me.jesusmx.bungee.listeners.BungeeListener;
import me.jesusmx.bungee.utils.CreatorYML;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.scheduler.ScheduledTask;

@Getter @Setter
public class BungeeUtils extends Plugin {

    @Getter private static BungeeUtils instance;
    private BungeeHandler bungeeHandler;
    private ScheduledTask scheduledTask;
    private CreatorYML configYML;

    public void onEnable() {
        BungeeUtils.instance = this;
        this.files();
        this.handlers();
        this.listeners();
        this.commands();
    }

    public void onDisable() {
        configYML.getConfiguration().set("WHITELIST.PLAYERS", this.bungeeHandler.getWhitelists());
        getInstance().getScheduledTask().cancel();
    }

    private void files() {
        this.configYML = new CreatorYML(this, "config.yml");
    }

    private void handlers() {
        this.bungeeHandler = new BungeeHandler();
    }

    private void listeners() {
        this.getProxy().getPluginManager().registerListener(this, new BungeeListener());
    }

    private void commands() {
        this.getProxy().getPluginManager().registerCommand(this, new HubCommand());
        this.getProxy().getPluginManager().registerCommand(this, new MaintenanceCommand());
        this.getProxy().getPluginManager().registerCommand(this, new FindCommand());
        this.getProxy().getPluginManager().registerCommand(this, new ServerCommand());
        this.getProxy().getPluginManager().registerCommand(this, new TeamSpeakCommand());
        this.getProxy().getPluginManager().registerCommand(this, new DiscordCommand());
        this.getProxy().getPluginManager().registerCommand(this, new TwitterCommand());
        this.getProxy().getPluginManager().registerCommand(this, new TelegramCommand());
        this.getProxy().getPluginManager().registerCommand(this, new MediaCommand());
        this.getProxy().getPluginManager().registerCommand(this, new YoutubeCommand());
        this.getProxy().getPluginManager().registerCommand(this, new FamousCommand());
        this.getProxy().getPluginManager().registerCommand(this, new PartnerCommand());
        this.getProxy().getPluginManager().registerCommand(this, new BungeeCommand());
        this.getProxy().getPluginManager().registerCommand(this, new HelpCommand());
    }

    public void whitelist(boolean enabled) {
        configYML.getConfiguration().set("WHITELIST.ENABLED", enabled);
        configYML.save();
        configYML.reload();
    }
}