package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.Leaderboard;
import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Optional;

/**
 * This class is the presenter for the leaderboard window.
 * This is the window that gets opened as soon as the Leaderboard box inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class LeaderboardPresenter {
    //Properties.
    private LeaderboardView view;
    private TicTacToe game;
    private Leaderboard leaderboard;

    //Constructor.
    public LeaderboardPresenter(TicTacToe game, LeaderboardView view) {
        this.game = game;
        this.view = view;
        this.leaderboard = new Leaderboard();
        addEventHandlers();
    }

    //Methods.
    private void addEventHandlers() {
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

        view.getBtnReset().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Reset Scores");
                alert.setHeaderText("Are you sure you want to reset the scores?");
                alert.setContentText("This action cannot be undone.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    leaderboard.resetScores();
                    view.getLbTable().getItems().clear();
                    view.getLbTable().refresh();
                }
            }
        });

        view.getBtnReset().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnReset().setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
            }
        });

        view.getBtnReset().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getBtnReset().setEffect(null);
            }
        });
    }//addEventHandlers
}
