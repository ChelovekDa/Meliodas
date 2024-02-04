package ru.community.communityplugin;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.*;
import org.jetbrains.annotations.NotNull;
import ru.community.communityplugin.COMMANDS.MeliodasCOMMAND;

import java.util.concurrent.TimeUnit;


public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Привет!");
    }

    @EventHandler
    public void onBlockBreak(@NotNull BlockBreakEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Ты сломал блок!");
    }

    @EventHandler
    public void onItemDrop(@NotNull PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Нельзя выкидывать предметы!");
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) throws InterruptedException {
//        var trigger = new MeliodasCOMMAND();
//        boolean activeTrigger = trigger.returnTrigger();
//        System.out.println("onPlayerDamage is active with activeTrigger on: " + trigger.activeTrigger);
//        if (activeTrigger) {
        if (event.getDamager().getType() == EntityType.PLAYER) {
            TimeUnit.SECONDS.sleep(2);
            if (event.getEntity().getType() == EntityType.PLAYER) {
                broadMethods.damagePlayer((Player) event.getEntity(), 1000000);
            }
            else broadMethods.killEntity(event.getEntity());
        }
        else {
            System.out.println("[onPlayerDamage] Damager is not a player!");
        }
    }
}