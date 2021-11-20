package com.tsukilo.antishulkercrash;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiShulkerCrash extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(this,this);

        System.out.println();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onCrashAttempt(BlockDispenseEvent e){
        if(e.getBlock().getY() >= 255 | e.getBlock().getY() <= 1){
            System.out.println("Crash attempted at block: " + e.getBlock().getLocation());
            e.setCancelled(true);
        }
    }
}
