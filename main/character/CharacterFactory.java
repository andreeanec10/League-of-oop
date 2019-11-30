package main.character;

final class CharacterFactory {
    private static CharacterFactory instance = null;

    private CharacterFactory() {
        //not to be used
    }

    static CharacterFactory getInstance() {
        if (instance == null) {
            instance = new CharacterFactory();
        }
        return instance;
    }

    Character createCharacter(final String type) {
        switch (type) {
            case "K" : return new Knight();
            case "R" : return new Rogue();
            case "W" : return new Wizard();
            case "P" : return new Pyromancer();
            default : return null;
        }
    }
}
