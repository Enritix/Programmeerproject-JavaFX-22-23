package be.kdg.arno.enrico.boterkaaseieren.domain.model.player;


import be.kdg.arno.enrico.boterkaaseieren.domain.model.*;

public interface Player {

    void play(Board board);
    String getName();
}
