package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.*;

import static be.kdg.arno.enrico.boterkaaseieren.domain.model.Piece.Color.*;

public class BoterKaasEieren {
    private Board board;
    private Player[] players;


    public BoterKaasEieren() {
        this.board = new Board();
        /*board.createBoard();*/
        board.toString();
        this.players = new Player[2];
    }

    public void playGame() {
        Piece.Color winnaar = null;
        System.out.println(board.toString());
        do {
            if (!board.isFull()) {
                players[0].play(board);
                System.out.println(board.toString());
                winnaar = board.hasOXO();
            }
            if (winnaar == null) {
                if (!board.isFull()) {
                    players[1].play(board);
                    System.out.println(board.toString());
                    winnaar = board.hasOXO();
                }
            }
        } while (winnaar == null && !board.isFull());

        if (board.isFull()) {
            System.out.println("\nDraw!\n");
            board.clearBoard();
            Score draw = new Score(players[0], board);
            Score draw2 = new Score(players[1], board);

            System.out.println(draw.getStars());
            System.out.println(draw2.getStars());

        } else if (winnaar == RED) {
            System.out.println("\n" + players[0] + " (O) wins!\n");
            board.clearBoard();
            Score winnaarO = new Score(players[0], board);

            System.out.println(winnaarO.getStars());

        } else {
            System.out.println("\n" + players[1] + " (X) wins!\n");
            board.clearBoard();
            Score winnaarX = new Score(players[1], board);

            System.out.println(winnaarX.getStars());

        }
    }

    public void TwoPlayers(String player1, String player2) {
        players[0] = new HumanPlayer(player1, RED);
        players[1] = new HumanPlayer(player2, BLACK);
    }

    public void OnePlayerOneComputer(String player) {
        players[0] = new HumanPlayer(player, RED);
        players[1] = new ComputerPlayer(BLACK);
    }
    public void clearPlayers() {
        for (int i = 0; i < players.length; i++) {
                players[i] = null;
        }
    }
}
