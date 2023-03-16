package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner sc = new Scanner(System.in);
    private String name;
    private String player;

    public HumanPlayer(String name, String player) {
        this.name = name;
        this.player = player;
    }

    @Override
    public boolean play(Board board, int col, int row) {
        /*boolean placed = false;
        do {
            System.out.printf("%n%s's turn: ", getName());
            System.out.print("\n↪Enter a column number (0, 1 or 2) -> ");
            int column = sc.nextInt();
            System.out.print("↪Enter a row number (0, 1 or 2) -> ");
            int row = sc.nextInt();
            placed = board.addPiece(this.player, row, col);
            if (!placed) {
                System.out.println("\nThis tile is not empty! Try again...");
            }
        } while (!placed);*/
        board.addPiece(this.player, row, col);
        System.out.println();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPlayer() {
        return this.player;
    }

    @Override
    public void setMove(int x, int y) {

    }

    @Override
    public int[] getMove() {
        return new int[0];
    }

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