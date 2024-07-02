package fr.Boulldogo.AzuriomSkinAPI;

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

        String command = "skin set " + playerName + " " + skinUrl + ".png";
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);

        if(plugin.getConfig().getBoolean("send_success_message")) {
            String successMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("success_message"));
            player.sendMessage(successMessage);
        }

        if(plugin.getConfig().getBoolean("send_console_logs")) {
            plugin.getLogger().info("Skin of player " + playerName + " update with success !");
		}
    }
}
