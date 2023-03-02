package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.HumanPlayer;
import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.Player;

public class BoterKaasEieren {
    private Board board;
    private Player[] players;
    private int playerCounter = 0;


    public BoterKaasEieren(int size) {
        this.board = new Board(size);
        board.toString();
        this.players = new Player[2];
    }

    public void playGame() {
        boolean winnaar = false;
        board.toString();
        /*do {
            if (!board.isFull()) {
                *//*players[0].play(board);*//*
                *//*System.out.println(board.toString());*//*
                winnaar = board.checkWin();
            }
            if (!winnaar) {
                if (!board.isFull()) {
                    *//*players[1].play(board);*//*
                    *//*System.out.println(board.toString());*//*
                    winnaar = board.checkWin();
                }
            }
        } while (!winnaar && !board.isFull());*/
        winnaar = board.checkWin();
        if (winnaar == true && players[0].getPlayer().equals("X")) {
            System.out.println("\n" + players[0] + " (X) wins!\n");
            board.clearBoard();
            /*Score winnaarO = new Score(players[0], board);*/
        } else if (winnaar == true && players[0].getPlayer().equals("X")) {
            System.out.println("\n" + players[1] + " (O) wins!\n");
            board.clearBoard();
            /*Score winnaarX = new Score(players[1], board);*/
        } else if (board.isFull()){
            System.out.println("\nDraw!\n");
            board.clearBoard();
            /*Score draw = new Score(players[0], board);
            Score draw2 = new Score(players[1], board);*/
        }
    }

    public void twoPlayers() {
        players[0] = new HumanPlayer("X");
        players[1] = new HumanPlayer("O");
    }

    public void onePlayerOneComputer() {
        players[0] = new HumanPlayer("X");
        players[1] = new ComputerPlayer("O");
    }

    public void clearPlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i] = null;
        }
    }

    public void clearBoard() {
        board.clearBoard();
    }

    public int getBoardSize() {
        return board.getSize();
    }

    public String getCurrentPlayer() {
        if (playerCounter == 0) {
            this.playerCounter++;
            return "X";
        } else {
            this.playerCounter--;
            return "O";
        }
    }

    public Player getPlayer() {
        if (playerCounter == 0) {
            return players[0];
        } else {
            return players[1];
        }
    }

    public Board getBoard() {
        return board;
    }

    public void addPieceOnBoard(String player, int rowNumber, int colNumber) {
        board.addPiece(player, rowNumber, colNumber);
    }
}
