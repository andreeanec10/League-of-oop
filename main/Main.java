package main;

import main.character.Character;
import main.character.Heroes;
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
            ch1.isAttacked(ch2, gameMap.getLandInfo(0, 0).getLand().getName());
            ch2.isAttacked(ch1, gameMap.getLandInfo(0, 0).getLand().getName());
            if (ch1.getLife() <= 0) {
                ch1.setIsNotAlive();
                ch2.addExp(Math.max(0, Constants.TWOH - (ch2.getExp() - ch1.getExp())));
            }
            if (ch2.getLife() <= 0) {
                ch2.setIsNotAlive();
                ch1.addExp(Math.max(0, Constants.TWOH - (ch1.getExp() - ch2.getExp())));
            }
        }
        System.out.println(ch1);
        System.out.println(ch2);
    }
}
