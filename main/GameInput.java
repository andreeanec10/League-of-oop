package main;

import main.character.Heroes;
import main.map.Map;

import java.util.ArrayList;

public class GameInput {

    private int nrHeroes;
    private Map map;
    private Heroes hHero;
    private ArrayList<String> moves;
    private int rounds;

    public GameInput() {
        nrHeroes = 0;
        map = null;
        hHero = null;
        moves = new ArrayList<>();
        rounds = 0;
    }

    public GameInput(final int length, final int width, final String s,
                     final ArrayList<String> h,
                     final ArrayList<Integer> poz, final int rounds,
                     final ArrayList<String> string) {
        nrHeroes = h.size();
        map = new Map(length, width, s);
        hHero = new Heroes(nrHeroes, h, poz);
        this.rounds = rounds;
        moves = new ArrayList<String>(this.rounds);
        for (int i = 0; i < this.rounds; i++) {
            moves.add(string.get(i));
        }
    }

    public final Map getMap() {
        return map;
    }

    public final Heroes getHero() {
        return hHero;
    }

    public final ArrayList<String> getMoves() {
        return moves;
    }

    public final int getRounds() {
        return rounds;
    }

}
