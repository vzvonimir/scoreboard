package com.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScoreBoard {
    private final List<Match> matches = new ArrayList<>();

    public Match startMatch(String homeTeam, String awayTeam){
        if(homeTeam == null || awayTeam == null || homeTeam.isBlank() || awayTeam.isBlank()){
            throw new IllegalArgumentException("Team names can't be null or empty!");
        }
        if(homeTeam.equalsIgnoreCase(awayTeam)){
            throw new IllegalArgumentException("Team cannot play against itself!");
        }
        if(matchAlreadyExists(homeTeam, awayTeam)){
            throw new IllegalArgumentException("This match is already in progress!");
        }

        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public void updateScore(UUID matchId, int homeScore, int awayScore){
        if(homeScore < 0 || awayScore < 0){
            throw new IllegalArgumentException("Scores can't be negative!");
        }

        Match match = findMatchById(matchId);
        match.setScore(homeScore, awayScore);
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

    private Match findMatchById(UUID matchId){
        for(Match match : matches){
            if(match.getMatchId().equals(matchId)){
                return match;
            }
        }
        throw new IllegalArgumentException("Match not found!");
    }

}
