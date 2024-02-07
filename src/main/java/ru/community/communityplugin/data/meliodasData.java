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

    public boolean activeTrigger = false;

    private ArrayList<Double> damageHistory = new ArrayList<>();
    private ArrayList<Player> damagerHistory = new ArrayList<>();
    private ArrayList<Entity> targetsHistory = new ArrayList<>();
    private ArrayList<Integer> eventsTimeHistory = new ArrayList<>();

    public ArrayList<Integer> getEventsTimeHistory() { return eventsTimeHistory; }

    private void pullMeliodasData() {
        damageHistory.add(0D);
        damagerHistory.add(null);
        targetsHistory.add(null);
        eventsTimeHistory.add(0);
    }

    public void pull() {
        pullMeliodasData();
    }

    public void setActiveTrigger(boolean value) {
        this.activeTrigger = value;
    }

    public ArrayList<Double> getDamageHistory() { return this.damageHistory; }

    public ArrayList<Player> getDamagerHistory() { return this.damagerHistory; }

    public ArrayList<Entity> getTargetsHistory() { return this.targetsHistory; }

    public void addToEventsTimeHistory(int time) { this.eventsTimeHistory.add(time); }

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
            //world.createExplosion(location, power);
            world.createExplosion(location, 4F);

            System.out.println("FullStrike stats:\n*Damage: " + damage + "\n*Power of explosion: " + powerExplosion(damage) + "\n*Target: " + target.getName() + "\n*Damager: " + player.getName());
            Bukkit.broadcastMessage("Игрок " + player.getName() + " использовал способность <Мстительное отражение>!\nАтака нанесла противнику " + damage + " единиц урона!");
            TimeUnit.SECONDS.sleep(5);
            player.setInvulnerable(false);
        }
        else player.sendMessage("Использование способности <Мстительное отражение> не на игроках не возможно!");
    }

    private float powerExplosion(double damage) {
        float result = 0;

        if (damage <= 50) result += 1F;
        if (damage <= 100) result += 3F;
        if (damage <= 150) result += 4F;
        if (damage <= 180) result += 6F;
        if (damage <= 200) result += 8F;
        if (damage <= 230) result += 10F;
        if (damage <= 250) result += 11F;
        if (damage <= 290) result += 15F;
        if (damage <= 300) result += 17F;
        if (damage <= 350) result += 20F;
        if (damage <= 380) result += 22F;
        if (damage <= 400) result += 24F;
        if (damage <= 450) result += 28F;
        if (damage <= 500) result += 32F;
        if (damage <= 600) result += 35F;
        if (damage > 601) result += 40F;
        else {
            result += 4F;
        }

        return result;
    }
}
