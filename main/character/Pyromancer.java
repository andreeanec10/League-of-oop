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
    private boolean canmove = true;
    private int bonusattack1 = Constants.FIREBLASTDAMAGEADDEDPERLEVEL;
    private int bonusattack2 = Constants.IGNITEDAMAGEADDESPERLEVEL;
    private int attack1 = Constants.FIREBLAST + level * bonusattack1;
    private int attack2 = Constants.IGNITE + level * bonusattack2;

    public char getName() {
        return name;
    }

    public boolean isCanmove() {
        return canmove;
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

    /*Pyromancer este atacat de character*/
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
    public boolean canwalk() {
        return canmove;
    }

    /*Pyromancer ataca rogue*/
    @Override
    public int attack(final Rogue rogue, final char c) {
        float bonus = getBonus(c);
        float attack1bonus = 1F;
        rogue.setNoroundsextradamage(Constants.TWO);
        attack1 = Math.round(Math.round(attack1 * attack1bonus * bonus)
                * Constants.FIREBLASTMODR);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.IGNITEMODR);
        rogue.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODR)
        + level * Constants.THIRTY);
        return (attack1 + attack2);
    }

    /*Pyromancer ataca alt pyromancer*/
    @Override
    public int attack(final Pyromancer pyromancer, final char c) {
        float bonus = getBonus(c);
        pyromancer.setNoroundsextradamage(Constants.TWO);
        attack1 = Math.round(Math.round(attack1 * bonus)
                * Constants.FIREBLASTMODP);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.IGNITEMODP);
        pyromancer.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODP)
        + level * Constants.THIRTY);
        return (attack1 + attack2);
    }

    /*Pyromancer ataca knight*/
    @Override
    public int attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        knight.setNoroundsextradamage(Constants.TWO);
        attack1 = Math.round(Math.round(attack1 * bonus) * Constants.FIREBLASTMODK);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.IGNITEMODK);
        knight.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODK)
        + Constants.THIRTY);
        return (attack1 + attack2);
    }

    /*Pyromancer ataca wizard*/
    @Override
    public int attack(final Wizard wizard, final char c) {
        float bonus = getBonus(c);
        wizard.setNoroundsextradamage(Constants.TWO);
        attack1 = Math.round(Math.round(attack1 * bonus)
                * Constants.FIREBLASTMODW);
        attack2 = Math.round(Math.round(attack2 * bonus) * Constants.IGNITEMODW);
        wizard.setOvertimedamage(Math.round(Constants.FIFTY * Constants.IGNITEMODW)
        + level + Constants.THIRTY);
        return (attack1 + attack2);
    }

    @Override
    public void addExp(final int exp) {
        xp += exp;
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

    @Override
    public void decNotMove() {
        noroundsextradamage -= 1;
        if (noroundsextradamage == 0) {
            canmove = true;
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
                maxLife = Constants.PYROMANCERLIFE + level * Constants.POWERPERLEVELPYROMANCER;
                actualLife = maxLife;
            }
        }
    }
}
