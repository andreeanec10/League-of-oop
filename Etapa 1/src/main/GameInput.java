package main;

import main.map.Map;

import java.util.List;

public class GameInput {
    // DO NOT MODIFY
    //private final List<Integer> mAssetOrder;
    //private final List<String> mPlayersOrder;
    //private int mRounds;
    private int mLength;
    private int mWidth;
    private String lands_name;
    private int nrHeroes;
    Map map;

    public GameInput() {
        mLength = 0;
        mWidth = 0;
        lands_name = new String();
        map = null;
    }

    public GameInput(final int length, final int width, final String s, final int heroes) {
        mLength = length;
        mWidth = width;;
        lands_name = s;
        nrHeroes = heroes;
        map = new Map(length, width, s);
    }

    public final int getmLength() {
        return mLength;
    }

    public final int getmWidth() {
        return mWidth;
    }
    public final String getLans() {
        return lands_name;
    }
    public final int getNrHeroes() {
        return nrHeroes;
    }
    public  final Map getMap() {
        return map;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = lands_name != null;
        boolean membersNotEmpty = mLength > 0 && mWidth > 0 && nrHeroes > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
