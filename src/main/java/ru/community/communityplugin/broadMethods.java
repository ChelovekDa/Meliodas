package ru.community.communityplugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import ru.community.communityplugin.data.meliodasData;

import java.util.ArrayList;

public class broadMethods {

    public static void killEntity(Entity entity) {
        entity.remove();
    }

    public static void damagePlayer(Player player, int damage) {
        player.damage(damage);
    }

    public static double takenDamage(Entity entity) {
        var data = new meliodasData();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Entity> localTargets = data.getTargetsHistory();

        for (int i = 0; i < data.getTargetsHistory().size(); i++) {
            int index = localTargets.indexOf(entity);

            if (index >= 0) {
                indexes.add(index);
                localTargets.remove(index);
            }
            if (index <= -1) break;
        }

        //Подсчет атаки
        int result = 0;
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            result += data.getDamageHistory().get(index);
            indexes.remove(i);
        }

        return result;
    }

    public void addHistoryToMeliodasData(double damage, Entity target, Player damager) {
        var data = new meliodasData();
        data.addToDamagerHistory(damager);
        data.addToDamageHistory(damage);
        data.addToTargetsHistory(target);
        System.out.println("Added a new log.");
    }

}
