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
        return (attack1 + attack2);
    }

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
        return (attack1 + attack2);
    }

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
        return (attack1 + attack2);
    }

    @Override
    public int attack(final Wizard wizard, final char c) {
        float bonus = getBonus(c);
        int attack1 = 0;
        attack1 = Math.round(Math.round(bonus * Constants.DRAINMODW * Constants.DRAIN
                * Math.min(Constants.WIZARDADD * wizard.getMaxLife(),
                wizard.getActualLife())));
        System.out.println(attack1);
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
    public int getExp() {
        return xp;
    }

    @Override
    public void addDamageovertime() {
        if (noroundsextradamage != 0) {
            actualLife -= overtimedamage;
            noroundsextradamage -= 1;
        }
    }

    @Override
    public int getOvertimeDamage() {
        return 0;
    }

    public String toString() {
        if (isAlive == 1) {
            String s = new String();
            s += (name + " " + level + " " + xp + " " + actualLife + " " + pozx + " " + pozy);
            return s;
        }
        return name + " dead";
    }
}
