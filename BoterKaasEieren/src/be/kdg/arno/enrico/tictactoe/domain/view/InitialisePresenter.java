package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class InitialisePresenter {
    private InitialiseView view;
    private TicTacToe game;
    private boolean name1 = false;
    private boolean name2 = false;

    public InitialisePresenter(TicTacToe game, InitialiseView view) {
        this.view = view;
        this.game = game;
        addEventhandlers();
    }


    private void addEventhandlers() {
        view.getTfNameP1().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String text = view.getTfNameP1().getText();
                if (text.length() < 2 || !"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-".contains(keyEvent.getCharacter())) {
                    view.getTfNameP1().setStyle(" -fx-border-color: red");
                    name1 = true;
                } else {
                    view.getTfNameP1().setStyle(" -fx-border-color: transparent");
                    name1 = false;
                }
            }
        });
        view.getTfNameP2().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String text = view.getTfNameP2().getText();
                if (text.length() < 2 || !"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-".contains(keyEvent.getCharacter())) {
                    view.getTfNameP2().setStyle(" -fx-border-color: red");
                    name2 = true;
                } else {
                    view.getTfNameP2().setStyle(" -fx-border-color: transparent");
                    name2 = false;
                }
            }
        });
        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartUpView startUpView = new StartUpView();
                StartUpPresenter startUpPresenter = new StartUpPresenter(game, startUpView);
                Scene scene = view.getScene();
                scene.setRoot(startUpView);
                scene.getWindow().setHeight(view.getHeight() + 37);
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

        view.getBtnPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*game.reset();*/
                if (!name1 && !name2) {
                    String player1 = view.getTfNameP1().getText();
                    String player2 = view.getTfNameP2().getText();
                    if (!player1.isEmpty() && !player2.isEmpty()) {
                        setBoardSize();
                        game.createBoard();
                        game.initialisePlayers("2p", view.getTfNameP1().getText(), view.getTfNameP2().getText());
                        GameView gameView = new GameView();
                        GamePresenter gamePresenter = new GamePresenter(game, gameView);
                        Scene scene = view.getScene();
                        /*scene.getStylesheets().add(0, "/application.css");*/
                        scene.setRoot(gameView);
                        scene.getWindow().setHeight(view.getHeight() + 37);
                        scene.getWindow().setWidth(view.getWidth() + 14);
                    } else {
                        showMessage();
                    }
                } else {
                    showMessage();
                }
            }
        });

        view.getBtnPlay().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlay().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnPlay().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlay().setEffect(null);
            }
        });
    }

    public void showMessage() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        if (name1 && name2) {
            alert.setContentText("Both the names of the players aren't correct.\nThe names cant't contain any numbers or special characters and need to be" +
                    "longer than 1 character!");
        } else if (name1) {
            alert.setContentText("The name of player X isn't correct.\nThe name cant't contain any numbers or special characters and needs to be" +
                    "longer than 1 character!");
        } else if (name2) {
            alert.setContentText("The name of player O isn't correct.\nThe name cant't contain any numbers or special characters and need to be" +
                    "longer than 1 character!");
        } else {
            alert.setContentText("You need to fill in all the boxes!");
        }
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();
    }

    public void setBoardSize() {
        if (view.getCbDifficulty().getValue().equals("Easy: 3x3 - 3 in a row")) {
            game.setSize(3);
        } else if (view.getCbDifficulty().getValue().equals("Medium: 5x5 - 4 in a row")){
            game.setSize(5);
        } else {
            game.setSize(7);
        }
    }
}
