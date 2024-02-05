package ru.community.communityplugin.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class meliodasData {

    private boolean activeTrigger = false;

    private ArrayList<Double> damageHistory = new ArrayList<>();
    private ArrayList<Player> damagerHistory = new ArrayList<>();
    private ArrayList<Entity> targetsHistory = new ArrayList<>();

    public void setActiveTrigger(boolean value) {
        this.activeTrigger = value;
    }

    public boolean getActiveTrigger() {
        return this.activeTrigger;
    }

    public ArrayList<Double> getDamageHistory() { return this.damageHistory; }

    public ArrayList<Player> getDamagerHistory() { return this.damagerHistory; }

    public ArrayList<Entity> getTargetsHistory() { return this.targetsHistory; }

    public void addToDamageHistory(double target) { this.damageHistory.add(target); }

    public void addToDamagerHistory(Player target) { this.damagerHistory.add(target); }

    public void addToTargetsHistory(Entity target) { this.targetsHistory.add(target); }

    public void fullStrike(Player player, double attack, Entity entity) throws InterruptedException {
        double damage = attack * 2.5;
        Math.round(damage);

        if (entity.getType() == EntityType.PLAYER) {
            float power = powerExplosion(damage);
            Location location = entity.getLocation();

            Player target = (Player) entity;
            player.setInvulnerable(true);
            target.damage(damage, player);
            World world = entity.getWorld();
            world.createExplosion(location, power);

            Bukkit.broadcastMessage("Игрок " + player.getName() + " использовал способность <Мстительное отражение>!\nАтака нанесла противнику " + damage + " единиц урона!");
            TimeUnit.SECONDS.sleep(5);
            player.setInvulnerable(false);
        }
        else player.sendMessage("Использование способности <Мстительное отражение> не на игроках не возможно!");
    }

    private float powerExplosion(double damage) {
        int result = 0;

        if (damage <= 50) result += 1;
        if (damage <= 100) result += 3;
        if (damage <= 150) result += 4;
        if (damage <= 180) result += 6;
        if (damage <= 200) result = 8;
        if (damage <= 230) result += 10;
        if (damage <= 250) result += 11;
        if (damage <= 290) result += 15;
        if (damage <= 300) result += 17;
        if (damage <= 350) result += 20;
        if (damage <= 380) result += 22;
        if (damage <= 400) result += 24;
        if (damage <= 450) result += 28;
        if (damage <= 500) result += 32;
        if (damage <= 600) result += 35;
        if (damage > 601) result += 40;

        return result;
    }
}
