package be.kdg.arno.enrico.boterkaaseieren.domain;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.BKEApplication;
import be.kdg.arno.enrico.boterkaaseieren.domain.model.BoterKaasEieren;
import be.kdg.arno.enrico.boterkaaseieren.domain.view.BKEPresenter;
import be.kdg.arno.enrico.boterkaaseieren.domain.view.BKEView;
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
        BKEApplication application = new BKEApplication();
        BKEView view = new BKEView();
        BKEPresenter presenter = new BKEPresenter(application, view);
        Scene scene = new Scene(view);
        stage.getIcons().add(new Image(new FileInputStream("resources/images/bke_logo.png")));
        stage.setScene(scene);
        stage.setTitle("Boter, kaas & eieren");
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.show();
    }
}
