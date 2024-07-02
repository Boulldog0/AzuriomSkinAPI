package fr.Boulldogo.AzuriomSkinAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private final Main plugin;

    public ReloadCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String reloadError = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("reload_error"));
        String reloadSuccess = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("reload_success"));

        if (args.length == 1 && args[0].equalsIgnoreCase("azuriomskinapi-reload")) {
            try {
                String commandToExecute = "plugin reload azuriomskinapi";
                plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), commandToExecute);
                sender.sendMessage(reloadSuccess);
            } catch (Exception e) {
                sender.sendMessage(reloadError + ChatColor.RED + "Error occured when trying to reload plugin : " + e.getMessage());
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }
}
