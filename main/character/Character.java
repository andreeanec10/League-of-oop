package main.character;

public abstract class Character {
    public abstract void setPoz(int x, int y);
    public abstract String getInfo();
    public abstract int getPozx();
    public abstract int getPozy();
    public abstract void isAttacked(Character character, char c);
    public abstract int attack(Knight knight, char c);
    public abstract int attack(Rogue rogue, char c);
    public abstract int getLife();
    public abstract void setIsNotAlive();
    public abstract void addExp(int exp);
    public abstract int getExp();



}
