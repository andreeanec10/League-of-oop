package main;

import java.util.ArrayList;
import java.util.List;
import main.map.Map;

import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        //List<Integer> assetsIds = new ArrayList<>();
        String  lands_name = new String();
        int noheros = 0;
        //int noPlayers = 0;
        //int noGoods = 0;
        int width = 0;
        int length = 0;
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            width = fs.nextInt();
            length = fs.nextInt();

            for (int i = 0; i < width * length; ++i) {
                lands_name += fs.nextWord();
            }

            noheros = fs.nextInt();

            //noGoods = fs.nextInt();

            //for (int i = 0; i < noGoods; ++i) {
              //  assetsIds.add(fs.nextInt());
            //}

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(length, width, lands_name, noheros);
    }
}
