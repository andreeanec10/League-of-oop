package main;

import java.util.ArrayList;

import fileio.FileSystem;
import main.character.Heroes;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        String landsname = new String();
        int noheros = 0;
        int width = 0;
        int length = 0;
        ArrayList<String> heroes = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        int rounds = 0;
        ArrayList<String> string = new ArrayList<>();

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            width = fs.nextInt();
            length = fs.nextInt();

            for (int i = 0; i < width; i++) {
                String s = fs.nextWord();
                for (int j = 0; j < length; j++) {
                    landsname += s.charAt(j);
                }
            }

            noheros = Integer.parseInt("" + fs.nextWord());

            for (int i = 0; i < noheros; i++) {
                String s = fs.nextWord();
                heroes.add("" + s.charAt(0));
                String s1 = fs.nextWord();
                positions.add(Integer.parseInt("" + s1.charAt(0)));
                String s2 = fs.nextWord();
                positions.add(Integer.parseInt("" + s2.charAt(0)));
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; i++) {
                string.add(fs.nextWord());
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(length, width, landsname, heroes, positions,
                rounds, string);
    }

    public void write(final Heroes heroes) {
        try {
            FileSystem f = new FileSystem(mInputPath, mOutputPath);
            for (int i = 0; i < heroes.getHeroes().size(); i++) {
                f.writeWord(heroes.getHeroes().get(i).toString());
                f.writeNewLine();
            }
            f.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
