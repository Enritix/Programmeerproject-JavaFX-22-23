package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import be.kdg.arno.enrico.tictactoe.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.HumanPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

import static javafx.application.Platform.exit;

public class GamePresenter {
    private GameView view;
    private TicTacToe game;


    public GamePresenter(TicTacToe game, GameView view) {
        this.view = view;
        this.game = game;
        addEventHandlers();
    }

    private void addEventHandlers() {
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Player one (X), give your name: ");
        String player1 = sc.next();
        System.out.print("Player two (O), give your name: ");
        String player2 = sc.next();
        System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);
        game.twoPlayers(player1, player2);*/
        view.getLblPlayer1().setText(game.getPlayers()[0].getName());
        view.getLblPlayer2().setText(game.getPlayers()[1].getName());


        view.getBtnHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.reset();
                for (int i = 0; i < game.getBoardSize(); i++) {
                    for (int j = 0; j < game.getBoardSize(); j++) {

                        view.getBtnBoardSquares()[i][j].setText("");
                        view.getBtnBoardSquares()[i][j].setDisable(false);
                    }
                }
                /*for (int i = 0; i < game.getBoardSize(); i++) {
                    for (int j = 0; j < game.getBoardSize(); j++) {

                        view.getBtnBoardSquares()[i][j].setText("");
                        game.clearBoard();
                        view.getBtnBoardSquares()[i][j].setDisable(false);
                    }
                }
                game.reset();
                game.twoPlayers(game.getPlayers()[0].getName(), game.getPlayers()[1].getName());
                updateView();
                System.out.println("Board and players cleared...");
                System.out.println(game.getBoard().toString());
                new GamePresenter(game,view);*/
                /*StartUpView startUpView = new StartUpView();
                StartUpPresenter startUpPresenter = new StartUpPresenter(game, startUpView);
                Scene scene = view.getScene();
                scene.setRoot(startUpView);
                scene.getWindow().setHeight(view.getHeight()*//*+155*//*); //grootte van het venster blijft hetzelfde
                scene.getWindow().setWidth(view.getWidth()*//*+14*//*);*/
            }
        });

        for (int i = 0; i < game.getBoardSize(); i++) {
            for (int j = 0; j < game.getBoardSize(); j++) {
                final int col = i;
                final int row = j;


                view.getBtnBoardSquares()[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!game.getBoard().checkWin() || !game.isDraw()) {
                            if (game.getCurrentPlayer() instanceof HumanPlayer) {
                                String playerXorO = game.getCurrentPlayer().getPlayer();
                                view.getBtnBoardSquares()[col][row].setText(playerXorO);
                                game.addPieceOnBoard(col, row);
                                view.getBtnBoardSquares()[col][row].setDisable(true);
                                updateView();
                            }
                            if (game.getCurrentPlayer() instanceof ComputerPlayer) {
                                int computerX = game.getPlayers()[1].getMove()[0];
                                int computerY = game.getPlayers()[1].getMove()[1];
                                view.getBtnBoardSquares()[computerX][computerY].setText("O");
                                game.addPieceOnBoard(computerX, computerY);
                                view.getBtnBoardSquares()[computerX][computerY].setDisable(true);
                                updateView();
                            }
                            if (game.hasWon()) {
                                GameView.showMessage(String.format("%s (%s) has won!",
                                        game.getCurrentPlayer().getName(), game.getCurrentPlayer().getPlayer()));
                                updateView();
                            } else if (game.isDraw()) {
                                GameView.showMessage("Draw!");
                                updateView();
                            }
                        } else {
                            view.getBtnBoardSquares()[col][row].setDisable(true);
                        }
                        /*if (!game.hasWon() && !game.isDraw()) {
                            Player currentPlayer = game.getCurrentPlayer();
                            String playerXorO = currentPlayer.getPlayer();
                            view.getBtnBoardSquares()[col][row].setText(playerXorO);
                            game.addPieceOnBoard(col, row);
                            view.getBtnBoardSquares()[col][row].setDisable(true);
                            updateView();

                            if (game.hasWon()) {
                                GameView.showMessage(String.format("%s (%s) has won!",
                                        currentPlayer.getName(), playerXorO));
                                updateView();
                            } else if (game.isDraw()) {
                                GameView.showMessage("Draw!");
                                updateView();
                            } else if (currentPlayer instanceof ComputerPlayer) {
                                int[] computerMove = currentPlayer.getMove();
                                int computerX = computerMove[0];
                                int computerY = computerMove[1];
                                view.getBtnBoardSquares()[computerX][computerY].setText("O");
                                game.addPieceOnBoard(computerX, computerY);
                                view.getBtnBoardSquares()[computerX][computerY].setDisable(true);
                                updateView();

                                if (game.hasWon()) {
                                    GameView.showMessage(String.format("%s (%s) has won!",
                                            currentPlayer.getName(), playerXorO));
                                    updateView();
                                } else if (game.isDraw()) {
                                    GameView.showMessage("Draw!");
                                    updateView();
                                }
                            }
                        } else {
                            view.getBtnBoardSquares()[col][row].setDisable(true);
                        }*/
                    }
                });
            }
        }
        view.getBtnQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exit();
            }
        });
    }

    private void updateView() {
        if (game.getCurrentPlayer().getPlayer().equals("X")) {
            //border rond lblPlayer1
            view.getLblPlayer1().setBorder(Border.stroke(Color.RED));
            view.getLblPlayer2().setBorder(null);
        } else {
            //border rond lblPlayer2
            view.getLblPlayer2().setBorder(Border.stroke(Color.RED));
            view.getLblPlayer1().setBorder(null);
        }
    }
}
