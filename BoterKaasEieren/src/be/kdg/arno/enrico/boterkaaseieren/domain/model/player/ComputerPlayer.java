package be.kdg.arno.enrico.boterkaaseieren.domain.model.player;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.Board;

import java.util.Random;

public class ComputerPlayer implements Player{
    private String player;

    public ComputerPlayer(String player) {
        this.player = player;
    }

    @Override
    public void play(Board board, int row, int col) {
        boolean gelukt = false;
        Random r = new Random();
        do{
            row = r.nextInt(3);
            col = r.nextInt(3);
            gelukt = board.addPiece(this.player, row, col);
        } while (gelukt != true);
        System.out.println("\nComputer played: (" + row + "," + col + ")\n");
    }

    @Override
    public String getName() {
        return null;
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

