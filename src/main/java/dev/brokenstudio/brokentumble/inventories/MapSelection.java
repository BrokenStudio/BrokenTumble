package dev.brokenstudio.brokentumble.inventories;

import dev.brokenstudio.brokenapi.item.BrokenItem;
import dev.brokenstudio.brokentumble.Tumble;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MapSelection {

    public void open(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, Tumble.getPrefix() + "MapVoting");
        inv.setItem(40, new BrokenItem(Material.CARTOGRAPHY_TABLE).name(Tumble.getPrefix() + "MapVoting").glow());

        

    }

}
