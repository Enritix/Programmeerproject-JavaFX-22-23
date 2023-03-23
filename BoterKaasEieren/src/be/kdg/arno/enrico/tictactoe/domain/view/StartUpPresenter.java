package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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
                /*UIConstants.setBoardSize(3);*/
                game.reset();
                InitialiseView initialiseView = new InitialiseView();
                InitialisePresenter initialisePresenter = new InitialisePresenter(game, initialiseView);
                Scene scene = view.getScene();
                scene.getStylesheets().add(0, "/application.css");
                scene.setRoot(initialiseView);
                scene.getWindow().setHeight(view.getHeight() + 37);
                scene.getWindow().setWidth(view.getWidth() + 14);
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
                /*UIConstants.setBoardSize(3);*/
                game.reset();
                InitialiseComputerView initialiseComputerView = new InitialiseComputerView();
                InitialiseComputerPresenter initialiseComputerPresenter = new InitialiseComputerPresenter(game, initialiseComputerView);
                Scene scene = view.getScene();
                scene.getStylesheets().add(0, "/application.css");
                scene.setRoot(initialiseComputerView);
                scene.getWindow().setHeight(view.getHeight() + 37);
                scene.getWindow().setWidth(view.getWidth() + 14);
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
        view.getBtnPlayedGames().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*UIConstants.setBoardSize(3);*/
                game.reset();
                PlayedGamesView playedGamesView = new PlayedGamesView();
                PlayedGamesPresenter playedGamesPresenter = new PlayedGamesPresenter(game, playedGamesView);
                Scene scene = view.getScene();
                scene.getStylesheets().add(0, "/application.css");
                scene.setRoot(playedGamesView);
                scene.getWindow().setHeight(view.getHeight() + 37);
                scene.getWindow().setWidth(view.getWidth() + 14);
            }
        });
        view.getBtnPlayedGames().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlayedGames().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });
        view.getBtnPlayedGames().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnPlayedGames().setEffect(null);
            }
        });

        view.getBtnRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RulesView rulesView = new RulesView();
                RulesPresenter rulesPresenter = new RulesPresenter(game, rulesView);
                Scene scene = view.getScene();
                scene.setRoot(rulesView);
                scene.getWindow().setHeight(view.getHeight() + 37);
                scene.getWindow().setWidth(view.getWidth() + 14);
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
}