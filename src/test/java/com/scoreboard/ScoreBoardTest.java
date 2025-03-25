package com.scoreboard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
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
}
