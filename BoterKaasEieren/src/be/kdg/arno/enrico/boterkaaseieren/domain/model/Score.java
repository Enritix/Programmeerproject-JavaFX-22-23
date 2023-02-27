package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.Player;

import static be.kdg.arno.enrico.boterkaaseieren.domain.model.Piece.Color.*;

public class Score {
    private int stars;
    private Player player;
    private BoterKaasEieren bke;
    private Board board;

    public Score(Player player, Board board) {
        Piece.Color winnaar;
        winnaar = board.hasOXO();
        this.board = board;
        if (board.isFull()) {
            this.stars = 1;
            this.player = player;
        } else if (winnaar == RED || winnaar == BLACK) {
            this.stars = 3;
            this.player = player;
        } else {
            this.stars = 0;
            this.player = player;
        }
        Leaderboard.addScore(player.getName(),this);
    }
    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return getStars() + "";
    }
}
