package fr.Boulldogo.AzuriomSkinAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        String skinUrl = plugin.getConfig().getString("skin_api_url").replace("{player}", playerName);
        int Time = plugin.getConfig().getInt("delay_tick");

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            String command = "skin set " + playerName + " " + skinUrl;
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
           

            if (plugin.getConfig().getBoolean("send_success_message")) {
                String successMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("success_message"));
                player.sendMessage(successMessage);
            }

            if (plugin.getConfig().getBoolean("send_console_logs")) {
                String logMessage = ChatColor.translateAlternateColorCodes('&', "Skin de " + playerName + " changé avec succès.");
                plugin.getLogger().info(logMessage);
            }
            
        }, Time);
    }
}
