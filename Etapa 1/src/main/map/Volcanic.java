package main.map;

import main.character.Pyromancer;

public class Volcanic extends Lands {
   // public abstract float givesboost(Pyromancer pyromancer);
    private char name = 'V';

    public char getName() {
        return name;
    }

    @Override
    public char isGettingName(Lands lands) {
        return lands.getLandsName(this);
    }

    @Override
    public char getLandsName(Lands volcanic) {
        return volcanic.getName();
    }
}
