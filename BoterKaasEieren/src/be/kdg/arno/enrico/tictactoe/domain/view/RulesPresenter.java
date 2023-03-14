package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RulesPresenter {
    private RulesView view;
    private DropShadow dropShadow;
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
                StartUpPresenter startUpPresenter = new StartUpPresenter(game, startUpView);
                Scene scene = view.getScene();
                scene.setRoot(startUpView);
                scene.getWindow().setHeight(view.getHeight()/*+37*/); //grootte van het venster blijft hetzelfde
                scene.getWindow().setWidth(view.getWidth()/*+14*/);
            }
        });
        view.getBtnBack().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.BLACK);
                dropShadow.setBlurType(BlurType.GAUSSIAN);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(2);
                view.getBtnBack().setEffect(dropShadow);
            }
        });
        view.getBtnBack().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dropShadow = new DropShadow();
                dropShadow.setColor(Color.TRANSPARENT);
                view.getBtnBack().setEffect(dropShadow);
            }
        });
    }


}