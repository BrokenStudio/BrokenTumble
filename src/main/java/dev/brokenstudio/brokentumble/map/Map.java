package dev.brokenstudio.brokentumble.map;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.HashSet;

public class Map {

    private String name;
    private Material icon;
    private HashSet<String> builders;

    public Map(String name, Material icon, String... builders){
        this.name = name;
        this.icon = icon;
        this.builders = new HashSet<>(Arrays.asList(builders));
    }

    public String getName() {
        return name;
    }

    public Material getIcon() {
        return icon;
    }

    public HashSet<String> getBuilders() {
        return builders;
    }
}
