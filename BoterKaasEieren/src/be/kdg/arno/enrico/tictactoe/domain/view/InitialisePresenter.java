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

/**
 * This class is the presenter for the play 1 vs 1 window.
 * This is the window that gets opened as soon as the Play 1 VS 1 button inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class InitialisePresenter {
    //Properties.
    private InitialiseView view;
    private TicTacToe game;
    private boolean name1 = false;
    private boolean name2 = false;
    private boolean custom = false;
    private int editClickCounter = 0;
    private int editClickCounter2 = 0;

    //Constructor.
    public InitialisePresenter(TicTacToe game, InitialiseView view) {
        this.view = view;
        this.game = game;
        addEventhandlers();
        if (view.getCbDifficulty().getValue().equals("Custom")) {
            view.setCustom(true);
        }
    }

    //Methods.
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
                game.reset();
                if (!name1 && !name2 && !custom) {
                    String player1 = view.getTfNameP1().getText();
                    String player2 = view.getTfNameP2().getText();
                    String customSize = view.getTfCustom().getText();
                    if ((view.getHbCustom().isVisible() && !customSize.equals("") && !player1.isEmpty() && !player2.isEmpty() || !player1.isEmpty() && !player2.isEmpty() && !view.getHbCustom().isVisible())
                    || view.getCbNamesP1().isVisible() || view.getCbNamesP2().isVisible()) {
                        setBoardSize();
                        game.createBoard();
                        if (view.getCbNamesP1().isVisible() && view.getCbNamesP2().isVisible()) {
                            String comboNameX = view.getCbNamesP1().getValue().substring(0, 1).toUpperCase() + view.getCbNamesP1().getValue().substring(1).toLowerCase();
                            String comboNameO = view.getCbNamesP2().getValue().substring(0, 1).toUpperCase() + view.getCbNamesP2().getValue().substring(1).toLowerCase();
                            game.initialisePlayers("2p", comboNameX, comboNameO);
                        } else if (view.getCbNamesP1().isVisible() && !view.getCbNamesP2().isVisible()) {
                            String comboNameX = view.getCbNamesP1().getValue().substring(0, 1).toUpperCase() + view.getCbNamesP1().getValue().substring(1).toLowerCase();
                            game.initialisePlayers("2p", comboNameX, view.getTfNameP2().getText());
                        } else if (!view.getCbNamesP1().isVisible() && view.getCbNamesP2().isVisible()) {
                            String comboNameO = view.getCbNamesP2().getValue().substring(0, 1).toUpperCase() + view.getCbNamesP2().getValue().substring(1).toLowerCase();
                            game.initialisePlayers("2p", view.getTfNameP1().getText(), comboNameO);
                        } else {
                            game.initialisePlayers("2p", view.getTfNameP1().getText(), view.getTfNameP2().getText());
                        }
                        GameView gameView = new GameView();
                        GamePresenter gamePresenter = new GamePresenter(game, gameView);
                        Scene scene = view.getScene();
                        scene.setRoot(gameView);
                        scene.getWindow().setHeight(view.getHeight() + 37);
                        scene.getWindow().setWidth(view.getWidth() + 14);
                    }
                    else if ((player1.isEmpty() && customSize.equals("") || player2.isEmpty() && customSize.equals("")
                            || player1.isEmpty() && !player2.isEmpty() && !customSize.equals("") || !player1.isEmpty() && player2.isEmpty() && !customSize.equals("")
                            || player1.isEmpty() && player2.isEmpty() && customSize.equals("") || customSize.equals("")) && view.getHbCustom().isVisible())
                        showMessage();
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

        view.getCbDifficulty().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (view.getCbDifficulty().getValue().equals("Custom")) {
                    view.setCustom(true);
                } else {
                    view.setCustom(false);
                }
            }
        });

        view.getTfCustom().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String text = view.getTfCustom().getText();
                if (text.length() > 1 || !"45678".contains(keyEvent.getCharacter())) {
                    view.getTfCustom().setStyle(" -fx-border-color: red");
                    custom = true;
                } else {
                    view.getTfCustom().setStyle(" -fx-border-color: transparent");
                    custom = false;
                }
            }
        });

        view.getLblNameP1().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getTtName().show(view.getLblNameP1(), mouseEvent.getScreenX(), mouseEvent.getScreenY() + 10);
            }
        });

        view.getLblNameP1().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getTtName().hide();
            }
        });

        view.getLblNameP2().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getTtName().show(view.getLblNameP2(), mouseEvent.getScreenX(), mouseEvent.getScreenY() + 10);
            }
        });

        view.getLblNameP2().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getTtName().hide();
            }
        });

        view.getLblCustom().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getTtCustom().show(view.getLblCustom(), mouseEvent.getScreenX(), mouseEvent.getScreenY() + 10);
            }
        });

        view.getLblCustom().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getTtCustom().hide();
            }
        });

        view.getBtnEdit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (editClickCounter % 2 == 0) {
                    editClickCounter++;
                    view.showPlayerList("p1", "combo");
                } else {
                    editClickCounter++;
                    view.showPlayerList("p1", "text");
                }
            }
        });

        view.getBtnEdit().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnEdit().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnEdit().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnEdit().setEffect(null);
            }
        });

        view.getBtnEdit2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (editClickCounter2 % 2 == 0) {
                    editClickCounter2++;
                    view.showPlayerList("p2", "combo");
                } else {
                    editClickCounter2++;
                    view.showPlayerList("p2", "text");
                }
            }
        });

        view.getBtnEdit2().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnEdit2().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnEdit2().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnEdit2().setEffect(null);
            }
        });
    }//addEventHandlers.

    //Methods.
    public void showMessage() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        if (name1 && name2 && custom) {
            alert.setContentText("The names of the players and the custom size aren't correct.\nThe names can't contain any numbers or special characters\n" +
                    "and need to be longer than 1 character!\nFor the custom size, check the tooltip for the usage!");
        } else if (name1 && name2) {
            alert.setContentText("Both the names of the players aren't correct.\nThe names can't contain any numbers or special characters\n" +
                    "and need to be longer than 1 character!");
        } else if (name1) {
            alert.setContentText("The name of player X isn't correct.\nThe name can't contain any numbers or special characters\n" +
                    "and needs to be longer than 1 character!");
        } else if (name2) {
            alert.setContentText("The name of player O isn't correct.\nThe name can't contain any numbers or special characters\n" +
                    "and need to be longer than 1 character!");
        } else if (custom) {
            alert.setContentText("The custom size isn't correct.\nCheck the tooltip for the usage!");
        } else {
            alert.setContentText("You need to fill in all the boxes!");
        }
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();
    }//showMessage.

    public void setBoardSize() {
        if (view.getCbDifficulty().getValue().equals("Easy: 3x3 - 3 in a row")) {
            game.setSize(3);
        } else if (view.getCbDifficulty().getValue().equals("Medium: 5x5 - 4 in a row")) {
            game.setSize(5);
        } else if (view.getCbDifficulty().getValue().equals("Hard: 7x7 - 4 in a row")) {
            game.setSize(7);
        } else {
            game.setSize(Integer.parseInt(view.getTfCustom().getText()));
        }
    }//setBoardSize.
}
