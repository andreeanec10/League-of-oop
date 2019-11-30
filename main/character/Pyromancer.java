package main.character;

public final class Pyromancer extends Character {
    private char name = 'P';
    private int pozx;
    private int pozy;
    private int xp = 0;

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

    @Override
    public String getInfo() {
        return name + " " + pozx + " " + pozy;
    }

    public void isAttacked(final Character character, final char c) {
    }

    @Override
    public void setIsNotAlive() {
        int x = 0;
    }

    public int attack(final Knight knight, final char c) {
        return 0;
    }

    @Override
    public int getLife() {
        return 0;
    }

    @Override
    public int attack(final Rogue rogue, final char c) {
        return 0;
    }

    @Override
    public void addExp(final int exp) {
        xp += exp;
    }

    @Override
    public int getExp() {
        return xp;
    }
}
