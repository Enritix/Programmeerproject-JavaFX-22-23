package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * This class is the presenter for the rules window.
 * This is the window that gets opened as soon as the Rules button inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class RulesPresenter {
    //Properties.
    private RulesView view;
    private TicTacToe game;

    //Constructor.
    public RulesPresenter(TicTacToe game, RulesView view) {
        this.game = game;
        this.view = view;
        addEventHandlers();
    }

    public void addEventHandlers() {
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
    }//addEventHandlers
}