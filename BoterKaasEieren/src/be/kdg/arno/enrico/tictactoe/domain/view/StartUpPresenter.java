package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class StartUpPresenter {
    private TicTacToe game;
    private StartUpView view;

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
                scene.setRoot(gameView);
                scene.getWindow().setHeight(500);
                scene.getWindow().setHeight(500);
            }
        });
    }
}
