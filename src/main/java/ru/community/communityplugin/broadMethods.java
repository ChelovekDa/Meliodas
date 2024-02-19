package ru.community.communityplugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class broadMethods {

    public void killEntity(Entity entity) {
        entity.remove();
    }

    public void damagePlayer(Player player, int damage) {
        player.damage(damage);
    }

    public double takenDamage(Entity entity) {
        var data = new meliodasData();

        System.out.println("TAKEN:\n" + data.damageHistory + "\n" + data.targetsHistory + "\n" + data.damagerHistory + "\n");

        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Entity> localTargets = data.targetsHistory;

        for (int i = 0; i < data.targetsHistory.size(); i++) {
            int index = localTargets.indexOf(entity);

            if (index >= 0) {
                indexes.add(index);
                localTargets.remove(index);
            }
            if (index <= -1) break;
        }

        //Подсчет атаки
        double result = 0;
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            result += data.damageHistory.get(index);
            indexes.remove(i);
        }

        System.out.println("result = " + result);
        return result;
    }

    public void addHistoryToMeliodasData(double damage, Entity target, Player damager) {
        var data = new meliodasData();

        data.targetsHistory.add(target);
        data.damageHistory.add(damage);
        data.damagerHistory.add(damager);
        System.out.println("\n" + data.targetsHistory + "\n" + data.damageHistory + "\n" + data.damagerHistory);
    }
}
