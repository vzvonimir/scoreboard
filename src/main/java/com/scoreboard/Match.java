package com.scoreboard;

import java.util.UUID;

public class Match {
    private final UUID matchId;
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(String homeTeam, String awayTeam){
        this.matchId = UUID.randomUUID();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public UUID getMatchId(){
        return matchId;
    }

    public String getHomeTeam(){
        return homeTeam;
    }

    public String getAwayTeam(){
        return awayTeam;
    }

    public int getHomeScore(){
        return homeScore;
    }

    public int getAwayScore(){
        return awayScore;
    }

    public void setScore(int homeScore, int awayScore){
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
