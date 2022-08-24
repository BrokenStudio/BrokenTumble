package dev.brokenstudio.brokentumble.scoreboard;

import dev.brokenstudio.brokenapi.player.BrokenPlayer;
import dev.brokenstudio.brokenapi.scoreboard.BrokenBoard;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicReference;

public class LobbyScoreboard {

    /*
    ▪ Square
    ♦ Diamond
    ☄ Comet
    ✈ Plane
    ☁ Cloud
     */

    private BrokenBoard board;

    {
        board = new BrokenBoard("§f§lTumble", false);
        board.addLine(24);
        board.addEntry(" §f☄ §8§l| §7Map");
        //TODO REPLACE WITH ACTUAL MAP STATE
        board.addEntry(" §7♦ §8▪▪▪ §f§lVoting");
        board.addEmpty();
        board.addEntry(" §f✈ §8§l| §7Countdown");
        //TODO REPLACE WITH ACTUAL COUNTDOWN TIME
        board.addEntry((player, player2, stringAtomicReference) -> {
            stringAtomicReference.set(" §7♦ §8▪▪▪ §f§l45");
        });
        board.addEmpty();
        board.addEntry(" §f☁ §8§l| §7Teams");
        board.addEntry(" §7♦ §8▪▪▪ §c§lForbidden");
        board.addLine(24);
        board.addEmpty();
        board.addEntry("§f§lBrokenStudio.de");
    }

    public BrokenBoard getBoard(){
        return board;
    }

}
