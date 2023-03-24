package be.kdg.arno.enrico.tictactoe.domain;

import be.kdg.arno.enrico.tictactoe.domain.model.TicTacToe;
import be.kdg.arno.enrico.tictactoe.domain.view.StartUpPresenter;
import be.kdg.arno.enrico.tictactoe.domain.view.StartUpView;
import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * This class starts the application.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Set the board size to a standard of 3.
        UIConstants.setBoardSize(3);
        //Create startupview, presenter and model.
        TicTacToe game = new TicTacToe(3);
        StartUpView startupView = new StartUpView();
        StartUpPresenter presenter = new StartUpPresenter(game, startupView);
        Scene startupScene = new Scene(startupView);
        startupScene.getStylesheets().add(0, "/application.css");
        stage.getIcons().add(new Image(new FileInputStream("BoterKaasEieren/resources/images/application_logo.png")));
        stage.setScene(startupScene);
        stage.setTitle("Tic Tac Toe");
        stage.setMinHeight(620);
        stage.setMinWidth(850);
        stage.setHeight(620);
        stage.setWidth(850);
        stage.show();
    }
}
