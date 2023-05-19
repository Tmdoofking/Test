package com.playfuni;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // 在插件啟用時執行的代碼
        getCommand("heal").setExecutor(this);
        getCommand("feed").setExecutor(this);
        getCommand("slay").setExecutor(this);
        getLogger().info("MyPlugin已啟用！");
    }

    @Override
    public void onDisable() {
        // 在插件停用時執行的代碼
        getLogger().info("MyPlugin已停用！");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "只有玩家可以使用這個指令！");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("heal")) {
            // /heal 指令
            player.setHealth(player.getMaxHealth());
            player.sendMessage(ChatColor.GREEN + "你已被治癒！");
            return true;
        }

        if (command.getName().equalsIgnoreCase("feed")) {
            // /feed 指令
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "你已經飽食了！");
            return true;
        }

        if (command.getName().equalsIgnoreCase("slay")) {
            // /slay 指令
            player.setHealth(0);
            player.sendMessage(ChatColor.RED + "你已被殺死！");
            return true;
        }

        return false;
    }
}
