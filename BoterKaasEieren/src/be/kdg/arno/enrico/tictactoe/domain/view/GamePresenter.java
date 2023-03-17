package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import be.kdg.arno.enrico.tictactoe.domain.model.player.ComputerPlayer;
import be.kdg.arno.enrico.tictactoe.domain.model.player.HumanPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;

import static javafx.application.Platform.exit;

public class GamePresenter {
    private GameView view;
    private TicTacToe game;


    public GamePresenter(TicTacToe game, GameView view) {
        this.view = view;
        this.game = game;
        addEventHandlers();
        updateView();
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

        /*File soundFile = new File("BoterKaasEieren/resources/sounds/new_game.mp3");
        Media sound = new Media(soundFile.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);*/
        view.getBtnNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*mediaPlayer.play();*/
                String url = "BoterKaasEieren/resources/sounds/new_game.mp3";
                AudioClip newGame = new AudioClip(new File(url).toURI().toString());
                newGame.play();

                game.reset();
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
                        if (!game.getBoard().checkWin() || !game.isDraw()) {
                            if (game.getCurrentPlayer() instanceof HumanPlayer) {
                                String playerXorO = game.getCurrentPlayer().getPlayer();
                                view.getBtnBoardSquares()[col][row].setText(playerXorO);
                                game.addPieceOnBoard(col, row);
                                view.getBtnBoardSquares()[col][row].setDisable(true);
                                updateView();
                            }
                            if (!game.getBoard().checkWin() || !game.isDraw()) {
                                if (game.getCurrentPlayer() instanceof ComputerPlayer) {
                                    game.getPlayers()[1].setY();
                                    game.getPlayers()[1].setX();
                                    game.addPieceOnBoard(game.getPlayers()[1].getX(), game.getPlayers()[1].getY());
                                    if (game.getBoard().isSquareEmpty(game.getPlayers()[1].getX(), game.getPlayers()[1].getY())) {
                                        view.getBtnBoardSquares()[game.getPlayers()[1].getX()][game.getPlayers()[1].getY()].setText("O");
                                        view.getBtnBoardSquares()[game.getPlayers()[1].getX()][game.getPlayers()[1].getY()].setDisable(true);
                                    }
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
                exit();
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
                StartUpView startUpView = new StartUpView();
                StartUpPresenter startUpPresenter = new StartUpPresenter(game, startUpView);
                Scene scene = view.getScene();
                scene.setRoot(startUpView);
                scene.getWindow().setHeight(view.getHeight() + 37); //grootte van het venster blijft hetzelfde
                scene.getWindow().setWidth(view.getWidth() + 14);
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

    public void disableBoard() {
        for (int i = 0; i < game.getBoardSize(); i++) {
            for (int j = 0; j < game.getBoardSize(); j++) {
                view.getBtnBoardSquares()[i][j].setDisable(true);
            }
        }
    }
}
