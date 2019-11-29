package main.character;

//import java.lang.Math;
import main.Constants;

public final class Knight extends Character {
    private char name = 'K';
    private int pozx;
    private int pozy;
    private int maxLife = Constants.KNIGHTLIFE;
    private int actualLife = maxLife;
    private int level = 0;
    private int xp = 0;
    private int isAlive = 1;


    public char getName() {
        return name;
    }

    public void setPoz(final int x, final int y) {
        pozx = x;
        pozy = y;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getActualLife() {
        return actualLife;
    }

    public int getPozx() {
        return pozx;
    }

    public int getPozy() {
        return pozy;
    }

    @Override
    public String getInfo() {
        return name + " " + pozx + " " + pozy;
    }

    @Override
    public void isAttacked(final Character character, final char c) {
        actualLife -= character.Attack(this, c);
    }

    @Override
    public int Attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        if (knight.getActualLife() <= Constants.LIFEPERCENT * knight.getMaxLife()) {
            return knight.getActualLife();
        }
        int attack = Math.round(Constants.EXECUTEDAMAGE * bonus);
        attack += Math.round(Math.round(Constants.SLAMDAMAGE  * bonus) * Constants.SLAMMODK);
        return attack;
    }

    public float getBonus(final char c) {
        switch (c) {
            case 'L' : return Constants.KNIGHTLANDB;
            case 'V' : return Constants.KNIGHTVOLCANICB;
            case 'W' : return Constants.KNIGHTWOODSB;
            case 'D' : return Constants.KNIGHTDESERTB;
            default: return 0;
        }
    }

    public String toString() {
        String s = new String();
        s += (name + " " + level + " " + xp + " " + actualLife + " " + pozx + " " + pozy);
        return s;
    }
}
