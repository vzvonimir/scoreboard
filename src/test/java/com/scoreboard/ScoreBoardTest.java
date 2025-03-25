package com.scoreboard;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.UUID;

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

    @Test
    void updateScore_shouldUpdateScoreOfExistingMatch(){
        ScoreBoard scoreBoard = new ScoreBoard();
        Match match = scoreBoard.startMatch("Spain", "Brazil");

        scoreBoard.updateScore(match.getMatchId(), 2, 1);

        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

    @Test
    void updateScore_shouldThrowIfMatchNotFound(){
        ScoreBoard scoreBoard = new ScoreBoard();
        UUID fakeId = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore(fakeId, 2, 2);
        });
    }

    @Test
    void updateScore_shouldThrowIfScoresAreNegative(){
        ScoreBoard scoreBoard = new ScoreBoard();
        Match match = scoreBoard.startMatch("Spain", "Brazil");

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore(match.getMatchId(), -1, 3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore(match.getMatchId(), 2, -2);
        });
    }

    @Test
    void finishMatch_shouldRemoveMatchFromScoreboard(){
        ScoreBoard scoreBoard = new ScoreBoard();
        Match match = scoreBoard.startMatch("Croatia", "Italy");

        scoreBoard.finishMatch(match.getMatchId());

        List<Match> matches = scoreBoard.getMatches();
        assertTrue(matches.isEmpty());
    }

    @Test
    void finishMatch_shouldThrowIfMatchNotFound(){
        ScoreBoard scoreBoard = new ScoreBoard();
        UUID fakeId = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.finishMatch(fakeId);
        });
    }
}
