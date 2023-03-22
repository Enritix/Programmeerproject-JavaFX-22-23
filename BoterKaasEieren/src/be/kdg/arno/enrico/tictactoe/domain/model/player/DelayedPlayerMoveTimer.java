package be.kdg.arno.enrico.tictactoe.domain.model.player;

import javafx.animation.AnimationTimer;

public class DelayedPlayerMoveTimer extends AnimationTimer {
    private long delayTime;
    private long lastTime;
    private boolean playerMoved;

    public DelayedPlayerMoveTimer(long delayTime) {
        this.delayTime = delayTime;
        this.lastTime = 0;
        this.playerMoved = false;
    }

    @Override
    public void handle(long now) {
        if (lastTime == 0) {
            lastTime = now;
            return;
        }

        if (now - lastTime >= delayTime && !playerMoved) {
            // Make computer player move here
            playerMoved = true;
        }
    }

    public void reset() {
        lastTime = 0;
        playerMoved = false;
    }
}
