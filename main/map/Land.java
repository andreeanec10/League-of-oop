package main.map;

public final class Land extends Lands {
    private char name = 'L';
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
