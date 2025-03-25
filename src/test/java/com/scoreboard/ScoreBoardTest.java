package com.scoreboard;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    @Test
    void startMatch_shouldAddMatchWithInitialScoreZero(){
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.startMatch("Spain", "Brazil");

        List<Match> matches = scoreBoard.getMatches();

        assertEquals(1, matches.size());

        Match match = matches.get(0);
        assertEquals("Spain", match.getHomeTeam());
        assertEquals("Brazil", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void startMatch_shouldThrowIfTeamsAreTheSame(){
        ScoreBoard scoreBoard = new ScoreBoard();

        assertThrows(IllegalArgumentException.class, () -> {
           scoreBoard.startMatch("Spain", "Spain");
        });
    }

    @Test
    void startMatch_shouldThrowIfTeamNamesAreNullOrEmpty(){
        ScoreBoard scoreBoard = new ScoreBoard();

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.startMatch(null, "Brazil");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.startMatch("Spain", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.startMatch("", "Brazil");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.startMatch("Spain", "");
        });
    }

    @Test
    void startMatch_shouldThrowIfMatchAlreadyExists(){
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.startMatch("Spain", "Brazil");

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.startMatch("Spain", "Brazil");
        });
    }
}
