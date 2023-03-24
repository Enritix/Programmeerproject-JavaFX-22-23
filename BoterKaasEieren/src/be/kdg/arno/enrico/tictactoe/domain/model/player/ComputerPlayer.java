package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;
import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

import java.util.Random;

/**
 * This class is used to create a Computer Player.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class ComputerPlayer implements Player {
    //Properties.
    private String player;
    private int x;
    private int y;
    Random r = new Random();

    //Constructor.
    public ComputerPlayer(String player) {
        this.player = player;
    }

    //Methods.
    @Override
    public boolean play(Board board, int col, int row) {
        if (board.isSquareEmpty(row, col)) {
            board.addPiece(this.player, row, col);
        } else {
            do {
                setX();
                setY();
                col = getX();
                row = getY();
            } while (!board.isSquareEmpty(row, col));
            board.addPiece(this.player, row, col);
        }
        System.out.println("\nComputer played: (" + row + "," + col + ")\n");
        return true;
    }//play.

    //Getters and Setters.
    public int getX() {
        return x;
    }//getX.

    public int getY() {
        return y;
    }//getY.

    public void setX() {
        this.x = r.nextInt(UIConstants.getBoardSize());
    }//setX.

    public void setY() {
        this.y = r.nextInt(UIConstants.getBoardSize());
    }//setY.

    @Override
    public String getName() {
        return "Computer";
    }//getName.

    @Override
    public void setName(String name) {
    }

    @Override
    public String getPlayer() {
        return this.player;
    }//getPlayer.

    @Override
    public String toString() {
        return "Computer";
    }//toString.
}

