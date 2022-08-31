package dev.brokenstudio.brokentumble.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Tablist {

    //❌ ■

    public static void setupBoard(Player player){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Team none = scoreboard.registerNewTeam("none");
        none.setPrefix("§7❌ §8▪▪▪ ");
        none.setColor(ChatColor.GRAY);

        Team gold = scoreboard.registerNewTeam("gold");
        gold.setPrefix("§6■ §8▪▪▪ ");
        gold.setColor(ChatColor.GOLD);

        Team yellow = scoreboard.registerNewTeam("yellow");
        yellow.setPrefix("§e■ §8▪▪▪ ");
        yellow.setColor(ChatColor.YELLOW);

        Team red = scoreboard.registerNewTeam("red");
        red.setPrefix("§c■ §8▪▪▪ ");
        red.setColor(ChatColor.RED);

        Team pink = scoreboard.registerNewTeam("pink");
        pink.setPrefix("§d■ §8▪▪▪ ");
        pink.setColor(ChatColor.LIGHT_PURPLE);

        Team green = scoreboard.registerNewTeam("green");
        green.setPrefix("§a■ §8▪▪▪ ");
        green.setColor(ChatColor.GREEN);

        Team aqua = scoreboard.registerNewTeam("aqua");
        aqua.setPrefix("§b■ §8▪▪▪ ");
        aqua.setColor(ChatColor.AQUA);

        Team blue = scoreboard.registerNewTeam("blue");
        blue.setPrefix("§9■ §8▪▪▪ ");
        blue.setColor(ChatColor.BLUE);

        Team white = scoreboard.registerNewTeam("white");
        white.setPrefix("§f■ §8▪▪▪ ");
        white.setColor(ChatColor.WHITE);

        none.addPlayer(player);
        player.setScoreboard(scoreboard);
    }

}
