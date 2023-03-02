package be.kdg.arno.enrico.boterkaaseieren.domain.model.player;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.Board;

public interface Player {

    void play(Board board , int row, int col);
    /*String getName();*/
    void setName(String name);
    public String getPlayer();
}

