package com.practice.jsonmodels;

import java.util.ArrayList;

public class MatchesHistoryJson {

    private ArrayList<MatchJson> matches;
    private int startIndex;
    private int endIndex;
    private int totalGames;

    public ArrayList<MatchJson> getMatches() {
        return matches;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getTotalGames() {
        return totalGames;
    }
}
