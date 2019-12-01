package main.character;

import java.util.ArrayList;

public final class Heroes {
    private ArrayList<Character> heroes = new ArrayList<>();

    public Heroes(final int number, final ArrayList<String> names,
                  final ArrayList<Integer> positions) {
        for (int i = 0; i < number; i++) {
            int j = i;
            j++;
            Character ch = CharacterFactory.getInstance().createCharacter(names.get(i));
            ch.setPoz(positions.get(i + i), positions.get(i + j));
            heroes.add(ch);
        }
    }

    public ArrayList<Character> getHeroes() {
        return heroes;
    }

    public String toString() {
        String s = new String();
        for (int i = 0; i < heroes.size(); i++) {
            s += (heroes.get(i).getInfo() + " ");
        }
        return s;
    }

}
