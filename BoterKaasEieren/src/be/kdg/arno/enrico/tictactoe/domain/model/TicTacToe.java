package be.kdg.arno.enrico.tictactoe.domain.model;

import be.kdg.arno.enrico.tictactoe.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.HumanPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.Player;
import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

/**
 * This class is where most of the game logic is.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class TicTacToe {
    //Properties.
    private Board board;
    private Player[] players;
    private int moveCounter = 0;
    private boolean draw;
    private int size;
    public boolean playerX = false;
    public boolean playerO = false;

    //Constructor.
    public TicTacToe(int size) {
        //A board gets created and a size is given with it
        this.size = size;
        this.board = new Board(this.size);
        board.toString();
        this.players = new Player[2];
    }

    //Methods.
    public void reset() {
        setSize(UIConstants.getBoardSize());
        this.board = new Board(UIConstants.boardSize);
        this.moveCounter = 0;
        this.draw = false;
        this.playerX = false;
        this.playerO = false;
    }//reset.

    public void twoPlayers(String player1, String player2) {
        players[0] = new HumanPlayer(player1, "X");
        players[0].setName(player1);
        players[1] = new HumanPlayer(player2, "O");
        players[1].setName(player2);
    }//twoPlayers.

    public void onePlayerOneComputer(String player) {
        players[0] = new HumanPlayer(player, "X");
        players[0].setName(player);
        players[1] = new ComputerPlayer("O");
    }//onePlayerOneComputer.

    public void clearBoard() {
        board.clearBoard();
    }//clearBoard.

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
                    playedGames.saveGame(getPlayers()[0], getPlayers()[1], UIConstants.getBoardSize(),getPlayers()[0].getName() + " won");
                    leaderboard.savePlayerData(getPlayers()[0].getName(), "3");
                    leaderboard.savePlayerData(getPlayers()[1].getName(), "0");
                    leaderboard.sort();
                } else {
                    System.out.println("\n" + players[1].getName() + " (O) wins!\n");
                    playerO = true;
                    playedGames.saveGame(getPlayers()[0], getPlayers()[1],UIConstants.getBoardSize(), getPlayers()[1].getName() + " won");
                    if (!getPlayers()[1].getName().equals("Computer")) {
                        leaderboard.savePlayerData(getPlayers()[1].getName(), "3");
                        leaderboard.savePlayerData(getPlayers()[0].getName(), "0");
                        leaderboard.sort();
                    }
                }
                board.clearBoard();
            } else if (board.isFull()) {
                System.out.println("\nDraw!\n");
                board.clearBoard();
                draw = true;
                playedGames.saveGame(getPlayers()[0], getPlayers()[1], UIConstants.getBoardSize(),  "Draw");
                leaderboard.savePlayerData(getPlayers()[0].getName(), "1");
                if (!getPlayers()[1].getName().equals("Computer")){
                    leaderboard.savePlayerData(getPlayers()[1].getName(), "1");
                }
                leaderboard.sort();
            }
        } else {
            System.out.println("Tile is already taken. Try again.");
        }
    }//addPieceOnBoard.

    public boolean isDraw() {
        if (draw) {
            return true;
        } else {
            return false;
        }
    }//isDraw.

    public void initialisePlayers(String choice, String player1, String player2) {
        if (choice.equals("1p")) {
            onePlayerOneComputer(player1);
        } else {
            twoPlayers(player1, player2);
        }
    }//initialisePlayers.

    public boolean hasPlayerXWon() {
        return playerX;
    }//hasPlayerXWon.

    public boolean hasPlayerOWon() {
        return playerO;
    }//hasPlayerOWon.

    //Getters and Setters.
    public int getBoardSize() {
        return board.getSize();
    }//getBoardSize.

    public Player getCurrentPlayer() {
        if (moveCounter % 2 == 0) {
            return players[0];
        } else {
            return players[1];
        }
    }//getCurrentPlayer.

    public Player[] getPlayers() {
        return players;
    }//getPlayers.

    public void createBoard() {
        board.createBoard();
    }//createBoard.

    public Board getBoard() {
        return board;
    }//getBoard.

    public void setSize(int size) {
        UIConstants.setBoardSize(size);
    }//setSize.
}
