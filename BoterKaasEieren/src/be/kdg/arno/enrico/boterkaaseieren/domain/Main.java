package be.kdg.arno.enrico.boterkaaseieren.domain;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.BoterKaasEieren;
import be.kdg.arno.enrico.boterkaaseieren.domain.view.GamePresenter;
import be.kdg.arno.enrico.boterkaaseieren.domain.view.GameView;
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
        BoterKaasEieren game = new BoterKaasEieren(3);
        GameView view = new GameView();
        GamePresenter presenter = new GamePresenter(game, view);
        Scene scene = new Scene(view);
        stage.getIcons().add(new Image(new FileInputStream("resources/images/bke_logo.png")));
        stage.setScene(scene);
        stage.setTitle("Boter, kaas & eieren");
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.show();
    }
}
