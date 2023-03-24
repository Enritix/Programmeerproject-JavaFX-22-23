package be.kdg.arno.enrico.tictactoe.domain.model.player;

import javafx.animation.AnimationTimer;

/**
 * This class is used to play an animation, which works as a sort of
 * move placement timer.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class DelayedPlayerMoveTimer extends AnimationTimer {
    //Properties.
    private long delayTime;
    private long lastTime;
    private boolean playerMoved;

    //Constructor.
    public DelayedPlayerMoveTimer(long delayTime) {
        this.delayTime = delayTime;
        this.lastTime = 0;
        this.playerMoved = false;
    }

    //Methods.
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
    }//handle.

    public void reset() {
        lastTime = 0;
        playerMoved = false;
    }//reset.
}
