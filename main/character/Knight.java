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
    private int noroundsextradamage = 0;
    private int overtimedamage = 0;
    private boolean canmove = true;
    private int bonusattack1 = Constants.EXECUTEDAMAGEADDEDPERLEVEL;
    private int bonusattack2 = Constants.SLAMDAMAGE;
    private int attack1 = Constants.EXECUTEDAMAGE + level * bonusattack1;
    private int attack2 = Constants.SLAMDAMAGE + level * bonusattack2;


    public char getName() {
        return name;
    }

    public boolean isCanmove() {
        return canmove;
    }

    @Override
    public void decNotMove() {
        noroundsextradamage -= 1;
        if (noroundsextradamage == 0) {
            canmove = true;
        }
    }

    public void setCanmove(final boolean canmove) {
        this.canmove = canmove;
    }

    public void setPoz(final int x, final int y) {
        pozx = x;
        pozy = y;
    }

    @Override
    public void addToPoz(final int x, final int y) {
        pozx += x;
        pozy += y;
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

    /*Knight este atacat de character*/
    @Override
    public void isAttacked(final Character character, final char c) {
        actualLife -= (character.attack(this, c));
    }

    @Override
    public void setIsNotAlive() {
        isAlive = 0;
    }

    public float getBonus(final char c) {
        switch (c) {
            case 'L':
                return Constants.KNIGHTLANDB;
            case 'V':
                return Constants.KNIGHTVOLCANICB;
            case 'W':
                return Constants.KNIGHTWOODSB;
            case 'D':
                return Constants.KNIGHTDESERTB;
            default:
                return 0;
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
    public boolean canwalk() {
        return canmove;
    }

    /*Knight ataca knight*/
    @Override
    public int attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        if (knight.getActualLife() <= (Constants.LIFEPERCENT + level * 0.01F)
                * knight.getMaxLife()) {
            return knight.getActualLife();
        }
        attack1 = Math.round(Math.round(attack1 * bonus) * Constants.EXECUTEMODK);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.SLAMMODK);
        knight.setNoroundsextradamage(1);
        knight.setCanmove(false);
        return (attack1 + attack2);
    }

    /*Knight ataca rogue*/
    @Override
    public int attack(final Rogue rogue, final char c) {
        float bonus = getBonus(c);
        if (rogue.getActualLife() <= (Constants.LIFEPERCENT + level * 0.01F)
                * rogue.getMaxLife()) {
            return rogue.getActualLife();
        }
        attack1 = Math.round(Math.round(attack1 * bonus) * Constants.EXECUTEMODR);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.SLAMMODR);
        rogue.setNoroundsextradamage(1);
        rogue.setCanmove(false);
        return (attack1 + attack2);
    }

    /*Knight ataca pyromancer*/
    @Override
    public int attack(final Pyromancer pyromancer, final char c) {
        float bonus = getBonus(c);
        if (pyromancer.getActualLife() <= (Constants.LIFEPERCENT + level * 0.01F)
                * pyromancer.getMaxLife()) {
            return pyromancer.getActualLife();
        }
        attack1 = Math.round(Math.round(attack1 * bonus) * Constants.EXECUTEMODP);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.SLAMMODP);
        pyromancer.setNoroundsextradamage(1);
        pyromancer.setCanmove(false);
        return (attack1 + attack2);
    }

    /*Knight ataca wizard*/
    @Override
    public int attack(final Wizard wizard, final char c) {
        float bonus = getBonus(c);
        if (wizard.getActualLife() <= (Constants.LIFEPERCENT + level * 0.01F)
                * wizard.getMaxLife()) {
            return wizard.getActualLife();
        }
        attack1 = Math.round(Math.round(attack1 * bonus) * Constants.EXECUTEMODW);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.SLAMMODW);
        wizard.setNoroundsextradamage(1);
        wizard.setCanmove(false);
        return (attack1 + attack2);
    }

    @Override
    public void addExp(final int exp) {
        xp += exp;
    }

    @Override
    public void addDamageovertime() {
        if (noroundsextradamage != 0) {
            actualLife -= overtimedamage;
            noroundsextradamage -= 1;
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void updateLevel() {
        if (isAlive == 1) {
            int nlevel = (xp - Constants.TFZ) / Constants.FIFTY + 1;
            if (nlevel != level) {
                level = nlevel;
                maxLife = Constants.KNIGHTLIFE + level * Constants.POWERPERLEVELKNIGHT;
                actualLife = maxLife;
            }
        }
    }
}
