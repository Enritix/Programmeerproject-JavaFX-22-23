package be.kdg.arno.enrico.tictactoe.domain;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import be.kdg.arno.enrico.tictactoe.domain.view.StartUpPresenter;
import be.kdg.arno.enrico.tictactoe.domain.view.StartUpView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        TicTacToe game = new TicTacToe(3);
        StartUpView startupView = new StartUpView();
        StartUpPresenter presenter = new StartUpPresenter(game, startupView);
        Scene startupScene = new Scene(startupView);
        stage.getIcons().add(new Image(new FileInputStream("resources/images/bke_logo.png")));
        stage.setScene(startupScene);
        stage.setTitle("Boter, kaas & eieren");
        stage.setMinHeight(550);
        stage.setMinWidth(850);
        stage.show();





/*
        GameView view = new GameView();
        Scene scene = new Scene(view);
        stage.getIcons().add(new Image(new FileInputStream("resources/images/bke_logo.png")));
        stage.setScene(scene);
        stage.setTitle("Boter, kaas & eieren");
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.show();
*/

    }
}
