package com.gmail.mrblackdev.radioactivespt;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

/**
 * Copyright @ Mr_Black_Is_Back (C)
 * All rights reserved.
 * --------------------------------
 * By all means - no one has permission
 * to take or copy any part of this
 * project. If you would like to use
 * some of this code you can contact
 * me via email: jamesbehan198@gmail.com
 * --------------------------------
 * Time / Date: 16:21 / 21/02/2015
 */
public class Core extends JavaPlugin {

    // STP Cooldown:
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    /*
    Main class, conatins the onEnable, onDisable, registerCommands and registerEvents Methods.
     */

    public void onEnable() {
        registerCommands(); // Register Command
        registerEvents();  // Register Event.
    }

    public void onDisable() {

    }

    public void registerCommands() {
        getCommand("spt").setExecutor(new SPTCommand(this));
    }

    public void registerEvents() {
        PluginManager  pm = Bukkit.getServer().getPluginManager();


    }
}

