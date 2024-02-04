package ru.community.communityplugin;

import org.bukkit.plugin.java.JavaPlugin;
import ru.community.communityplugin.COMMANDS.MeliodasCOMMAND;

public final class CommunityPlugin extends JavaPlugin {

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginCommand("meliodas").setExecutor(new MeliodasCOMMAND());
    }



}
