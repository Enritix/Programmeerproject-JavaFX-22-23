package be.kdg.arno.enrico.boterkaaseieren.domain.model.player;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.*;
import static be.kdg.arno.enrico.boterkaaseieren.domain.model.Piece.Color;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HumanPlayer implements Player {
    private Color color;
    private Scanner sc = new Scanner(System.in);
    private Map<String,Score> scores = new TreeMap<>();
    private String name;

    public HumanPlayer(String name, Color color) {
        this.color = color;
        this.name = name;
    }

    @Override
    public void play(Board board) {
        boolean placed = false;
            do {
                System.out.printf("%n%s's turn: ", getName());
                System.out.print("\n↪Enter a column number (0, 1 or 2) -> ");
                int row = sc.nextInt();
                System.out.print("↪Enter a row number (0, 1 or 2) -> ");
                int column = sc.nextInt();
                placed = board.addPiece(new Piece(this.color), column, row);
                if (!placed) {
                    System.out.println("\nThis tile is not empty! Try again...");
                }
            } while (!placed);
            System.out.println();

    }

    public void addStars(String naam, Score stars) {
        this.scores.put(naam,stars);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
