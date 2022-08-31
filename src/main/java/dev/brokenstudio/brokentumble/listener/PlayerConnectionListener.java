package dev.brokenstudio.brokentumble.listener;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.inventories.HotBar;
import dev.brokenstudio.brokentumble.tablist.Tablist;
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
        Tablist.setupBoard(player);
        switch (Tumble.getGameState()){
            case LOBBY -> {
                Bukkit.getOnlinePlayers().forEach(cr -> cr.sendMessage(Tumble.getPrefix()
                + "§f§l" + player.getName() + " §r§7has joined the game§8§l! (§f§l" + Bukkit.getOnlinePlayers().size() + "§8§l/§7§l8§8§l)"));
                Tumble.tumble().getLobbyScoreboard().getBoard().setBoard(player);
                player.teleport(BrokenAPI.api().getLocationAPI().get("tumble_lobby"));
                HotBar.set(player);
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
        e.setQuitMessage(null);
        switch (Tumble.getGameState()){
            case LOBBY -> {
                Tumble.tumble().getTeamHandler().removePlayerFromTeam(player);
                Bukkit.getOnlinePlayers().forEach(cr -> {
                    if(cr != player)
                        cr.sendMessage(Tumble.getPrefix()
                            + "§f§l" + player.getName() + " §r§7has joined the game§8§l! (§f§l" + (Bukkit.getOnlinePlayers().size()-1) + "§8§l/§7§l8§8§l)");
                });
            }
            case INGAME -> {


            }

            case ENDING -> {


            }
        }

    }

}
