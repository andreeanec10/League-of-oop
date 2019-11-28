package main.map;

import java.util.ArrayList;
import main.map.LandFactory;
import java.util.Arrays;

public class Map {
    private ArrayList<Lands>[] map;

    public Map(int l, int w, String lands_name) {
        map = new ArrayList[l];
        int contor = 0;
        for (int i = 0; i < l; i++) {
            map[i] = new ArrayList<Lands>(w);
            for (int j = 0; j < w; j++) {
                Lands land = LandFactory.getInstance()
                        .createLand(lands_name.charAt(contor));
                map[i].add(land);
                contor += 1;
            }
        }
    }

    public ArrayList<Lands>[] getMap() {
        return map;
    }

    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].size(); j++) {
                s += (map[i].get(j).getName()+ " ");
            }
        }
        return s;
    }
}
