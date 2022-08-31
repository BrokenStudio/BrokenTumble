package dev.brokenstudio.brokentumble.inventories;

import dev.brokenstudio.brokenapi.item.BrokenItem;
import dev.brokenstudio.brokenapi.item.Skull;
import dev.brokenstudio.brokentumble.Tumble;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;

import java.util.ArrayList;

public class HotBar {

    public static void set(Player player){
        player.getInventory().clear();
        ItemStack map = new BrokenItem(Material.FILLED_MAP).name(Tumble.getPrefix() + "Map-Voting");
        MapMeta meta = (MapMeta) map.getItemMeta();
        meta.setMapId(0);
        meta.setLore(new ArrayList<>());
        map.setItemMeta(meta);
        player.getInventory().setItem(1, map);
        player.getInventory().setItem(3, new BrokenItem(Material.LEATHER_CHESTPLATE).name(Tumble.getPrefix() + "Team-Selection"));
        player.getInventory().setItem(5, new BrokenItem(Material.BOOK).name(Tumble.getPrefix() + "Rules"));
        player.getInventory().setItem(7, new BrokenItem(Skull.ARROW_RIGHT.getSkull()).name(Tumble.getPrefix() + "Leave"));
    }

}
