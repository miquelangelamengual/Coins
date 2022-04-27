package es.hulk.coins.utils;

/*
 * Copyright (c) 2020, Jordi Xavier. All rights reserved.
 *
 * Do not redistribute without permission from the author.
 */

import es.hulk.coins.Coins;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskUtil {

    private static final Coins plugin = Coins.getInstance();

    public static void runTaskAsync(Runnable runnable) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, runnable);
    }

    public static void runTaskLater(Runnable runnable, long delay) {
        plugin.getServer().getScheduler().runTaskLater(plugin, runnable, delay);
    }

    public static void runTaskTimer(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimer(plugin, delay, timer);
    }

    public static void runTaskTimer(Runnable runnable, long delay, long timer) {
        plugin.getServer().getScheduler().runTaskTimer(plugin, runnable, delay, timer);
    }

    public static void runTaskTimerAsync(Runnable runnable, long delay, long timer) {
        plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, timer);
    }

    public static void run(Runnable runnable) {
        plugin.getServer().getScheduler().runTask(plugin, runnable);
    }
}
