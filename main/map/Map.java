package main.map;

import java.util.ArrayList;

public final class Map {
    private ArrayList<LandOnMap>[] map;

    public Map(final int l, final int w, final String landsName) {
        map = new ArrayList[l];
        int contor = 0;
        for (int i = 0; i < l; i++) {
            map[i] = new ArrayList<>(w);
            for (int j = 0; j < w; j++) {
                LandOnMap lan = new LandOnMap();
                Lands land = LandFactory.getInstance()
                        .createLand(landsName.charAt(contor));
                lan.setLand(land);
                map[i].add(lan);
                contor += 1;
            }
        }
    }

    public int getMapWeight() {
        return map[0].size();
    }

    public ArrayList<LandOnMap>[] getMap() {
        return map;
    }

    public LandOnMap getLandInfo(final int x, final int y) {
        return map[x].get(y);
    }

    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].size(); j++) {
                s += (map[i].get(j).getLand().getName() + " ");
            }
        }
        return s;
    }
}
