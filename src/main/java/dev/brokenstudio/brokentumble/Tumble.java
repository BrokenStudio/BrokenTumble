package dev.brokenstudio.brokentumble;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.commands.CreateMapCommand;
import dev.brokenstudio.brokentumble.commands.SetCommand;
import dev.brokenstudio.brokentumble.enums.GameState;
import dev.brokenstudio.brokentumble.listener.*;
import dev.brokenstudio.brokentumble.map.GameMapHandler;
import dev.brokenstudio.brokentumble.map.MapHandler;
import dev.brokenstudio.brokentumble.scoreboard.LobbyScoreboard;
import dev.brokenstudio.brokentumble.team.TeamHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Tumble extends JavaPlugin {

    private final static String PREFIX = "§f§lTumble §8§l| §r§7";
    private static GameState gameState;
    private static Tumble tumble;
    private LobbyScoreboard lobbyScoreboard;
    private TeamHandler teamHandler;
    private MapHandler mapHandler;
    private GameMapHandler gameMapHandler;

    @Override
    public void onEnable() {
        tumble = this;
        BrokenAPI.api().getLocationAPI().loadLocationSet("tumble");
        BrokenAPI.api().getLanguageAPI().loadLanguageSet("tumble");
        gameState = GameState.LOBBY;
        lobbyScoreboard = new LobbyScoreboard();
        teamHandler = new TeamHandler(8);
        mapHandler = new MapHandler();
        gameMapHandler = new GameMapHandler();
        gameMapHandler._initalize();
        _initialize();
    }

    private void _initialize() {
        getCommand("set").setExecutor(new SetCommand());
        getCommand("createmap").setExecutor(new CreateMapCommand());
        getServer().getPluginManager().registerEvents(new PlayerConnectionListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    @Override
    public void onDisable() {
        mapHandler.saveMaps();
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

    public TeamHandler getTeamHandler() {
        return teamHandler;
    }

    public MapHandler getMapHandler() {
        return mapHandler;
    }

    public GameMapHandler getGameMapHandler() {
        return gameMapHandler;
    }
}
