package dev.brokenstudio.brokentumble.listener;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.Tumble;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage(null);
        //TEMP
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        //TEMP
        switch (Tumble.getGameState()){
            case LOBBY -> {
                Bukkit.getOnlinePlayers().forEach(cr -> cr.sendMessage(Tumble.getPrefix()
                + "The player §f" + player.getName() + " §7has joined the game."));
                Tumble.tumble().getLobbyScoreboard().getBoard().setBoard(player);
                player.teleport(BrokenAPI.api().getLocationAPI().get("tumble_lobby"));
            }
            case INGAME -> {


            }

            case ENDING -> {


            }
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();

        switch (Tumble.getGameState()){
            case LOBBY -> {


            }
            case INGAME -> {


            }

            case ENDING -> {


            }
        }

    }

}
