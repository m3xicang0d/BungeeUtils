package me.jesusmx.bungee.utils;

import net.md_5.bungee.api.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CC
{
    public static String BLUE;
    public static String AQUA;
    public static String YELLOW;
    public static String RED;
    public static String GRAY;
    public static String GOLD;
    public static String GREEN;
    public static String WHITE;
    public static String BLACK;
    public static String BOLD;
    public static String ITALIC;
    public static String STRIKE_THROUGH;
    public static String RESET;
    public static String MAGIC;
    public static String DARK_BLUE;
    public static String DARK_AQUA;
    public static String DARK_GRAY;
    public static String DARK_GREEN;
    public static String DARK_PURPLE;
    public static String DARK_RED;
    public static String LIGHT_PURPLE;
    public static String CHAT_BAR;
    public static String MENU_BAR;
    public static String SB_BAR;
    public static String CONSOLE_NAME;
    public static String BLANK_LINE;
    public static String GRAY_LINE;
    
    public static String translate(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    
    public static List<String> translate(List<String> input) {
        return input.stream().map(CC::translate).collect(Collectors.toList());
    }
    
    public static List<String> translate(String[] lines) {
        //Mejor no=? xd
        return Stream.of(lines).map(CC::translate).collect(Collectors.toList());
    }
    
    static {
        CC.BLANK_LINE = "§8 §8 §1 §3 §3 §7 §8 §r";
        CC.GRAY_LINE = " §7\u2503 ";
        CC.BLUE = ChatColor.BLUE.toString();
        CC.AQUA = ChatColor.AQUA.toString();
        CC.YELLOW = ChatColor.YELLOW.toString();
        CC.RED = ChatColor.RED.toString();
        CC.GRAY = ChatColor.GRAY.toString();
        CC.GOLD = ChatColor.GOLD.toString();
        CC.GREEN = ChatColor.GREEN.toString();
        CC.WHITE = ChatColor.WHITE.toString();
        CC.BLACK = ChatColor.BLACK.toString();
        CC.BOLD = ChatColor.BOLD.toString();
        CC.ITALIC = ChatColor.ITALIC.toString();
        CC.STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();
        CC.RESET = ChatColor.RESET.toString();
        CC.MAGIC = ChatColor.MAGIC.toString();
        CC.DARK_BLUE = ChatColor.DARK_BLUE.toString();
        CC.DARK_AQUA = ChatColor.DARK_AQUA.toString();
        CC.DARK_GRAY = ChatColor.DARK_GRAY.toString();
        CC.DARK_GREEN = ChatColor.DARK_GREEN.toString();
        CC.DARK_PURPLE = ChatColor.DARK_PURPLE.toString();
        CC.DARK_RED = ChatColor.DARK_RED.toString();
        CC.LIGHT_PURPLE = ChatColor.LIGHT_PURPLE.toString();
        CC.MENU_BAR = ChatColor.STRIKETHROUGH.toString() + "------------------------";
        CC.CHAT_BAR = ChatColor.STRIKETHROUGH.toString() + "------------------------------------------------";
        CC.SB_BAR = ChatColor.STRIKETHROUGH.toString() + "----------------------";
        CC.CONSOLE_NAME = "§4§lConsole";
    }
}
