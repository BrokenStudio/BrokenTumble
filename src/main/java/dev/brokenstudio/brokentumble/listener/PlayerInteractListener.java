package dev.brokenstudio.brokentumble.listener;

import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.enums.GameState;
import dev.brokenstudio.brokentumble.inventories.TeamSelection;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(Tumble.getGameState() == GameState.LOBBY){
            e.setCancelled(true);
            if(e.getItem() == null)return;
            if(e.getItem().getType() == Material.LEATHER_CHESTPLATE){
                TeamSelection.openSelection(e.getPlayer());
            }
        }
    }

}
