package com.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam){
        if(homeTeam == null || awayTeam == null || homeTeam.isBlank() || awayTeam.isBlank()){
            throw new IllegalArgumentException("Team names can't be null or empty!");
        }
        if(homeTeam.equalsIgnoreCase(awayTeam)){
            throw new IllegalArgumentException("Team cannot play against itself!");
        }
        if(matchAlreadyExists(homeTeam, awayTeam)){
            throw new IllegalArgumentException("This match is already in progress!");
        }

        matches.add(new Match(homeTeam, awayTeam));
    }

    public List<Match> getMatches(){
        return matches;
    }

    private boolean matchAlreadyExists(String homeTeam, String awayTeam){
        for(Match match : matches){
            if(match.getHomeTeam().equalsIgnoreCase(homeTeam) && match.getAwayTeam().equalsIgnoreCase(awayTeam)){
                return true;
            }
        }
        return false;
    }

}
