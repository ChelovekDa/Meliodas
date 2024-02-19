package ru.community.communityplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class backEventListener implements Listener {

    broadMethods methods = new broadMethods();

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        String message = String.valueOf(event.getDamage());
        Bukkit.broadcastMessage("damage = " + message);
        try {
            methods.addHistoryToMeliodasData(event.getDamage(), event.getEntity(), (Player) event.getDamager());
        } catch (ClassCastException e) {
            return;
        }

    }

}
