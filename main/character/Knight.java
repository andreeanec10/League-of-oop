package main.character;

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
    private int noroundsextradamage =  0;
    private int overtimedamage = 0;
    private int contor = 0;

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

    public void setNoroundsextradamage(final int noroundsextradamage) {
        this.noroundsextradamage = noroundsextradamage;
    }

    public void setOvertimedamage(final int overtimedamage) {
        this.overtimedamage = overtimedamage;
    }

    @Override
    public String getInfo() {
        return name + " " + pozx + " " + pozy;
    }

    @Override
    public void isAttacked(final Character character, final char c) {
        if (contor == 0 || contor > noroundsextradamage) {
            actualLife -= (character.attack(this, c));
            contor = 0;
        } else {
            actualLife -= (character.attack(this, c) + this.overtimedamage);
        }
        contor += 1;
    }

    @Override
    public void setIsNotAlive() {
        isAlive = 0;
    }

    @Override
    public int attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        if (knight.getActualLife() <= Constants.LIFEPERCENT * knight.getMaxLife()) {
            return knight.getActualLife();
        }
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(Constants.EXECUTEDAMAGE * bonus) * Constants.EXECUTEMODK);
        attack2 = Math.round(Math.round(Constants.SLAMDAMAGE  * bonus) * Constants.SLAMMODK);
        return (attack1 + attack2);
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
        if (isAlive == 1) {
            String s = new String();
            s += (name + " " + level + " " + xp + " " + actualLife + " " + pozx + " " + pozy);
            return s;
        }
        return name + " dead";
    }

    @Override
    public int getLife() {
        return actualLife;
    }

    @Override
    public int attack(final Rogue rogue, final char c) {
        float bonus = getBonus(c);
        if (rogue.getActualLife() <= Constants.LIFEPERCENT * rogue.getMaxLife()) {
            return rogue.getActualLife();
        }
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(Constants.EXECUTEDAMAGE * bonus) * Constants.EXECUTEMODR);
        attack2 = Math.round(Math.round(Constants.SLAMDAMAGE  * bonus) * Constants.SLAMMODR);
        return (attack1 + attack2);
    }

    @Override
    public int attack(Pyromancer pyromancer, char c) {
        float bonus = getBonus(c);
        if (pyromancer.getActualLife() <= Constants.LIFEPERCENT * pyromancer.getMaxLife()) {
            return pyromancer.getActualLife();
        }
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(Constants.EXECUTEDAMAGE * bonus) * Constants.EXECUTEMODP);
        attack2 = Math.round(Math.round(Constants.SLAMDAMAGE  * bonus) * Constants.SLAMMODP);
        return (attack1 + attack2);
    }

    @Override
    public void addExp(final int exp) {
        xp += exp;
    }

    @Override
    public int getExp() {
        return xp;
    }

    @Override
    public void addDamageovertime() {
        if ( noroundsextradamage != 0) {
            actualLife -= overtimedamage;
            noroundsextradamage -= 1;
        }
    }
}
