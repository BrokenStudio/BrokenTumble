package dev.brokenstudio.brokentumble.scoreboard;

import dev.brokenstudio.brokenapi.scoreboard.BrokenBoard;

public class LobbyScoreboard {

    private BrokenBoard board;

    {
        board = new BrokenBoard("§f§lTumble", false);
        board.addLine(20);
        board.addEntry("§fMap§8:");
        board.addEntry("  §aUnknown");
        board.addEmpty();
        board.addEntry("§fTeams§8:");
        board.addEntry("  §cForbidden");
        board.addLine(20);
        board.addEntry("§f§lBrokenStudio.de");
    }

    public BrokenBoard getBoard(){
        return board;
    }

}
