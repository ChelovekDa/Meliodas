package ru.community.communityplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MeliodasCOMMAND implements CommandExecutor {

    private final String weaponsActive = "The Community's magic weapons are active!";
    private final String weaponsDisActive = "The Community's magic weapons are dis active!";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        var trigger = new meliodasData();

        String mes = "MELIODAS\n" + trigger.damagerHistory + "\n" + trigger.damageHistory + "\n" + trigger.targetsHistory;
        Bukkit.broadcastMessage(mes);

//        if (!trigger.activeTrigger & sender.isOp()) {
//            trigger.setActiveTrigger(true);
//            sender.sendMessage(weaponsActive);
//            return true;
//        }
//        else {
//            trigger.setActiveTrigger(false);
//            sender.sendMessage(weaponsDisActive);
//        }
//
//        return trigger.activeTrigger;
        return true;
    }


}
