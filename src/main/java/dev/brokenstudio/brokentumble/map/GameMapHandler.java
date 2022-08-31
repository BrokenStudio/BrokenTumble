package dev.brokenstudio.brokentumble.map;

import dev.brokenstudio.brokentumble.Tumble;

import java.util.*;

public class GameMapHandler {

    private final ArrayList<Map> usedMaps;

    {
        usedMaps = new ArrayList<>();
    }

    private HashMap<Map, Integer> votes;

    public void _initalize(){
        Random r = new Random();
        List<Map> maps = Tumble.tumble().getMapHandler().getMaps();
        if(maps.size() == 3){
            usedMaps.set(0, maps.get(0));
            usedMaps.set(1, maps.get(1));
            usedMaps.set(2, maps.get(2));
        }else {
            usedMaps.add(getRandomMap(maps,r));
            usedMaps.add(getRandomMap(maps,r));
            usedMaps.add(getRandomMap(maps,r));
        }

        usedMaps.forEach(cr -> votes.put(cr, 0));
    }

    public ArrayList<Map> getUsedMaps() {
        return usedMaps;
    }

    public void addVote(int slot){
        Map map = usedMaps.get(slot);
        votes.put(map, votes.get(map)+1);
    }

    public int getVote(int slot){
        return votes.get(usedMaps.get(slot));
    }

    public Map getRandomMap(List<Map> maps, Random r){
        Map map = maps.get(r.nextInt(maps.size()));
        if(usedMaps.contains(map)){
            return getRandomMap(maps, r);
        }else return map;
    }
}
