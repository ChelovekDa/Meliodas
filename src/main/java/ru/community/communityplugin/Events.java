package ru.community.communityplugin;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.*;
import org.jetbrains.annotations.NotNull;
import ru.community.communityplugin.data.meliodasData;

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
    public void MeliodasStrike(EntityDamageByEntityEvent event) throws InterruptedException {
//        var trigger = new meliodasData();
//        System.out.println("onPlayerDamage is active with activeTrigger on: " + trigger.getActiveTrigger());
//        if (trigger.getActiveTrigger()) {
        if (event.getDamager().getType() == EntityType.PLAYER & event.getDamager().isOp()) {
            TimeUnit.SECONDS.sleep(2);
            if (event.getEntity().getType() == EntityType.PLAYER) {
                broadMethods.damagePlayer((Player) event.getEntity(), 1000000);
            } else broadMethods.killEntity(event.getEntity());
        } else {
            System.out.println("[onPlayerDamage] Damager is not a player!");
        }
    }

    @EventHandler
    public void FULLStrike(PlayerInteractEntityEvent event) throws InterruptedException {
        if (event.getPlayer().isOp()) {
            if (event.getRightClicked().getType() == EntityType.PLAYER) {
                var data = new meliodasData();
                data.fullStrike(event.getPlayer(), broadMethods.takenDamage(event.getPlayer()), event.getRightClicked());
            }
        }
    }
}