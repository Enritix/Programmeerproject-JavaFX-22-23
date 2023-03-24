package be.kdg.arno.enrico.tictactoe.domain.model;

import be.kdg.arno.enrico.tictactoe.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.HumanPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.Player;
import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

public class TicTacToe {
    private Board board;
    private Player[] players;
    private int moveCounter = 0;
    private boolean draw;
    private int size;
    public boolean playerX = false;
    public boolean playerO = false;


    public TicTacToe(int size) {
        this.size = size;
        this.board = new Board(this.size);
        board.toString();
        this.players = new Player[2];
    }

    public void reset() {
        setSize(UIConstants.getBoardSize());
        this.board = new Board(UIConstants.boardSize);
        this.moveCounter = 0;
        this.draw = false;
        this.playerX = false;
        this.playerO = false;
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

    public void createBoard() {
        board.createBoard();
    }

    public Board getBoard() {
        return board;
    }

    public void setSize(int size) {
        UIConstants.setBoardSize(size);
    }

    public void addPieceOnBoard(int colNumber, int rowNumber) {
        Player currentPlayer = getCurrentPlayer();
        if (currentPlayer.play(board, colNumber, rowNumber)) {
            moveCounter++;
            System.out.println(board.toString());
            PlayedGames playedGames = new PlayedGames();


            Leaderboard leaderboard = new Leaderboard();


            if (board.checkWin()) {
                if (currentPlayer.getPlayer().equals("X")) {
                    System.out.println("\n" + players[0].getName() + " (X) wins!\n");
                    playerX = true;
                    playedGames.save(getPlayers()[0], getPlayers()[1], UIConstants.getBoardSize(),getPlayers()[0].getName() + " won");
                    leaderboard.save(getPlayers()[0].getName(), "3");
                    leaderboard.sort();
                } else {
                    System.out.println("\n" + players[1].getName() + " (O) wins!\n");
                    playerO = true;
                    playedGames.save(getPlayers()[0], getPlayers()[1],UIConstants.getBoardSize(), getPlayers()[1].getName() + " won");
                    leaderboard.save(getPlayers()[1].getName(), "3");
                    leaderboard.sort();
                }
                board.clearBoard();
            } else if (board.isFull()) {
                System.out.println("\nDraw!\n");
                board.clearBoard();
                draw = true;
                playedGames.save(getPlayers()[0], getPlayers()[1], UIConstants.getBoardSize(),  "Draw");
                leaderboard.save(getPlayers()[0].getName(), "1");
                if (!getPlayers()[1].getName().equals("Computer")){
                    leaderboard.save(getPlayers()[1].getName(), "1");
                    leaderboard.sort();
                }
            }
        } else {
            System.out.println("Tile is already taken. Try again.");
        }
    }

    public boolean isDraw() {
        if (draw) {
            return true;
        } else {
            return false;
        }
    }

    public void initialisePlayers(String choice, String player1, String player2) {
        if (choice.equals("1p")) {
            onePlayerOneComputer(player1);
        } else {
            twoPlayers(player1, player2);
        }
    }

    public boolean hasPlayerXWon() {
        return playerX;
    }

    public boolean hasPlayerOWon() {
        return playerO;
    }
}
