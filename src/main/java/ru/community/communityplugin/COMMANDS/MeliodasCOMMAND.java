package ru.community.communityplugin.COMMANDS;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MeliodasCOMMAND implements CommandExecutor {

    public boolean activeTrigger = false;

    private final String weaponsActive = "The Community's magic weapons are active!";
    private final String weaponsDisActive = "The Community's magic weapons are dis active!";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (activeTrigger == false & sender.isOp()) {
            activeTrigger = true;
            sender.sendMessage(this.weaponsActive);
            System.out.println("OnTrigger is: " + activeTrigger);
        }
        else {
            activeTrigger = false;
            sender.sendMessage(this.weaponsDisActive);
            System.out.println("OnTrigger is: " + activeTrigger);
        }
        return activeTrigger;
    }

    public boolean returnTrigger() {
        return activeTrigger;
    }
}
