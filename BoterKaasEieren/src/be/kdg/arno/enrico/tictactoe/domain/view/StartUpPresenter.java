package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import java.util.Scanner;

public class StartUpPresenter {
    private TicTacToe game;
    private StartUpView view;
    private Scanner sc;

    public StartUpPresenter(TicTacToe game, StartUpView view) {
        this.game = game;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getPlay1v1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(game, gameView);
                Scene scene = view.getScene();
                sc = new Scanner(System.in);
                System.out.print("Player one (X), give your name: ");
                String player1 = sc.next();
                System.out.print("Player two (O), give your name: ");
                String player2 = sc.next();
                System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);
                game.initialisePlayers("p2", player1, player2);
                scene.setRoot(gameView);
                scene.getWindow().setHeight(500);
                scene.getWindow().setHeight(500);
            }
        });
        view.getPlayComputer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(game, gameView);
                Scene scene = view.getScene();
                sc = new Scanner(System.in);
                System.out.print("Player one (X), give your name: ");
                String player1 = sc.next();
                game.initialisePlayers("p1", player1, "Computer");
                scene.setRoot(gameView);
                scene.getWindow().setHeight(500);
                scene.getWindow().setHeight(500);
            }
        });
    }
}
