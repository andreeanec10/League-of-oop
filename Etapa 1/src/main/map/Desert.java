package main.map;

public class Desert extends Lands {
    private char name = 'D';

    public char getName() {
        return name;
    }

    @Override
    public char getLandsName(Lands desert) {
        return desert.getName();
    }

    @Override
    public char isGettingName(Lands lands) {
        return lands.getLandsName(this);
    }
}
