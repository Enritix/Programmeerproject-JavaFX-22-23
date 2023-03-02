package be.kdg.arno.enrico.boterkaaseieren.domain.view;


import be.kdg.arno.enrico.boterkaaseieren.domain.model.BoterKaasEieren;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class GamePresenter {
    private GameView view;
    private BoterKaasEieren game = new BoterKaasEieren(3);
    private boolean doingMove = false;
    private String playerXorO = game.getCurrentPlayer();

    public GamePresenter(BoterKaasEieren game, GameView view) {
        this.view = view;
        this.game = game;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.clearPlayers();
                game.clearBoard();
                System.out.println("Board and players cleared...");
            }
        });

        for (int i = 0; i < game.getBoardSize(); i++) {
            for (int j = 0; j < game.getBoardSize(); j++) {
                final int row = i;
                final int col = j;

                view.getBtnBoardSquares()[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        /*Scanner sc = new Scanner(System.in);
                        System.out.print("Player one (O), give your name: ");
                        String player1 = sc.next();
                        System.out.print("Player two (X), give your name: ");
                        String player2 = sc.next();
                        System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);*/
                        game.clearPlayers();
                        game.twoPlayers();
                        game.playGame();
                        view.getBtnBoardSquares()[row][col].setText(playerXorO);
                        game.addPieceOnBoard(game.getCurrentPlayer(), row, col);
                        if (!doingMove) {
                            doingMove = true;
                        } else {
                            view.getBtnBoardSquares()[col][row].setDisable(false);
                        }
                    }
                });
                view.getBtnQuit().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        exit();
                    }
                });

            }
        }
    }
}
