package me.jesusmx.bungee.utils;

import net.md_5.bungee.api.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CC {
    
    public static String translate(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    
    public static List<String> translate(List<String> input) {
        return input.stream().map(CC::translate).collect(Collectors.toList());
    }
    
    public static List<String> translate(String[] lines) {
        return Stream.of(lines).map(CC::translate).collect(Collectors.toList());
    }
}
