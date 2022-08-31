package dev.brokenstudio.brokentumble.listener;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.enums.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(e.getTo().getY() < 30){
            if(Tumble.getGameState() != GameState.INGAME){
                e.getPlayer().teleport(BrokenAPI.api().getLocationAPI().get("tumble_lobby"));
            }else{
                //TODO TELEPORT TO LAST CHECKPOINT
            }
        }
    }

}
