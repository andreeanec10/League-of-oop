package main.map;

public final class Woods extends Lands {
    private char name = 'W';
    private int noplayers = 0;

    public char getName() {
        return name;
    }

    public void addCharactersIn() {
        noplayers += 1;
    }

    public void reset() {
        noplayers = 0;
    }

    public int getNoplayers() {
        return noplayers;
    }

}
