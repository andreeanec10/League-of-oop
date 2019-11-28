package main.map;

public class Land extends Lands {
    private char name = 'L';

    public char getName() {
        return name;
    }

    @Override
    public char isGettingName(Lands lands) {
        return lands.getLandsName(this);
    }

    @Override
    public char getLandsName(Lands desert) {
        return desert.getName();
    }
}
