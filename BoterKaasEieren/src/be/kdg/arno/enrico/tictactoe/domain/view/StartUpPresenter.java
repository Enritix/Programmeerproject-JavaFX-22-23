package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class StartUpPresenter {
    private TicTacToe game;
    private StartUpView view;
    private Scanner sc;
    private DropShadow dropShadow;

    public StartUpPresenter(TicTacToe game, StartUpView view) {
        this.game = game;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnPlay1v1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sc = new Scanner(System.in);
                System.out.print("Player one (X), give your name: ");
                String player1 = sc.next();
                System.out.print("Player two (O), give your name: ");
                String player2 = sc.next();
                System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);
                game.initialisePlayers("lblPlayer2", player1, player2);
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(game, gameView);
                Scene scene = view.getScene();
                scene.setRoot(gameView);
                scene.getWindow().setHeight(500);
                scene.getWindow().setHeight(500);
            }
        });
        view.getBtnPlay1v1().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.BLACK);
                dropShadow.setBlurType(BlurType.GAUSSIAN);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(2);
                view.getBtnPlay1v1().setEffect(dropShadow);
            }
        });
        view.getBtnPlay1v1().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.TRANSPARENT);
                view.getBtnPlay1v1().setEffect(dropShadow);
            }
        });
        view.getBtnPlayComputer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sc = new Scanner(System.in);
                System.out.print("Player one (X), give your name: ");
                String player1 = sc.next();
                game.initialisePlayers("1p", player1, "Computer");
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(game, gameView);
                Scene scene = view.getScene();
                scene.setRoot(gameView);
                scene.getWindow().setHeight(500);
                scene.getWindow().setHeight(500);
            }
        });
        view.getBtnPlayComputer().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.BLACK);
                dropShadow.setBlurType(BlurType.GAUSSIAN);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(2);
                view.getBtnPlayComputer().setEffect(dropShadow);
            }
        });
        view.getBtnPlayComputer().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.TRANSPARENT);
                view.getBtnPlayComputer().setEffect(dropShadow);
            }
        });

        view.getBtnRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RulesView rulesView = new RulesView();
                RulesPresenter rulesPresenter = new RulesPresenter();
                Scene scene = view.getScene();
                scene.setRoot(rulesView);
                scene.getWindow().setHeight(500);
                scene.getWindow().setHeight(500);
            }
        });
        view.getBtnRules().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.BLACK);
                dropShadow.setBlurType(BlurType.GAUSSIAN);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(2);
                view.getBtnRules().setEffect(dropShadow);
            }
        });
        view.getBtnRules().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.TRANSPARENT);
                view.getBtnRules().setEffect(dropShadow);
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
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.BLACK);
                dropShadow.setBlurType(BlurType.GAUSSIAN);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(2);
                view.getBtnExit().setEffect(dropShadow);
            }
        });
        view.getBtnExit().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.TRANSPARENT);
                view.getBtnExit().setEffect(dropShadow);
            }
        });
    }
}
