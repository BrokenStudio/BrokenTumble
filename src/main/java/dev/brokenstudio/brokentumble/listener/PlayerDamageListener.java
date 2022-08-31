package dev.brokenstudio.brokentumble.listener;

import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.enums.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(Tumble.getGameState() != GameState.INGAME){
            e.setCancelled(true);
            return;
        }
    }

}
