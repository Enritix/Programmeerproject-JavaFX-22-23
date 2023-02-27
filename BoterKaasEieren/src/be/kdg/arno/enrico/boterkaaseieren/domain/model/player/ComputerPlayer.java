package be.kdg.arno.enrico.boterkaaseieren.domain.model.player;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.*;
import static be.kdg.arno.enrico.boterkaaseieren.domain.model.Piece.Color;

import java.util.Random;

public class ComputerPlayer implements Player{
    private Color color;

    public ComputerPlayer(Color color) {
        this.color = color;
    }

    @Override
    public void play(Board board) {
        boolean gelukt = false;
        Random r = new Random();
        int row;
        int column;
        do{
             row = r.nextInt(3);
             column = r.nextInt(3);
            gelukt = board.addPiece(new Piece(this.color), column, row);
        } while (gelukt != true);
        System.out.println("\nComputer played: (" + column + "," + row + ")\n");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
