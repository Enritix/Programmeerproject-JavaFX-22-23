package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;

/**
 * This class is an interface for both the player possibilities.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public interface Player {
    //Methods.
    boolean play(Board board, int col, int row);//play.

    //Getters and Setters.
    String getName();//getName.

    void setName(String name);//setName.

    public String getPlayer();//getPlayer.

    void setX();//setX.

    void setY();//setY.

    int getX();//getX.

    int getY();//getY.
}

