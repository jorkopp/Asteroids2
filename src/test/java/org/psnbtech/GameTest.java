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
    void testAddScore() {
        game.addScore(50);
        assertEquals(50, game.getScore());
        game.addScore(25);
        assertEquals(75, game.getScore());
    }

    @Test
    void testKillPlayerDecrementsLives() {
        int initialLives = game.getLives();
        game.killPlayer();
        assertEquals(initialLives - 1, game.getLives());
    }

    private static class GameStub extends Game {
        private int score = 0;
        private int lives = 3;
        private boolean gameOver = false;

        @Override
        public void addScore(int points) {
            score += points;
        }

        @Override
        public int getScore() { return score; }

        @Override
        public void killPlayer() {
            lives--;
            if (lives <= 0) gameOver = true;
        }

        @Override
        public int getLives() { return lives; }

        @Override
        public boolean isGameOver() { return gameOver; }
    }
}