package main;

import java.util.ArrayList;

import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        String  landsname = new String();
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

            for (int i = 0; i < width * length; ++i) {
                landsname += fs.nextWord();
            }

            noheros = fs.nextInt();

            for (int i = 0; i < noheros; i++) {
                heroes.add(fs.nextWord());
                positions.add(fs.nextInt());
                positions.add(fs.nextInt());
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; i++) {
                string.add(fs.nextWord());
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(length, width, landsname, noheros, heroes, positions,
                rounds, string);
    }
}
