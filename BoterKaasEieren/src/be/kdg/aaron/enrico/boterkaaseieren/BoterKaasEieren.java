package be.kdg.aaron.enrico.boterkaaseieren;

import javafx.application.Application;
import javafx.stage.Stage;

public class BoterKaasEieren extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setTitle("Boter, kaas & eieren");
        stage.show();
    }
}
