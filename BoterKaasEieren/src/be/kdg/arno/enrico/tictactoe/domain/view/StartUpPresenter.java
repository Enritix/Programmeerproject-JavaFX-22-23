package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Optional;

import static javafx.application.Platform.exit;

public class StartUpPresenter {
    private TicTacToe game;
    private StartUpView view;

    public StartUpPresenter(TicTacToe game, StartUpView view) {
        this.game = game;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnPlay1v1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*sc = new Scanner(System.in);
                System.out.print("Player one (X), give your name: ");
                String player1 = sc.next();
                System.out.print("Player two (O), give your name: ");
                String player2 = sc.next();
                System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);*/
                String player1 = showMessage(0);
                String player2 = showMessage(1);
                if (player1 != null && player2 != null) {
                    game.initialisePlayers("2p", player1, player2);
                    GameView gameView = new GameView();
                    GamePresenter gamePresenter = new GamePresenter(game, gameView);
                    Scene scene = view.getScene();
                    scene.setRoot(gameView);
                    scene.getWindow().setHeight(view.getHeight());
                    scene.getWindow().setWidth(view.getWidth());
                }
            }
        });
        view.getBtnPlay1v1().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlay1v1().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });
        view.getBtnPlay1v1().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlay1v1().setEffect(null);
            }
        });
        view.getBtnPlayComputer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String player1 = showMessage(0);
                game.initialisePlayers("1p", player1, "Computer");
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(game, gameView);
                Scene scene = view.getScene();
                scene.setRoot(gameView);
                scene.getWindow().setHeight(view.getHeight());
                scene.getWindow().setWidth(view.getWidth());
            }
        });
        view.getBtnPlayComputer().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlayComputer().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });
        view.getBtnPlayComputer().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlayComputer().setEffect(null);
            }
        });

        view.getBtnRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RulesView rulesView = new RulesView();
                RulesPresenter rulesPresenter = new RulesPresenter(game, rulesView);
                Scene scene = view.getScene();
                scene.setRoot(rulesView);
                scene.getWindow().setHeight(view.getHeight()+37);
                scene.getWindow().setWidth(view.getWidth()+14);
            }
        });
        view.getBtnRules().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnRules().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });
        view.getBtnRules().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnRules().setEffect(null);
            }
        });

        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exit();
            }
        });
        view.getBtnExit().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnExit().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });
        view.getBtnExit().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnExit().setEffect(null);
            }
        });
    }
    public String showMessage(int player) {
        //TODO: beter maken
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText(null);
        dialog.setContentText("Name of player " + (player == 0 ? "X" : "O") + ": ");

        Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dialog.close();
            }
        });

        Optional<String> result;
        do {
            result = dialog.showAndWait();
            if (result.isPresent()) {
                String name = result.get().trim();
                if (!name.isEmpty()) {
                    player++;
                    return name;
                } else {
                    Alert alert = new Alert(
                            Alert.AlertType.WARNING,
                            "Invalid name",
                            ButtonType.OK
                    );
                    alert.setHeaderText("Invalid Name");
                    alert.setContentText("Please enter a valid name.");
                    alert.showAndWait();
                }
            }
        } while (result.isPresent());

        // If the result is not present, the dialog was closed without a name being entered.
        return null;
    }
}