package ru.community.communityplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;
import ru.community.communityplugin.Backlife.backEventListener;
import ru.community.communityplugin.data.meliodasData;

public final class CommunityPlugin extends JavaPlugin {

    private void setSettings() {
        Bukkit.setDefaultGameMode(GameMode.SURVIVAL);
    }

    @Override
    public void onEnable() {
        pullOf(); //Init data
        setSettings(); //Init settings

        getServer().getPluginManager().registerEvents(new Events(), this);
        //getServer().getPluginCommand("meliodas").setExecutor(new MeliodasCOMMAND());
        getServer().getPluginManager().registerEvents(new backEventListener(), this);
    }

    private void pullOf() {
        var data = new meliodasData();
        data.pull();
    }




}
