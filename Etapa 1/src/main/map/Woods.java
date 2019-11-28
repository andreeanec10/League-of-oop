package main.map;

public class Woods extends Lands {
    private char name = 'W';

    public char getName() {
        return name;
    }

    @Override
    public char isGettingName(Lands lands) {
        return lands.getLandsName(this);
    }

    @Override
    public char getLandsName(Lands woods) {
        return woods.getName();
    }
}
