package main.character;

import main.Constants;

public final class Pyromancer extends Character {
    private char name = 'P';
    private int pozx;
    private int pozy;
    private int xp = 0;
    private int maxLife = Constants.PYROMANCERLIFE;
    private int actualLife = maxLife;
    private int level = 0;
    private int isAlive = 1;
    private int noroundsextradamage = 0;
    private int overtimedamage = 0;

    public char getName() {
        return name;
    }

    public void setPoz(final int x, final int y) {
        pozx = x;
        pozy = y;
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

    public void isAttacked(final Character character, final char c) {
        actualLife -= (character.attack(this, c));
    }

    @Override
    public void setIsNotAlive() {
        isAlive = 0;
    }

    @Override
    public int getLife() {
        return actualLife;
    }

    public int getActualLife() {
        return actualLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public float getBonus(final char c) {
        switch (c) {
            case 'L':
                return Constants.PYROMANCERLANDB;
            case 'V':
                return Constants.PYROMANCERVOLCANICB;
            case 'W':
                return Constants.PYROMANCERWOODSB;
            case 'D':
                return Constants.PYROMANCERDESERTB;
            default:
                return 0;
        }
    }

    @Override
    public int getOvertimeDamage() {
        return overtimedamage;
    }

    @Override
    public int attack(final Rogue rogue, final char c) {
        float bonus = getBonus(c);
        float attack1bonus = 1F;
        rogue.setNoroundsextradamage(Constants.TWO);
        int attack1 = Math.round(Math.round(Constants.FIREBLAST * attack1bonus * bonus)
                * Constants.FIREBLASTMODR);
        int attack2 = Math.round(Math.round(Constants.IGNITE * bonus) * Constants.IGNITEMODR);
        rogue.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODR));
        return (attack1 + attack2);
    }

    @Override
    public int attack(final Pyromancer pyromancer, final char c) {
        float bonus = getBonus(c);
        pyromancer.setNoroundsextradamage(Constants.TWO);
        int attack1 = Math.round(Math.round(Constants.FIREBLAST * bonus)
                * Constants.FIREBLASTMODP);
        int attack2 = Math.round(Math.round(Constants.IGNITE * bonus) * Constants.IGNITEMODP);
        pyromancer.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODP));
        return (attack1 + attack2);
    }

    @Override
    public int attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        knight.setNoroundsextradamage(Constants.TWO);
        int attack1 = Math.round(Math.round(Constants.FIREBLAST * bonus) * Constants.FIREBLASTMODK);
        int attack2 = Math.round(Math.round(Constants.IGNITE * bonus) * Constants.IGNITEMODK);
        knight.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODK));
        return (attack1 + attack2);
    }

    @Override
    public int attack(final Wizard wizard, final char c) {
        float bonus = getBonus(c);
        float attack1bonus = 1F;
        wizard.setNoroundsextradamage(Constants.TWO);
        int attack1 = Math.round(Math.round(Constants.FIREBLAST * attack1bonus * bonus)
                * Constants.FIREBLASTMODW);
        int attack2 = Math.round(Math.round(Constants.IGNITE * bonus) * Constants.IGNITEMODW);
        wizard.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODW));
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

    public String toString() {
        if (isAlive == 1) {
            String s = new String();
            s += (name + " " + level + " " + xp + " " + actualLife + " " + pozx + " " + pozy);
            return s;
        }
        return name + " dead";
    }

    @Override
    public void addDamageovertime() {
        if (noroundsextradamage != 0) {
            actualLife -= overtimedamage;
            noroundsextradamage -= 1;
        }
    }
}
