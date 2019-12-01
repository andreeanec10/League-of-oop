package main.map;

final class LandFactory {
    private static LandFactory instance = null;

    private LandFactory() {
        //
    }

    static LandFactory getInstance() {
        if (instance == null) {
            instance = new LandFactory();
        }
        return instance;
    }

    Lands createLand(final char type) {
        switch (type) {
            case 'L':
                return new Land();
            case 'V':
                return new Volcanic();
            case 'D':
                return new Desert();
            case 'W':
                return new Woods();
            default:
                return null;
        }
    }
}
