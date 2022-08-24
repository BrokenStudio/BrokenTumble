package dev.brokenstudio.brokentumble;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.commands.SetCommand;
import dev.brokenstudio.brokentumble.enums.GameState;
import dev.brokenstudio.brokentumble.listener.PlayerConnectionListener;
import dev.brokenstudio.brokentumble.scoreboard.LobbyScoreboard;
import org.bukkit.plugin.java.JavaPlugin;

public class Tumble extends JavaPlugin {

    private final static String PREFIX = "§f§lTumble §8§l| §r§7";
    private static GameState gameState;
    private static Tumble tumble;
    private LobbyScoreboard lobbyScoreboard;

    @Override
    public void onEnable() {
        tumble = this;
        BrokenAPI.api().getLocationAPI().loadLocationSet("tumble");
        BrokenAPI.api().getLanguageAPI().loadLanguageSet("tumble");
        gameState = GameState.LOBBY;
        lobbyScoreboard = new LobbyScoreboard();
        _initialize();
    }

    private void _initialize() {
        getCommand("set").setExecutor(new SetCommand());
        getServer().getPluginManager().registerEvents(new PlayerConnectionListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static String getPrefix() {
        return PREFIX;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        Tumble.gameState = gameState;
    }

    public LobbyScoreboard getLobbyScoreboard() {
        return lobbyScoreboard;
    }

    public static Tumble tumble(){
        return tumble;
    }
}
