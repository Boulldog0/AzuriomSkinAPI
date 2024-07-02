package fr.Boulldogo.AzuriomSkinAPI;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

   public String skinApiUrl;

    @Override
    public void onEnable() {
 
        getLogger().info("AzuriomSkinApi plugin loaded with success !.");

        saveDefaultConfig();
        skinApiUrl = getConfig().getString("skin_api_url");

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        this.getCommand("skin-update").setExecutor(new SkinUpdateCommand(this));
        this.getCommand("azuriomskinapi-reload").setExecutor(new ReloadCommand(this));
        this.getCommand("forceupdate-skin").setExecutor(new ForceUpdateSkinCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("AzuriomSkinApi plugin unloaded with success !");
    }

}
