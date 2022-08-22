package dev.brokenstudio.brokentumble.commands;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.Tumble;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)){
            Bukkit.getLogger().info("This command can only be used by players.");
            return true;
        }

        if(args.length != 1){
            commandSender.sendMessage(Tumble.getPrefix() + "§c/set <location>");
            return true;
        }

        String location = args[0];
        BrokenAPI.api().getLocationAPI().set("tumble", location, ((Player) commandSender).getLocation());
        commandSender.sendMessage(Tumble.getPrefix() + "The location was set.");

        return true;
    }
}
