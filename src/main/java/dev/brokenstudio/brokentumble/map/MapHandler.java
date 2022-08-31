package dev.brokenstudio.brokentumble.map;

import dev.brokenstudio.brokenapi.BrokenAPI;
import dev.brokenstudio.brokenapi.database.mariadb.SQLPipe;
import dev.brokenstudio.brokenapi.serializer.Serializer;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapHandler {

    private final HashMap<String, Map> maps;

    {
        maps = new HashMap<>();
        loadMaps();
    }

    private void loadMaps(){
        BrokenAPI.api().getDatabaseHandler().getMariaDBHandler().executeQuery(
                "CREATE TABLE IF NOT EXISTS `tumble_maps` (`data` LONGTEXT);");
        Connection con = null;
        ResultSet rs = null;
        try {
            con = BrokenAPI.api().getDatabaseHandler().getMariaDBHandler().getSQLConnection().getDriverConnection();
            rs = con.prepareStatement("SELECT * FROM `tumble_maps`;").executeQuery();
            while(rs.next()){
                Map map = Serializer.deserialize(rs.getString("data"), Map.class);
                maps.put(map.getName(), map);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                rs.close();
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public void saveMaps(){
        Bukkit.broadcastMessage("Saving maps");
        BrokenAPI.api().getDatabaseHandler().getMariaDBHandler().executeQuery("DELETE FROM `tumble_maps`;");
        SQLPipe pipe = new SQLPipe();
        maps.values().forEach(cr -> {
            Bukkit.broadcastMessage(cr.getName());
            pipe.addQuery("INSERT INTO `tumble_maps` (`data`) VALUES ('"+Serializer.serialize(cr)+"');");
        });
        BrokenAPI.api().getDatabaseHandler().getMariaDBHandler().executePipe(pipe);
    }

    public boolean mapExists(String name){
        return maps.containsKey(name);
    }

    public void addMap(Map map){
        maps.put(map.getName(), map);
    }

    public void removeMap(String name){
        maps.remove(name);
    }

    public List<Map> getMaps(){
        return new ArrayList<>(maps.values());
    }

}
