package dev.brokenstudio.brokentumble.team;

import dev.brokenstudio.brokentumble.Tumble;
import dev.brokenstudio.brokentumble.inventories.TeamSelection;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TeamHandler {

    public enum Teams{
        GOLD("§6", Color.ORANGE, "Gold"),
        YELLOW("§e", Color.YELLOW, "Yellow"),
        RED("§c", Color.RED, "Red"),
        PINK("§d", Color.FUCHSIA, "Pink"),
        GREEN("§a", Color.GREEN, "Green"),
        AQUA("§b", Color.TEAL, "Aqua"),
        BLUE("§9", Color.BLUE, "Blue"),
        WHITE("§f", Color.WHITE, "White");

        public String color;
        public Color dyeColor;
        public String teamName;

        Teams(String color, Color dyeColor, String teamName){
            this.color = color;
            this.dyeColor = dyeColor;
            this.teamName = teamName;
        }

    }

    private HashSet<Teams> usedTeams;
    private HashMap<Player, Teams> playerTeam;
    private HashMap<Teams, ArrayList<Player>> teamPlayers;
    private int teamsize;

    public TeamHandler(int amount){
        usedTeams = new HashSet<>();
        teamPlayers = new HashMap<>();
        for (Teams value : Teams.values()) {
            teamPlayers.put(value, new ArrayList<>());
        }
        if(amount == 4){
            teamsize = 2;
            usedTeams.add(Teams.GOLD);
            usedTeams.add(Teams.YELLOW);
            usedTeams.add(Teams.RED);
            usedTeams.add(Teams.PINK);
        }
        if(amount == 8){
            teamsize = 1;
            usedTeams.add(Teams.GREEN);
            usedTeams.add(Teams.AQUA);
            usedTeams.add(Teams.BLUE);
            usedTeams.add(Teams.WHITE);
        }
        playerTeam = new HashMap<>();
    }

    public Teams getPlayerTeam(Player player){
        return playerTeam.get(player);
    }

    public boolean isPlayerInTeam(Player player){
        return playerTeam.containsKey(player);
    }

    public ArrayList<Player> getPlayersOfTeam(Teams team){
        return teamPlayers.get(team);
    }

    public void addPlayerToTeam(Player player, Teams team){
        removePlayerFromTeam(player);
        if(teamPlayers.get(team).size() == teamsize)
            return;
        playerTeam.put(player, team);
        teamPlayers.get(team).add(player);
        Bukkit.getOnlinePlayers().forEach(cr -> {
            cr.getScoreboard().getTeam("none").removePlayer(player);
            cr.getScoreboard().getTeam(team.toString().toLowerCase()).addPlayer(player);
        });
        Tumble.tumble().getLobbyScoreboard().getBoard().update(player);
        TeamSelection.openSelection(player);
    }

    public void removePlayerFromTeam(Player player){
        if(!isPlayerInTeam(player))
            return;
        Teams team = getPlayerTeam(player);
        Bukkit.getOnlinePlayers().forEach(cr -> {
            cr.getScoreboard().getTeam(team.toString().toLowerCase()).removePlayer(player);
            cr.getScoreboard().getTeam("none").addPlayer(player);
        });
        teamPlayers.get(team).remove(player);
        playerTeam.remove(player);
    }

    public ArrayList<String> getTeamLore(Teams teams){
        ArrayList<String> list = new ArrayList<>();
        list.add("§8- §7❌");
        if(teamsize == 2){
            list.add("§8- §7❌");
        }
        ArrayList<Player> player = teamPlayers.get(teams);
        for(int i = 0; i < player.size(); i++){
            list.set(i, "§8- " + teams.color + player.get(i).getName());
        }
        return list;
    }

    public int getTeamsize() {
        return teamsize;
    }
}
