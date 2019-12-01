package main.map;

import java.util.ArrayList;


public final class LandOnMap {
    private ArrayList<Integer> heroes = new ArrayList<>();
    private Lands land = null;
    private int noheroesin = 0;

    public void setLand(final Lands land) {
        this.land = land;
    }

    public Lands getLand() {
        return land;
    }

    public int getNoheroesin() {
        return noheroesin;
    }

    public int getHeroI(final int i) {
        return heroes.get(i);
    }

    public void addHeroes(final int c) {
        heroes.add(c);
        this.noheroesin += 1;
    }

    public void resmoveHero(final int i) {
        noheroesin -= 1;
        heroes.remove(i);
    }
}
