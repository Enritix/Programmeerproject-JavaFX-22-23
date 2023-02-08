package test;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

class TicTacToeView {
    private TicTacToeModel model;
    private GridPane grid = new GridPane();

    public TicTacToeView(TicTacToeModel model) {
        this.model = model;
        createGrid();
    }

    private void createGrid() {
        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                Button btn = new Button();
                grid.add(btn, i, j);
            }
        }
    }

    public GridPane getGrid() {
        return grid;
    }
}