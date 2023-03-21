package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;
import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

import java.util.Random;

public class ComputerPlayer implements Player {
    private String player;
    private int x;
    private int y;
    private int[] move;
    Random r = new Random();

    public ComputerPlayer(String player) {
        this.player = player;
        this.move = new int[2];
    }

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
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX() {
        this.x = r.nextInt(UIConstants.getBoardSize());
    }

    public void setY() {
        this.y = r.nextInt(UIConstants.getBoardSize());
    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public String getPlayer() {
        return this.player;
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

