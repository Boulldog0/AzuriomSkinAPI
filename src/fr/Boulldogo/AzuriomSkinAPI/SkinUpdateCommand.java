package fr.Boulldogo.AzuriomSkinAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkinUpdateCommand implements CommandExecutor {

    private final Main plugin;

    public SkinUpdateCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playerName = player.getName();
            String skinUrl = plugin.getConfig().getString("skin_api_url").replace("{player}", playerName);
            String commandToExecute = "skin set " + playerName + " " + skinUrl;
            
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), commandToExecute);
            
            if (plugin.getConfig().getBoolean("send_success_message")) {
                String successMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("success_message"));
                player.sendMessage(successMessage);
            }

            if (plugin.getConfig().getBoolean("send_console_logs")) {
                String logMessage = ChatColor.translateAlternateColorCodes('&', "Skin de " + playerName + " changé avec succès.");
                plugin.getLogger().info(logMessage);
            }

        } else {
            sender.sendMessage("§cSeuls les joueurs peuvent utiliser cette commande !");
        }
        return true;
    }
}
