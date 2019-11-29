package main.map;

import java.util.ArrayList;

public final class LandOnMap {
    private ArrayList<Character> heroes = new ArrayList<>();
    private Lands land = null;
    public void setLand(final Lands land) {
        this.land = land;
    }

    public Lands getLand() {
        return land;
    }
}
