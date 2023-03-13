package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;

import java.util.Random;

public class ComputerPlayer implements Player{
    private String player;
    private int x;
    private int y;
    private int[] move;

    public ComputerPlayer(String player) {
        this.player = player;
        this.move = new int[2];
    }

    @Override
    public boolean play(Board board, int row, int col) {
        boolean gelukt = false;
        Random r = new Random();
        do{
            row = r.nextInt(3);
            x = row;
            col = r.nextInt(3);
            y = col;
            gelukt = board.addPiece(this.player, row, col);
        } while (gelukt != true);
        System.out.println("\nComputer played: (" + row + "," + col + ")\n");
        setMove(x,y);
        return true;
    }


    public void setMove(int x, int y) {
        this.move = new int[]{x, y};
    }

    public int[] getMove() {
        return move;
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

