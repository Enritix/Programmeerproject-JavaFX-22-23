package be.kdg.arno.enrico.tictactoe.domain.model.player;

import be.kdg.arno.enrico.tictactoe.domain.model.Board;

public interface Player {

    boolean play(Board board , int col, int row);
    String getName();
    void setName(String name);
    public String getPlayer();
}

