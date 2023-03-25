package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.Leaderboard;
import be.kdg.arno.enrico.tictactoe.domain.model.Scores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * This class is the view for the leaderboard window.
 * This is the window that gets opened as soon as the Leaderboard box inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class LeaderboardView extends BorderPane {
    //Properties.
    private TableView<Scores> lbTable;
    private Leaderboard leaderboard = new Leaderboard();
    private ImageView ivBack;
    private Button btnBack;
    private Button btnReset;

    //Constructor.
    public LeaderboardView() {
        initialiseNodes();
        layoutNodes();
    }
    //Methods.
    private void initialiseNodes() {
        try {
            ivBack = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/arrow_back.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivBack.setFitHeight(UIConstants.BUTTON_PREFHEIGHT);
        ivBack.setFitWidth(UIConstants.BUTTON_PREFWIDTH);

        btnBack = new Button("", ivBack);
        btnBack.setStyle("-fx-background-color: transparent");

        btnReset = new Button("Reset scores");

        lbTable = new TableView<>();

        ObservableList<Scores> scoreRecords = FXCollections.observableArrayList();
        List<String> lines = leaderboard.read();
        int j = 0;
        for (int i = 0; i < lines.size(); i+=2) {
            String name = leaderboard.readNames().get(j);
            int score = Integer.parseInt(leaderboard.readScores().get(j));
            j++;

            Scores scoreRecord = new Scores(name,score);
            scoreRecords.add(scoreRecord);
        }
        TableColumn<Scores, String> nameColumn = new TableColumn<>("Names");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(lbTable.widthProperty().multiply(0.5)); //set the preferred width to a 20% of the current window size
        nameColumn.setResizable(false);
        nameColumn.setReorderable(false);
        TableColumn<Scores, String> scoreColumn = new TableColumn<>("Scores");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("scores"));
        scoreColumn.prefWidthProperty().bind(lbTable.widthProperty().multiply(0.5)); //set the preferred width to a 20% of the current window size
        scoreColumn.setResizable(false);
        scoreColumn.setReorderable(false);

        lbTable.getColumns().addAll(nameColumn, scoreColumn);

        lbTable.setItems(scoreRecords);
    }//initialiseNodes.

    private void layoutNodes() {
        this.setStyle("-fx-background-color: linear-gradient(to right, #fdea16, #fd60e9)");
        this.setCenter(lbTable);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setSpacing(10);

        HBox leftBox = new HBox();
        HBox.setHgrow(leftBox, Priority.ALWAYS);
        btnBack.setMaxWidth(Double.MAX_VALUE);
        btnBack.setStyle("-fx-background-color: transparent");
        btnReset.setMaxWidth(Double.MAX_VALUE);

        HBox rightBox = new HBox();
        rightBox.getChildren().add(btnReset);
        HBox.setHgrow(rightBox, Priority.ALWAYS);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(btnReset, new Insets(0, 10, 0, 10));

        leftBox.getChildren().add(btnBack);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().addAll(leftBox, rightBox);
        this.setBottom(buttonBox);
        BorderPane.setMargin(buttonBox, new Insets(10));
    }//layoutNodes.

    //Getters.
    Button getBtnBack() {
        return btnBack;
    }

    Button getBtnReset() {
        return btnReset;
    }

    TableView<Scores> getLbTable() {
        return lbTable;
    }
}
