package com.gmail.mrblackdev.radioactivespt;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Copyright @ Mr_Black_Is_Back (C)
 * All rights reserved.
 * --------------------------------
 * By all means - no one has permission
 * to take or copy any part of this
 * project. If you would like to use
 * some of this code you can contact
 * me via email: jamesbehan198@gmail.com
 * Time / Date: 16:24 / 21/02/2015
 */
public class SPTCommand implements CommandExecutor {

    public Core plugin;

    public SPTCommand(Core instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to preform this command!");
            return true;
        }

        Player p = (Player) sender;

        if (p.hasPermission("spt.strength")) {
            if (label.equalsIgnoreCase("spt")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.BLUE + "==== SPT ====");
                    p.sendMessage(ChatColor.GOLD + "/spt strength " + ChatColor.GRAY + ChatColor.ITALIC +
                            "Gives you strength 1 for 1 minute.");
                    p.sendMessage(ChatColor.GOLD + "/spt speed " + ChatColor.GRAY + ChatColor.ITALIC +
                            "Gives you speed 1 for 1 minute!");
                    p.sendMessage(ChatColor.GOLD + "/spt fireres " + ChatColor.GRAY + ChatColor.ITALIC +
                            "Gives you fire resistance 1 for 1 minute!");

                    return true;
                } else {
                    if (args[0].equalsIgnoreCase("strength")) {
                        int cooldownTime = 900; // Get number of seconds from wherever you want
                        if (plugin.Scooldowns.containsKey(p.getName())) {
                            long secondsLeft = ((plugin.Scooldowns.get(p.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                            if (secondsLeft > 0) {
                                // Still cooling down
                                p.sendMessage(ChatColor.RED + "You cant use that commands for another " + ChatColor.AQUA + ChatColor.ITALIC + secondsLeft + " seconds!");
                                return true;
                            }
                        }
                        // No cooldown found or cooldown has expired, save new cooldown
                        plugin.Scooldowns.put(p.getName(), System.currentTimeMillis());
                        p.sendMessage(ChatColor.GOLD + "You have been given strength 2 for 1 minute!");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0));
                        return true;
                    } else if (args[0].equalsIgnoreCase("speed")) {
                        int cooldownTime = 900; // Get number of seconds from wherever you want
                        if (plugin.SPcooldowns.containsKey(p.getName())) {
                            long secondsLeft = ((plugin.SPcooldowns.get(p.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                            if (secondsLeft > 0) {
                                // Still cooling down
                                p.sendMessage(ChatColor.RED + "You cant use that commands for another " + ChatColor.AQUA + ChatColor.ITALIC + secondsLeft + " seconds!");
                                return true;
                            }
                        }
                        // No cooldown found or cooldown has expired, save new cooldown
                        plugin.SPcooldowns.put(p.getName(), System.currentTimeMillis());
                        p.sendMessage(ChatColor.GOLD + "You have been given speed 2 for 1 minute!");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1));
                        return true;


                    } else if (args[0].equalsIgnoreCase("fireres")) {
                        int cooldownTime = 900; // Get number of seconds from wherever you want
                        if (plugin.Fcooldowns.containsKey(p.getName())) {
                            long secondsLeft = ((plugin.Fcooldowns.get(p.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                            if (secondsLeft > 0) {
                                // Still cooling down
                                p.sendMessage(ChatColor.RED + "You cant use that commands for another " + ChatColor.AQUA + ChatColor.ITALIC + secondsLeft + " seconds!");
                                return true;
                            }
                        }
                        // No cooldown found or cooldown has expired, save new cooldown
                        plugin.Fcooldowns.put(p.getName(), System.currentTimeMillis());
                        p.sendMessage(ChatColor.GOLD + "You have been given fire resistance  2 for 1 minute!");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 1));
                        return true;
                    }
                }
            }


        }
        return true;
    }
}
