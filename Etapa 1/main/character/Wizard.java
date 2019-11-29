package main.character;

public final class Wizard extends Character {
    private char name = 'W';
    private int pozx;
    private int pozy;

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
    public int Attack(final Knight knight, final char c) {
        return 0;
    }
}
