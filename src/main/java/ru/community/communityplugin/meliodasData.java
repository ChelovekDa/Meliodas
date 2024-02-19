package ru.community.communityplugin;

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

    public ArrayList<Double> damageHistory = new ArrayList<>();
    public ArrayList<Player> damagerHistory = new ArrayList<>();
    public ArrayList<Entity> targetsHistory = new ArrayList<>();

    private void pullMeliodasData() {
        damageHistory.add(0D);
        damagerHistory.add(null);
        targetsHistory.add(null);
    }

    public void clear(Player damager, Entity entity) {
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Entity> localTargets = targetsHistory;

        for (int i = 0; i < damagerHistory.size(); i++) {
            int index = localTargets.indexOf(entity);

            if (index >= 0) {
                indexes.add(index);
                localTargets.remove(index);
            }
            if (index == -1) break;
        }

        for (int i = 0; i < indexes.size(); i++) {
            damageHistory.remove(indexes.get(i));
            damagerHistory.remove(indexes.get(i));
            targetsHistory.remove(indexes.get(i));
        }

    }

    public boolean pull() {
        pullMeliodasData();

        if (damageHistory.indexOf(0) == -1 || damagerHistory.indexOf(null) == -1 || targetsHistory.indexOf(null) == -1) {
            System.out.println("\nERROR\nlen: " + damagerHistory.size() + damageHistory.size() + targetsHistory.size());
            System.out.println("damagerHistory: ".toUpperCase() + damagerHistory);
            System.out.println("damageHistory: ".toUpperCase() + damageHistory);
            System.out.println("targetsHistory: ".toUpperCase() + targetsHistory);
            return false;
        }

        return true;
    }

    public void setActiveTrigger(boolean value) {
        this.activeTrigger = value;
    }

    public void fullCounter(Player player, double attack, Entity entity) throws InterruptedException {
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
            world.createExplosion(location, 2F);

            System.out.println("FullStrike stats:\n*Damage: " + damage + "\n*Power of explosion: " + powerExplosion(damage) + "\n*Target: " + target.getName() + "\n*Damager: " + player.getName());
            Bukkit.broadcastMessage("Игрок " + player.getName() + " использовал способность <Мстительное отражение>!\nАтака нанесла противнику " + damage + " единиц урона!");
            TimeUnit.SECONDS.sleep(5);
            player.setInvulnerable(false);
        }
        else player.sendMessage("Использование способности <Мстительное отражение> не на игроках не возможно!");
    }

    private float powerExplosion(double damage) {
        float result = 0;

        if (damage <= 50) result = 1F;
        if (damage <= 100) result = 3F;
        if (damage <= 150) result = 4F;
        if (damage <= 180) result = 6F;
        if (damage <= 200) result = 8F;
        if (damage <= 230) result = 10F;
        if (damage <= 250) result = 11F;
        if (damage <= 290) result = 15F;
        if (damage <= 300) result = 17F;
        if (damage <= 350) result = 20F;
        if (damage <= 380) result = 22F;
        if (damage <= 400) result = 24F;
        if (damage <= 450) result = 28F;
        if (damage <= 500) result = 32F;
        if (damage <= 600) result = 35F;
        if (damage > 601) result = 40F;
        else {
            result += 4F;
        }

        return result;
    }
}
