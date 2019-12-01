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
        /*pentru fiecare runda se executa:*/
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < gameHeroes.getHeroes().size(); j++) {
                int x = 0;
                int y = 0;
                /*se citeste miscarea care trebuie facute in continuare de
                 * fiecare jucator in parte*/
                switch (game.getMoves().get(i).charAt(j)) {
                    case '_':
                        break;
                    case 'U':
                        x -= 1;
                        break;
                    case 'D':
                        x = 1;
                        break;
                    case 'L':
                        y -= 1;
                        break;
                    case 'R':
                        y = 1;
                        break;
                    default:
                        break;
                }
                /*se adauga la pozitia actuala*/
                if (gameHeroes.getHeroes().get(j).canwalk()) {
                    gameHeroes.getHeroes().get(j).addToPoz(x, y);
                } else {
                    gameHeroes.getHeroes().get(j).addToPoz(0, 0);
                    gameHeroes.getHeroes().get(j).decNotMove();
                }
            }
            /*daca eroul este in viata, i se actualizeaza pozitia pe harta*/
            for (int j = 0; j < gameHeroes.getHeroes().size(); j++) {
                Character c = gameHeroes.getHeroes().get(j);
                if (c.getLife() > 0) {
                    gameMap.getLandInfo(c.getPozx(), c.getPozy()).addHeroes(j);
                }
            }
            /*se verifica fiecare camp al hartii*/
            for (int j = 0; j < gameMap.getMap().length; j++) {
                for (int k = 0; k < gameMap.getMapWeight(); k++) {
                    /*daca se gasesc 2 jucatori pe acelasi teren se lupta*/
                    if (gameMap.getLandInfo(j, k).getNoheroesin() == Constants.TWO) {
                        Character ch1 = gameHeroes.getHeroes()
                                .get(gameMap.getLandInfo(j, k).getHeroI(0));
                        Character ch2 = gameHeroes.getHeroes()
                                .get(gameMap.getLandInfo(j, k).getHeroI(1));
                        /*se aplica damageovertime*/
                        ch1.addDamageovertime();
                        ch2.addDamageovertime();
                        if (ch1.getLife() <= 0) {
                            ch1.setIsNotAlive();
                        }
                        if (ch2.getLife() <= 0) {
                            ch2.setIsNotAlive();
                        }
                        /*daca supravietuiesc se lupta*/
                        if (ch1.getLife() > 0 && ch2.getLife() > 0) {
                            ch1.isAttacked(ch2, gameMap.getLandInfo(0, 0).getLand().getName());
                            ch2.isAttacked(ch1, gameMap.getLandInfo(0, 0).getLand().getName());
                        } else {
                            break;
                        }
                        if (ch1.getLife() <= 0) {
                            ch1.setIsNotAlive();
                            ch2.addExp(Math.max(0, Constants.TWOH
                                    - (ch2.getLevel() - ch1.getLevel()) * Constants.FOURTY));
                        }
                        if (ch2.getLife() <= 0) {
                            ch2.setIsNotAlive();
                            ch1.addExp(Math.max(0, Constants.TWOH
                                    - (ch1.getLevel() - ch2.getLevel()) * Constants.FOURTY));
                        }
                        ch1.updateLevel();
                        ch2.updateLevel();
                    }
                }
            }
            /*se scot jucatorii de pe harta*/
            for (int j = 0; j < gameMap.getMap().length; j++) {
                for (int k = 0; k < gameMap.getMapWeight(); k++) {
                    while (gameMap.getLandInfo(j, k).getNoheroesin() > 0) {
                        gameMap.getLandInfo(j, k).resmoveHero(0);
                    }
                }
            }
        }
        /*se afiseaza in fisier*/
        gameInputLoader.write(gameHeroes);
    }
}

