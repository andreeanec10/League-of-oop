package main.character;

import main.Constants;

public final class Wizard extends Character {
    private char name = 'W';
    private int pozx;
    private int pozy;
    private int xp = 0;
    private int level = 0;
    private int maxLife = Constants.WIZARDLIFE;
    private int actualLife = maxLife;
    private int noroundsextradamage = 0;
    private int overtimedamage = 0;
    private int isAlive = 1;
    private int norounds = 1;
    private boolean canmove = true;
    private float bonusattack1 = Constants.DRAINDAMAGEADDEDPERLEVEL;
    private float bonussattack2 = Constants.DEFLECTDAMAGEADDEDPERLEVEL;


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

    public int getPozx() {
        return pozx;
    }

    public int getPozy() {
        return pozy;
    }

    @Override
    public void addToPoz(final int x, final int y) {
        pozx += x;
        pozy += y;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setOvertimedamage(final int overtimedamage) {
        this.overtimedamage = overtimedamage;
    }

    public void setNoroundsextradamage(final int noroundsextradamage) {
        this.noroundsextradamage = noroundsextradamage;
    }

    public int getActualLife() {
        return actualLife;
    }

    @Override
    public String getInfo() {
        return name + " " + pozx + " " + pozy;
    }

    /*Wizard este atacat de charater*/
    public void isAttacked(final Character character, final char c) {
        actualLife -= character.attack(this, c);
    }

    @Override
    public void setIsNotAlive() {
        isAlive = 0;
    }

    @Override
    public int getLife() {
        return actualLife;
    }

    @Override
    public boolean canwalk() {
        return canmove;
    }

    /*Wizard ataca knight*/
    @Override
    public int attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        float bonusgk = knight.getBonus(c);
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(bonus * Constants.DRAINMODK * Constants.DRAIN
                * Math.min(Constants.WIZARDADD * knight.getMaxLife(),
                knight.getActualLife())));
        int rawattack = Math.round(Constants.EXECUTEDAMAGE * bonusgk)
                + Math.round(Constants.SLAMDAMAGE * bonusgk);
        attack2 = Math.round(Constants.DEFLECT * bonus * rawattack * Constants.DEFLECTMODK);
        attack1 += attack1 * bonusattack1 * level;
        attack2 += attack2 * bonussattack2 * level;
        return (attack1 + attack2);
    }

    /*Wizard ataca rogue*/
    @Override
    public int attack(final Rogue rogue, final char c) {
        float bonus = getBonus(c);
        float bonusgk = rogue.getBonus(c);
        float bonus2 = 1F;
        if ((norounds == 1 && norounds % Constants.THREE == 1) && c == 'W') {
            bonus2 = Constants.ROGUEADD;
        }
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(bonus * Constants.DRAINMODR * Constants.DRAIN
                * Math.min(Constants.WIZARDADD * rogue.getMaxLife(),
                rogue.getActualLife())));
        int rawattack = Math.round(Constants.BACKSTAB * bonus2 * bonusgk)
                + Math.round(Constants.PARALYSIS * bonusgk);
        attack2 = Math.round(Constants.DEFLECT * bonus * rawattack * Constants.DEFLECTMODR);
        attack1 += attack1 * bonusattack1 * level;
        attack2 += attack2 * bonussattack2 * level;
        return (attack1 + attack2);
    }

    /*Wizard ataca pyromancer*/
    @Override
    public int attack(final Pyromancer pyromancer, final char c) {
        float bonus = getBonus(c);
        float bonusgk = pyromancer.getBonus(c);
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(bonus * Constants.DRAINMODP * Constants.DRAIN
                * Math.min(Constants.WIZARDADD * pyromancer.getMaxLife(),
                pyromancer.getActualLife())));
        int rawattack = Math.round(Constants.FIREBLAST * bonusgk)
                + Math.round(Constants.IGNITE * bonusgk);
        attack2 = Math.round(Constants.DEFLECT * bonus * rawattack * Constants.DEFLECTMODP);
        attack1 += attack1 * bonusattack1 * level;
        attack2 += attack2 * bonussattack2 * level;
        return (attack1 + attack2);
    }

    /*Wizard ataca wizard*/
    @Override
    public int attack(final Wizard wizard, final char c) {
        float bonus = getBonus(c);
        int attack1 = 0;
        int attack2 = 0;
        attack1 = Math.round(Math.round(bonus * Constants.DRAINMODW * Constants.DRAIN
                * Math.min(Constants.WIZARDADD * wizard.getMaxLife(),
                wizard.getActualLife())));
        attack1 += attack1 * bonusattack1 * level;
        attack2 += attack2 * bonussattack2 * level;
        return attack1;
    }

    public float getBonus(final char c) {
        switch (c) {
            case 'L':
                return Constants.WIZARDLANDB;
            case 'V':
                return Constants.WIZARDVOLCANICB;
            case 'W':
                return Constants.WIZARDWOODSB;
            case 'D':
                return Constants.WIZARDDESERB;
            default:
                return 0;
        }
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

    public String toString() {
        if (isAlive == 1) {
            String s = new String();
            s += (name + " " + level + " " + xp + " " + actualLife + " " + pozx + " " + pozy);
            return s;
        }
        return name + " dead";
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
                maxLife = Constants.WIZARDLIFE + level * Constants.POWERPERLEVELWIZARD;
                actualLife = maxLife;
            }
        }
    }
}
