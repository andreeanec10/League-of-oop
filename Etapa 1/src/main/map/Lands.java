package main.map;

import main.character.Knight;
import main.character.Pyromancer;
import main.character.Rogue;
import main.character.Wizard;

public abstract class Lands {
    //public abstract float givesboost(Rogue rogue);
    //public abstract float givesboost(Knight knight);
   // public abstract float givesboost(Pyromancer pyromancer);
    //public abstract float givesboost(Wizard wizard);
    public abstract char isGettingName(Lands lands);
    public abstract char getLandsName(Lands lands);
    public abstract char getName();
//    public abstract char getLandsName(Land land);
//    public abstract char getLandsName(Woods woods);
//    public abstract char getLandsName(Desert desert);
}
