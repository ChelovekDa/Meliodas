package ru.community.communityplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommunityPlugin extends JavaPlugin {

    private void EE(escanorData data) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                CheckEscanor(data);
            }
        }, 10L, 40L);
    }

    private void setSettings() {
        Bukkit.setDefaultGameMode(GameMode.SURVIVAL);
    }

    private void CheckEscanor(escanorData data) {
        data.checkEscanor();
    }

    private void pullOf() {
        var data = new meliodasData();
        boolean result = data.pull();
        if (!result) {
            System.out.println("\n");
            boolean doubleResult = data.pull();
            if (!doubleResult) System.out.println("\n");
        }
    }

    @Override
    public void onEnable() {
        pullOf(); //Init data for meliodas
        setSettings(); //Init settings
        var data = new escanorData();
        EE(data); //Init infinity check for escanors

        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginCommand("meliodas").setExecutor(new MeliodasCOMMAND());
        getServer().getPluginCommand("init").setExecutor(new ggbb());
        getServer().getPluginManager().registerEvents(new backEventListener(), this);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }
}
