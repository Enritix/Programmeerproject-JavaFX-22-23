package be.kdg.arno.enrico.boterkaaseieren.domain.view;


import be.kdg.arno.enrico.boterkaaseieren.domain.model.BoterKaasEieren;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class GamePresenter {
    private GameView view;
    private BoterKaasEieren game;
    private boolean doingMove = false;

    public GamePresenter(BoterKaasEieren game, GameView view) {
        this.view = view;
        this.game = game;
        addEventHandlers();
    }

    private void addEventHandlers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player one (X), give your name: ");
        String player1 = sc.next();
        System.out.print("Player two (O), give your name: ");
        String player2 = sc.next();
        System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);
        game.twoPlayers(player1, player2);
        view.getLblPlayer1().setText(game.getPlayers()[0].getName());
        view.getLblPlayer2().setText(game.getPlayers()[1].getName());


        view.getBtnNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (int i = 0; i < game.getBoardSize(); i++) {
                    for (int j = 0; j < game.getBoardSize(); j++) {
                        game.clearPlayers();
                        view.getBtnBoardSquares()[i][j].setText("");
                        game.clearBoard();
                        view.getBtnBoardSquares()[i][j].setDisable(false);
                        System.out.println("Board and players cleared...");
                        System.out.println(game.getBoard().toString());
                    }
                }
            }

        });

        for (int i = 0; i < game.getBoardSize(); i++) {
            for (int j = 0; j < game.getBoardSize(); j++) {
                final int row = i;
                final int col = j;

                view.getBtnBoardSquares()[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                            game.playGame();
                            String playerXorO = game.getCurrentPlayer().getPlayer();
                            view.getBtnBoardSquares()[row][col].setText(playerXorO);
                            game.addPieceOnBoard(row, col);
                            view.getBtnBoardSquares()[row][col].setDisable(true);
                            updateView();
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
