package test;

import javafx.stage.Stage;
import javafx.scene.Scene;

class TicTacToePresenter {
    private TicTacToeModel model;
    private TicTacToeView view;

    public TicTacToePresenter(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
    }

    public void show(Stage stage) {
        Scene scene = new Scene(view.getGrid(), 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}