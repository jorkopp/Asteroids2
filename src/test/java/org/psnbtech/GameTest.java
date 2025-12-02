package org.psnbtech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new GameStub();
    }

    @Test
    void testInitialGameState() {
        assertNotNull(game.getPlayer(), "Player should be initialized");
        assertEquals(0, game.getScore(), "Initial score should be 0");
        assertEquals(3, game.getLives(), "Initial lives should be 3");
        assertFalse(game.isGameOver(), "Game should not be over initially");
    }

    @Test
    void testKillPlayerDecrementsLives() {
        int initialLives = game.getLives();
        game.killPlayer();
        assertEquals(initialLives - 1, game.getLives(), "Lives should decrement by 1");
        assertFalse(game.isGameOver(), "Game should not be over if lives remain");
    }

    @Test
    void testKillPlayerGameOver() {
        game.killPlayer();
        game.killPlayer();
        game.killPlayer();
        assertEquals(0, game.getLives(), "Lives should be 0");
        assertTrue(game.isGameOver(), "Game should be over when lives are 0");
    }

    @Test
    void testAddScore() {
        game.addScore(50);
        assertEquals(50, game.getScore());
        game.addScore(25);
        assertEquals(75, game.getScore());
    }
}