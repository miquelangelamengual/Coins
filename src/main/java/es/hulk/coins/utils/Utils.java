package es.hulk.coins.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: Utils
 */

public class Utils {

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(Utils::color).collect(Collectors.toList());
    }

}
