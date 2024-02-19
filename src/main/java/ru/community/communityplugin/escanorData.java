package ru.community.communityplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class escanorData {
      //                   FULL START                                                            START  END                                                            FULL END
    public static long times[] = {23900, 0, 500, 1200, 1800, 2300, 2900, 3700, 4000, 4500, 4800, 6000, 7200, 7800, 8800, 9000, 10000, 10800, 11200, 11800, 12000, 12700, 12800};
    //                              1    2   3     4     5     6     7     8    9     10    11    12    13    14     15    16   17     18     19     20     21     22     23

    public boolean trigger = true;

    public void checkEscanor() {
        ArrayList<Player> TARGETS = new ArrayList<>();

        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            if (trigger) {
                var meliodasTrigger = new meliodasData();
                final boolean TRIGGER = meliodasTrigger.activeTrigger;

                if (TRIGGER) {
                    System.out.println("Включение способности Эсканора невозможно, когда включена способность Мелиодаса!");
                    trigger = false;
                }
                if (!TRIGGER) {
                    var PLAYERS = Bukkit.getOnlinePlayers();
                    for (int i = 0; i < PLAYERS.size(); i++) {
                        var object = PLAYERS.toArray()[i];

                        if (((Player) object).isOp()) gainBuffs(((Player) object), levelPower(((Player) object)));
                        else continue;
                    }
                }
            }
            else return;
        }
        if (Bukkit.getOnlinePlayers().isEmpty()) return;
    }

    public int levelPower(Player player) {
        int localLevel = 0;

        long object = Ceil(player.getWorld().getTime());
        for (int i = 0; i < times.length; i++) {
            if (object == 24000) object = 0;
            if (object == times[i]) localLevel = i + 1;
            else continue;
        }

        return localLevel;
    }

    public void gainBuffs(Player player, int level) {
        if (level == 1) {
            String mes = ChatColor.GRAY + "Берегитесь.. " + ChatColor.RED + "Солнце уже начало восходить..";
            Bukkit.broadcastMessage(ChatColor.ITALIC + mes);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 1, true, false, false));
        }
        if (level == 2) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 1, true, false, false));
        }
        if (level == 3) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 4) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 5) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 3, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 6) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 5, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 3, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 4, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 1, true, false, false));
        }
        if (level == 7) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 6, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 3, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 5, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 1, true, false, false));
        }
        if (level == 8) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 7, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 6, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 1, true, false, false));
        }
        if (level == 9) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 8, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 6, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 1, true, false, false));
        }
        if (level == 10) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 9, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 7, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 11) {
            String mes = ChatColor.GRAY + "Прячтесь, убегайте, отступайте!.. " + ChatColor.RED + "Полдень уже близко!..";
            Bukkit.broadcastMessage(ChatColor.BOLD + mes);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 10, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 7, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 2, true, false, false));
        }
        if (level == 12) {
            String mes = ChatColor.GRAY + "Осталось только молиться.. " + ChatColor.RED + "Полдень уже наступил!";
            Bukkit.broadcastMessage(ChatColor.BOLD + mes);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 24, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 7, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 55, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 255, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 5, 2, true, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999, 255, true, false, false));
        }
        if (level == 13) {
            String mes = ChatColor.GRAY + "Действие милости \"Солнце\" начало ослабевать..";
            Bukkit.broadcastMessage(ChatColor.ITALIC + mes);
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 2, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 7, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 10, true, false, false));
        }
        if (level == 14) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 10, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 6, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 2, true, false, false));
        }
        if (level == 15) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 9, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 5, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 2, true, false, false));
        }
        if (level == 16) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 8, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 4, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 5, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 2, true, false, false));
        }
        if (level == 17) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 7, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 3, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 5, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 18) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 6, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 3, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 5, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 19) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 5, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 2, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 4, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 20) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 4, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 2, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 3, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 21) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 3, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 1, true, false, false));
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 2, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 22) {
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 2, true, false, false));
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 1, true, false, false));
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999999, 1, true, false, false));
        }
        if (level == 23) {
            String mes = ChatColor.GRAY + "Люди могут спать спокойно.. " + ChatColor.RED + "Действие милости \"Солнце\" прошло!";
            Bukkit.broadcastMessage(ChatColor.ITALIC + mes);
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.removePotionEffect(PotionEffectType.SATURATION);
            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        }
        else return;

    }

    private long Ceil(long TIME) {
        double object = (double) TIME / 100;
        long round = Math.round(object);
        round = round * 100;

        return round;
    }

}
