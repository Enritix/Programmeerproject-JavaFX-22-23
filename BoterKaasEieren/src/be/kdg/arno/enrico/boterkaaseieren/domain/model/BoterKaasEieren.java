package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.HumanPlayer;
import be.kdg.arno.enrico.boterkaaseieren.domain.model.player.Player;

public class BoterKaasEieren {
    private Board board;
    private Player[] players;
    private int moveCounter = 0;
    private String currentPlayer;
    private boolean winnaar = false;
    private boolean won;
    private boolean draw;



    public BoterKaasEieren(int size) {
        this.board = new Board(size);
        board.toString();
        this.players = new Player[2];
        currentPlayer = "X";
    }

    public void playGame() {
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
        if (winnaar == true && players[0].getPlayer().equals("X")) {
            System.out.println("\n" + players[0].getName() + " (X) wins!\n");
            board.clearBoard();
            /*Score winnaarO = new Score(players[0], board);*/
        } else if (winnaar == true && players[1].getPlayer().equals("O")) {
            System.out.println("\n" + players[1].getName() + " (O) wins!\n");
            board.clearBoard();
            /*Score winnaarX = new Score(players[1], board);*/
        } else if (board.isFull()){
            System.out.println("\nDraw!\n");
            board.clearBoard();
            /*Score draw = new Score(players[0], board);
            Score draw2 = new Score(players[1], board);*/
        }
    }

    public void twoPlayers(String player1, String player2) {
        players[0] = new HumanPlayer(player1, "X");
        players[0].setName(player1);
        players[1] = new HumanPlayer(player2, "O");
        players[1].setName(player2);
    }

    public void onePlayerOneComputer(String player) {
        players[0] = new HumanPlayer(player, "X");
        players[0].setName(player);
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

    public Player getCurrentPlayer() {
        if (moveCounter % 2 == 0) {
            return players[0];
        } else {
            return players[1];
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    /*public void addPieceOnBoard(int rowNumber, int colNumber) {
        Player currentPlayer = getCurrentPlayer();
        board.addPiece(currentPlayer.getPlayer(), colNumber, rowNumber);
        winnaar = board.checkWin();
        System.out.println(board.toString());
    }*/

    public void addPieceOnBoard(int rowNumber, int colNumber) {
        Player currentPlayer = getCurrentPlayer();
        moveCounter++;
        if (board.addPiece(currentPlayer.getPlayer(), rowNumber, colNumber)) {
            System.out.println(board.toString());
            if (board.checkWin()) {
                if (players[0].getPlayer().equals("X")) {
                    System.out.println("\n" + players[0].getName() + " (X) wins!\n");
                    won = true;
                } else {
                    System.out.println("\n" + players[1].getName() + " (O) wins!\n");
                    won = true;
                }
                board.clearBoard();
            } else if (board.isFull()) {
                System.out.println("\nDraw!\n");
                board.clearBoard();
                draw = true;
            }
        } else {
            System.out.println("Tile is already taken. Try again.");
        }
    }

    public boolean hasWon() {
        if (won) {
            moveCounter--;
            return true;
        } else {
            return false;
        }
    }

    public boolean isDraw() {
        if (draw) {
            return true;
        } else {
            return false;
        }
    }
}
