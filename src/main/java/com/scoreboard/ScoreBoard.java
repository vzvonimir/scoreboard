package com.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam){
        matches.add(new Match(homeTeam, awayTeam));
    }

    public List<Match> getMatches(){
        return matches;
    }
}
