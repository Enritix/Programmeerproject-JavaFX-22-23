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