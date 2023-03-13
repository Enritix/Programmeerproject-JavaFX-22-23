package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;

public class RulesPresenter {
    private RulesView view;
    private DropShadow dropshadow;
    private TicTacToe game;


    public RulesPresenter(TicTacToe game, RulesView view) {
        this.game = game;
        this.view = view;
        addEventHandlers();
    }

    public void addEventHandlers(){
        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartUpView startUpView = new StartUpView();
                Scene scene = view.getScene();
                scene.setRoot(startUpView);
                scene.getWindow().setHeight(550);
                scene.getWindow().setWidth(850);

            }
        });
    }


}
