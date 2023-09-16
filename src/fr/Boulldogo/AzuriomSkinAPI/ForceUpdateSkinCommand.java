package fr.Boulldogo.AzuriomSkinAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceUpdateSkinCommand implements CommandExecutor {

    private final Main plugin;

    public ForceUpdateSkinCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            String playerName = args[0];
            Player target = plugin.getServer().getPlayer(playerName);

            if (target != null && target.isOnline()) {
                String skinUrl = plugin.getConfig().getString("skin_api_url").replace("{player}", playerName);
                String commandToExecute = "skin set " + playerName + " " + skinUrl;
                
                plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), commandToExecute);
                
                if (plugin.getConfig().getBoolean("send_success_message")) {
                    String forceUpdateMessageSuccess = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("force_update_success_message"));
                    sender.sendMessage(forceUpdateMessageSuccess);
                }

                if (plugin.getConfig().getBoolean("send_console_logs")) {
                    String logMessage = ChatColor.translateAlternateColorCodes('&', "Skin de " + playerName + " changé avec succès.");
                    plugin.getLogger().info(logMessage);
                }

                return true;
            } else {
                String forceUpdateMessageNoPlayer = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no_player_connected"));
                sender.sendMessage(forceUpdateMessageNoPlayer);
                return false;
            }
        } else {
            sender.sendMessage("§cUtilisation : /forceupdate-skin <utilisateur>");
            return false;
        }
    }
}
