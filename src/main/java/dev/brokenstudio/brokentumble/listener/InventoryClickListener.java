package dev.brokenstudio.brokentumble.listener;

import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.enums.GameState;
import dev.brokenstudio.brokentumble.team.TeamHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(Tumble.getGameState() == GameState.LOBBY){
            e.setCancelled(true);
            if(e.getView().getTitle().contains("Selection")){
                if(Tumble.tumble().getTeamHandler().getTeamsize() == 2){
                    switch (e.getSlot()){
                        case 20 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.GOLD);
                        case 21 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.YELLOW);
                        case 23 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.RED);
                        case 24 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.PINK);
                    }
                }else{
                    switch (e.getSlot()){
                        case 20 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.GOLD);
                        case 21 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.YELLOW);
                        case 22 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.RED);
                        case 23 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.PINK);
                        case 24 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.GREEN);
                        case 30 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.AQUA);
                        case 31 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.BLUE);
                        case 32 -> Tumble.tumble().getTeamHandler().addPlayerToTeam((Player) e.getWhoClicked(), TeamHandler.Teams.WHITE);
                    }
                }
            }
        }
    }

}
