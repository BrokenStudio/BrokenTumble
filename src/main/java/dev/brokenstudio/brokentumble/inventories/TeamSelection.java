package dev.brokenstudio.brokentumble.inventories;

import dev.brokenstudio.brokenapi.item.BrokenItem;
import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.team.TeamHandler;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TeamSelection {

    public static void openSelection(Player player){
        TeamHandler handler = Tumble.tumble().getTeamHandler();
        Inventory inv = null;
        if(handler.getTeamsize() == 2){
            inv = Bukkit.createInventory(player, 9*5, Tumble.getPrefix() + "Team-Selection");
            inv.setItem(20, getChest(TeamHandler.Teams.GOLD, handler));
            inv.setItem(21, getChest(TeamHandler.Teams.YELLOW, handler));
            inv.setItem(23, getChest(TeamHandler.Teams.RED, handler));
            inv.setItem(24, getChest(TeamHandler.Teams.PINK, handler));
        }else{
            inv = Bukkit.createInventory(player, 9*6, Tumble.getPrefix() + "Team-Selection");
            inv.setItem(20, getChest(TeamHandler.Teams.GOLD, handler));
            inv.setItem(21, getChest(TeamHandler.Teams.YELLOW, handler));
            inv.setItem(22, getChest(TeamHandler.Teams.RED, handler));
            inv.setItem(23, getChest(TeamHandler.Teams.PINK, handler));
            inv.setItem(24, getChest(TeamHandler.Teams.GREEN, handler));
            inv.setItem(30, getChest(TeamHandler.Teams.AQUA, handler));
            inv.setItem(31, getChest(TeamHandler.Teams.BLUE, handler));
            inv.setItem(32, getChest(TeamHandler.Teams.WHITE, handler));
        }
        player.openInventory(inv);
    }

    private static ItemStack getChest(TeamHandler.Teams team, TeamHandler handler){
        ItemStack leather = new BrokenItem(Material.LEATHER_CHESTPLATE).name(Tumble.getPrefix() + team.color + team.teamName).hideAttributes().addItemFlags(ItemFlag.HIDE_DYE);
        LeatherArmorMeta meta = (LeatherArmorMeta) leather.getItemMeta();
        meta.setColor(team.dyeColor);
        meta.setLore(handler.getTeamLore(team));
        leather.setItemMeta(meta);
        return leather;
    }

}
