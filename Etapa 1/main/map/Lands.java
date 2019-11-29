package main.map;

import main.character.Knight;
import main.character.Pyromancer;
import main.character.Rogue;
import main.character.Wizard;

public abstract class Lands {

    public abstract char getName();
    public abstract void addCharactersIn();
    public abstract void reset();
    public abstract int getNoplayers();

}
