package ru.community.communityplugin;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import ru.community.communityplugin.data.meliodasData;

import java.util.concurrent.TimeUnit;


public class Events implements Listener {

    broadMethods methods = new broadMethods();

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
        //System.out.println("miliodas strike");
        if (event.getDamager().getType() == EntityType.PLAYER) {
            if (event.getDamager().isOp()) {
                TimeUnit.SECONDS.sleep(2);
                if (event.getEntity().getType() == EntityType.PLAYER) {
                    methods.damagePlayer((Player) event.getEntity(), 1000000);
                } else methods.killEntity(event.getEntity()); }
        }
    }

    @EventHandler
    public void FULLCounter(PlayerInteractEntityEvent event) throws InterruptedException {
        if (event.getHand() == EquipmentSlot.HAND) {
            if (event.getPlayer().isOp()) {
                if (event.getRightClicked().getType() == EntityType.PLAYER) {
                    var data = new meliodasData();
                    data.fullCounter(event.getPlayer(), methods.takenDamage(event.getPlayer()), event.getRightClicked());
                    data.clear(event.getPlayer(), event.getRightClicked());
                }
            }
        }
    }
}