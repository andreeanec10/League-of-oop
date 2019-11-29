package main.map;

import main.Constants;
import main.character.Knight;
import main.character.Pyromancer;
import main.character.Rogue;
import main.character.Wizard;

public final class Land extends Lands {
    private char name = 'L';
    private int noplayers = 0;

    public char getName() {
        return name;
    }

    public void addCharactersIn() {
        noplayers += 1;
    }

    public void reset() {
        noplayers = 0;
    }

    public int getNoplayers() {
        return noplayers;
    }

}
