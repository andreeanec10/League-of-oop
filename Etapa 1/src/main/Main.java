package main;
import main.map.Map;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
        //just to pass checker
    }
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput game = gameInputLoader.load();
        Map game_map = game.getMap();


    }
}
