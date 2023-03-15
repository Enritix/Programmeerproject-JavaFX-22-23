package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;

import java.util.Random;

public class ComputerPlayer implements Player{
    private String player;
    private int x;
    private int y;
    int newRow;
    int newCol;
    private int[] move;
    Random r = new Random();

    public ComputerPlayer(String player) {
        this.player = player;
        this.move = new int[2];
    }

    @Override
    public boolean play(Board board, int col, int row) {

        if (board.isSquareEmpty(col, row)) {
            board.addPiece(this.player, row, col);
        } else {
            do {
                setX();
                setY();
                col = getX();
                row = getY();
            } while (!board.isSquareEmpty(col, row));
            board.addPiece(this.player, col, row);
        }
        System.out.println("\nComputer played: (" + col + "," + row + ")\n");
        setMove(x,y);
        return true;
    }


    public void setMove(int x, int y) {
        /*this.move = new int[]{x, y};*/
        this.move[0] = x;
        this.move[1] = y;
    }

    public int[] getMove() {
        return move;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX() {
        this.x = r.nextInt(3);;
    }

    public void setY() {
        this.y = r.nextInt(3);;
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

