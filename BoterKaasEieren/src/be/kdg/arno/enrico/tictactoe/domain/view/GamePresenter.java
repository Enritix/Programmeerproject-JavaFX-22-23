package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.Leaderboard;
import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import be.kdg.arno.enrico.tictactoe.domain.model.exceptions.TileNotEmptyException;
import be.kdg.arno.enrico.tictactoe.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.DelayedPlayerMoveTimer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.HumanPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Optional;

import static javafx.application.Platform.exit;

/**
 * This class is the presenter for the game window.
 * This is the window that gets opened as soon as the Play button is clicked inside one of the initialising windows is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class GamePresenter {
    //Properties.
    private GameView view;
    private TicTacToe game;
    DelayedPlayerMoveTimer timer = new DelayedPlayerMoveTimer(1500000000);
    Leaderboard leaderboard = new Leaderboard();

    //Constructor.
    public GamePresenter(TicTacToe game, GameView view) {
        this.view = view;
        this.game = game;
        game.reset();
        addEventHandlers();
        updateView();
    }

    //Methods.
    private void addEventHandlers() {
        view.getLblPlayer1().setText(game.getPlayers()[0].getName());
        view.getLblPlayer1Score().setText(leaderboard.getScoreFromLeaderboard(game.getPlayers()[0].getName()));
        view.getLblPlayer2().setText(game.getPlayers()[1].getName());
        view.getLblPlayer2Score().setText(leaderboard.getScoreFromLeaderboard(game.getPlayers()[1].getName()));

        view.getBtnNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*String url = "/new_game.mp3";
                AudioClip newGame = new AudioClip(new File(url).toURI().toString());
                newGame.play();*/
                game.reset();
                updateView();
                for (int i = 0; i < game.getBoardSize(); i++) {
                    for (int j = 0; j < game.getBoardSize(); j++) {

                        view.getBtnBoardSquares()[i][j].setText("");
                        view.getBtnBoardSquares()[i][j].setDisable(false);
                    }
                }
            }
        });

        view.getBtnNewGame().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnNewGame().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnNewGame().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnNewGame().setEffect(null);
            }
        });

        for (int i = 0; i < game.getBoardSize(); i++) {
            for (int j = 0; j < game.getBoardSize(); j++) {
                final int col = i;
                final int row = j;


                view.getBtnBoardSquares()[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if ((!game.getBoard().checkWin() || !game.isDraw()) && view.getBtnBoardSquares()[col][row].getText().equals("")) {
                            if (game.getCurrentPlayer() instanceof HumanPlayer) {
                                String playerXorO = game.getCurrentPlayer().getPlayer();
                                view.getBtnBoardSquares()[col][row].setText(playerXorO);
                                game.addPieceOnBoard(col, row);
                                /*view.getBtnBoardSquares()[col][row].setDisable(true);*/
                                updateView();
                            }
                            if (!game.getBoard().checkWin() || !game.isDraw()) {
                                if (game.getCurrentPlayer() instanceof ComputerPlayer) {
                                    game.getPlayers()[1].setY();
                                    game.getPlayers()[1].setX();
                                    game.addPieceOnBoard(game.getPlayers()[1].getX(), game.getPlayers()[1].getY());
                                    timer.reset();
                                    view.getBtnBoardSquares()[game.getPlayers()[1].getX()][game.getPlayers()[1].getY()].setText("O");
                                    /*view.getBtnBoardSquares()[game.getPlayers()[1].getX()][game.getPlayers()[1].getY()].setDisable(true);*/
                                    updateView();
                                }
                            }
                            if (game.hasPlayerXWon()) {
                                GameView.showMessage(String.format("%s (%s) has won!%nTo play again, press on 'New Game'",
                                        game.getPlayers()[0].getName(), game.getPlayers()[0].getPlayer()));
                                disableBoard();
                                updateView();
                            } else if (game.hasPlayerOWon()) {
                                GameView.showMessage(String.format("%s (%s) has won!%nTo play again, press on 'New Game'",
                                        game.getPlayers()[1].getName(), game.getPlayers()[1].getPlayer()));
                                disableBoard();
                                updateView();
                            } else if (game.isDraw()) {
                                GameView.showMessage("Draw!\nTo play again, press on 'New Game'");
                                disableBoard();
                                updateView();
                            }
                        } else {
                            try {
                                throw new TileNotEmptyException("This tile is not empty!\nTry again.");
                            } catch (TileNotEmptyException e) {
                                GameView.showMessage(e.getMessage());
                            }
                        }
                    }
                });

                view.getBtnBoardSquares()[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        view.getBtnBoardSquares()[col][row].setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
                    }
                });

                view.getBtnBoardSquares()[i][j].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        view.getBtnBoardSquares()[col][row].setEffect(null);
                    }
                });
            }
        }

        view.getBtnQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Quit");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to quit?");
                alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.YES) {
                    exit();
                }
            }
        });

        view.getBtnQuit().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnQuit().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnQuit().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnQuit().setEffect(null);
            }
        });

        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Quit");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to quit?");
                alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.YES) {
                    StartUpView startUpView = new StartUpView();
                    StartUpPresenter startUpPresenter = new StartUpPresenter(game, startUpView);
                    Scene scene = view.getScene();
                    scene.setRoot(startUpView);
                    scene.getWindow().setHeight(view.getHeight() + 37);
                    scene.getWindow().setWidth(view.getWidth() + 14);
                }
            }
        });

        view.getBtnBack().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnBack().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnBack().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnBack().setEffect(null);
            }
        });
    }//addEventHandlers.

    private void updateView() {
        if (game.getCurrentPlayer().getPlayer().equals("X")) {
            view.getLblPlayer1().setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px; " +
                    "-fx-border-color: red; -fx-border-radius: 14px; -fx-border-width: 3px");
            view.getLblPlayer2().setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px; -fx-border-color: transparent");
        } else {
            //border rond lblPlayer2
            view.getLblPlayer2().setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px; " +
                    "-fx-border-color: red; -fx-border-radius: 14px; -fx-border-width: 3px");
            view.getLblPlayer1().setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px; -fx-border-color: transparent");
        }
        view.getLblPlayer1Score().setText(leaderboard.getScoreFromLeaderboard(game.getPlayers()[0].getName()));
        view.getLblPlayer2Score().setText(leaderboard.getScoreFromLeaderboard(game.getPlayers()[1].getName()));
    }//updateView.

    public void disableBoard() {
        for (int i = 0; i < game.getBoardSize(); i++) {
            for (int j = 0; j < game.getBoardSize(); j++) {
                view.getBtnBoardSquares()[i][j].setDisable(true);
            }
        }
    }//disableBoard.
}
