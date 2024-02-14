package ru.community.communityplugin.COMMANDS.Meliodas;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.community.communityplugin.data.meliodasData;

public class MeliodasCOMMAND implements CommandExecutor {

    private final String weaponsActive = "The Community's magic weapons are active!";
    private final String weaponsDisActive = "The Community's magic weapons are dis active!";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        var trigger = new meliodasData();

        if (!trigger.activeTrigger & sender.isOp()) {
            trigger.setActiveTrigger(true);
            sender.sendMessage(weaponsActive);
            return true;
        }
        else {
            trigger.setActiveTrigger(false);
            sender.sendMessage(weaponsDisActive);
        }

        return trigger.activeTrigger;
    }


}
