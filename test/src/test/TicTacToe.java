package test;

import javafx.application.Application;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView(model);
        TicTacToePresenter presenter = new TicTacToePresenter(model, view);
        presenter.show(primaryStage);
    }
}