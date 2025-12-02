package org.psnbtech;

import org.psnbtech.entity.Player;
import org.psnbtech.entity.Entity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameStub extends Game {

    public GameStub() {
        this.entities = new LinkedList<>();
        this.pendingEntities = new ArrayList<>();
        this.player = new Player();
        this.score = 0;
        this.lives = 3;
        this.isGameOver = false;
        this.world = null;
    }

    @Override
    public void addScore(int score) {
        super.addScore(score);
    }

    @Override
    public void killPlayer() {
        super.killPlayer();
    }

    @Override
    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isPaused() {
        return false;
    }
}