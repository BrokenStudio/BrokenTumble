package dev.brokenstudio.brokentumble;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokentumble.commands.SetCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Tumble extends JavaPlugin {

    private final static String PREFIX = "§f§lTumble §8| §7";

    @Override
    public void onEnable() {
        BrokenAPI.api().getLocationAPI().loadLocationSet("tumble");
        BrokenAPI.api().getLanguageAPI().loadLanguageSet("tumble");
        _initialize();
    }

    private void _initialize() {
        getCommand("set").setExecutor(new SetCommand());
    }

    @Override
    public void onDisable() {

    }

    public static String getPrefix(){
        return PREFIX;
    }
}
