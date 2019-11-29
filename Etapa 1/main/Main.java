package main;

import main.character.Character;
import main.character.Heroes;
import main.character.Knight;
import main.map.Lands;
import main.map.Map;

final class Main {
    private Main() {
        //just to pass checker
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput game = gameInputLoader.load();
        Map gameMap = game.getMap();
        Heroes gameHeroes = game.getHero();
        int nr = game.getRounds();
        Character ch1 = gameHeroes.getOneHero(0);
        Character ch2 = gameHeroes.getOneHero(1);
        for (int i = 0; i < nr; i++) {
            ch1.isAttacked(ch2, gameMap.getLandInfo(0,0 ).getLand().getName());
            ch2.isAttacked(ch1, gameMap.getLandInfo(0,0 ).getLand().getName());
        }
        System.out.println(ch1);
        System.out.println(ch2);
    }
}
