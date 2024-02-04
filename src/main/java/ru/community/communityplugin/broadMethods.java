package ru.community.communityplugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class broadMethods {

    public static void killEntity(Entity entity) {
        entity.remove();
    }

    public static void damagePlayer(Player player, int damage) {
        player.damage(damage);
    }

}
