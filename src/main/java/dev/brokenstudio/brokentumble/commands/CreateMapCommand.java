package dev.brokenstudio.brokentumble.commands;

import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.map.Map;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateMapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player))
            return true;
        Player player = (Player) commandSender;

        if(args.length < 2){
            player.sendMessage(Tumble.getPrefix() + "/createmap <name> <builder...>");
            return true;
        }

        if(player.getInventory().getItemInMainHand().getType() == Material.AIR){
            player.sendMessage(Tumble.getPrefix() + "You need to have an Item in your hand.");
            return true;
        }

        if(Tumble.tumble().getMapHandler().mapExists(args[0])){
            player.sendMessage(Tumble.getPrefix() + "The map you try to create already exists.");
            return true;
        }

        Material icon = player.getInventory().getItemInMainHand().getType();

        String[] builder = new String[args.length-1];
        for(int i = 0; i < builder.length; i++){
            builder[i] = args[i+1];
        }

        Map map = new Map(args[0], icon, builder);
        Tumble.tumble().getMapHandler().addMap(map);
        player.sendMessage(Tumble.getPrefix() + "The map was created.");

        return true;
    }
}
