package main.character;

import main.Constants;

public final class Rogue extends Character {
    private char name = 'R';
    private int pozx;
    private int pozy;
    private int maxLife = Constants.ROGUELIFE;
    private int actualLife = maxLife;
    private int level = 0;
    private int xp = 0;
    private int noroundsextradamage = 0;
    private int overtimedamage = 0;
    private int contor = 0;
    private int isAlive = 1;
    private int noAttacks = 1;

    public char getName() {
        return name;
    }

    public int getActualLife() {
        return actualLife;
    }

    public int getMaxLife() {
        return maxLife;
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
    public String getInfo() {
        return name + " " + pozx + " " + pozy;
    }
    public void isAttacked(final Character character, final char c) {
        if (contor == 0 || contor > noroundsextradamage) {
            actualLife -= (character.attack(this, c));
            contor = 0;
        } else {
            actualLife -= (character.attack(this, c) + this.overtimedamage);
        }
        contor += 1;
    }

    public float getBonus(final char c) {
        switch (c) {
            case 'L' : return Constants.ROGUELANDB;
            case 'V' : return Constants.ROGUEVOLCANICB;
            case 'W' : return Constants.ROGUEWOODSB;
            case 'D' : return Constants.ROGUEDESERTB;
            default: return 0;
        }
    }

    public int attack(final Knight knight, final char c) {
        float bonus = getBonus(c);
        float attack1bonus = 1F;
        if ((noAttacks == 1 || noAttacks % Constants.THREE == 1) && c == 'W') {
            attack1bonus = 1.5F;
        }
        noAttacks += 1;
        if (c == 'W') {
            knight.setNoroundsextradamage(Constants.SIX);
        } else {
            knight.setNoroundsextradamage(Constants.THREE);
        }
        int attack1 = Math.round(Math.round(Constants.BACKSTAB * attack1bonus * bonus)
                * Constants.BACKSTABMODK);
        int attack2 = Math.round(Math.round(Constants.PARALYSIS * bonus) * Constants.PARALYSISMODK);
        knight.setOvertimedamage(attack2);
        return (attack1 + attack2);
    }

    public void setOvertimedamage(final int dmg) {
        overtimedamage = dmg;
    }

    public void setNoroundsextradamage(final int noroundsextradamage) {
        this.noroundsextradamage = noroundsextradamage;
    }

    @Override
    public int attack(final Rogue rogue, final char c) {
        float bonus = getBonus(c);
        float attack1bonus = 1F;
        if ((noAttacks == 1 || noAttacks % Constants.THREE == 1) && c == 'W') {
            attack1bonus = 1.5F;
        }
        noAttacks += 1;
        if (c == 'W') {
            rogue.setNoroundsextradamage(Constants.SIX);
        } else {
            rogue.setNoroundsextradamage(Constants.THREE);
        }
        int attack1 = Math.round(Math.round(Constants.BACKSTAB * attack1bonus * bonus)
                * Constants.BACKSTABMODR);
        int attack2 = Math.round(Math.round(Constants.PARALYSIS * bonus) * Constants.PARALYSISMODR);
        rogue.setOvertimedamage(attack2);
        return (attack1 + attack2);
    }

    @Override
    public int getLife() {
        return actualLife;
    }

    public void setIsNotAlive() {
        isAlive = 0;
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
    public void addExp(final
                           int exp) {
        xp += exp;
    }

    @Override
    public int getExp() {
        return xp;
    }
}
