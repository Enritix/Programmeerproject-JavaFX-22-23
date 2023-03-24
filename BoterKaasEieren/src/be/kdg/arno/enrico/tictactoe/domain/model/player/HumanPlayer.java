package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;

/**
 * This class is used to create a Human Player.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class HumanPlayer implements Player {
    //Properties.
    private String name;
    private String player;

    //Constructor.
    public HumanPlayer(String name, String player) {
        this.name = name;
        this.player = player;
    }

    //Methods.
    @Override
    public boolean play(Board board, int col, int row) {
        board.addPiece(this.player, row, col);
        System.out.println();
        return true;
    }

    //Getters and Setters.
    @Override
    public String getName() {
        return name;
    }//getName.

    @Override
    public void setName(String name) {
        this.name = name;
    }//setName.

    @Override
    public String getPlayer() {
        return this.player;
    }//getPlayer.

    @Override
    public void setX() {
    }

    @Override
    public void setY() {
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }


    @Override
    public String toString() {
        return null;
    }
}