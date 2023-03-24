package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.GameRecord;
import be.kdg.arno.enrico.tictactoe.domain.model.PlayedGames;
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
 * This class is the view for the played games window.
 * This is the window that gets opened as soon as the Played Games button inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class PlayedGamesView extends BorderPane {
    //Properties.
    private TableView<GameRecord> pgTable;
    private PlayedGames playedGames = new PlayedGames();
    private ImageView ivBack;
    private Button btnBack;
    private Button btnReset;

    //Constructor.
    public PlayedGamesView() {
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

        btnReset = new Button("Reset");

        pgTable = new TableView<>();

        ObservableList<GameRecord> gameRecords = FXCollections.observableArrayList();
        //Load the playedgames.csv file into the TableView
        List<String> lines = playedGames.load();
        int j = 0;
        for (int i = 0; i < lines.size(); i += 5) {
            String date = playedGames.loadDate()[j];
            String nameX = playedGames.loadNameX()[j];
            String nameO = playedGames.loadNameO()[j];
            String boardSize = playedGames.loadBoardSize()[j];
            String result = playedGames.loadResults()[j];
            j++;

            GameRecord gameRecord = new GameRecord(date, nameX, nameO, boardSize, result);
            gameRecords.add(gameRecord);
        }

        TableColumn<GameRecord, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.prefWidthProperty().bind(pgTable.widthProperty().multiply(0.2)); //set the preferred width to a 20% of the current window size
        dateColumn.setResizable(false);
        dateColumn.setReorderable(false);

        TableColumn<GameRecord, String> nameXColumn = new TableColumn<>("Player X");
        nameXColumn.setCellValueFactory(new PropertyValueFactory<>("nameX"));
        nameXColumn.prefWidthProperty().bind(pgTable.widthProperty().multiply(0.2)); //set the preferred width to a 20% of the current window size
        nameXColumn.setResizable(false);
        nameXColumn.setReorderable(false);

        TableColumn<GameRecord, String> nameOColumn = new TableColumn<>("Player O");
        nameOColumn.setCellValueFactory(new PropertyValueFactory<>("nameO"));
        nameOColumn.prefWidthProperty().bind(pgTable.widthProperty().multiply(0.2)); //set the preferred width to a 20% of the current window size
        nameOColumn.setResizable(false);
        nameOColumn.setReorderable(false);

        TableColumn<GameRecord, String> boardSizeColumn = new TableColumn<>("Board Size");
        boardSizeColumn.setCellValueFactory(new PropertyValueFactory<>("boardSize"));
        boardSizeColumn.prefWidthProperty().bind(pgTable.widthProperty().multiply(0.2)); //set the preferred width to a 20% of the current window size
        boardSizeColumn.setResizable(false);
        boardSizeColumn.setReorderable(false);

        TableColumn<GameRecord, String> resultColumn = new TableColumn<>("Result");
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        resultColumn.prefWidthProperty().bind(pgTable.widthProperty().multiply(0.2)); //set the preferred width to a 20% of the current window size
        resultColumn.setResizable(false);
        resultColumn.setReorderable(false);

        pgTable.getColumns().addAll(dateColumn, nameXColumn, nameOColumn, boardSizeColumn, resultColumn);
        pgTable.setItems(gameRecords);

    }//initialiseNodes.

    private void layoutNodes() {
        this.setStyle("-fx-background-color: linear-gradient(to right, #fdea16, #fd60e9)");
        this.setCenter(pgTable);

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

    TableView<GameRecord> getPgTable() {
        return pgTable;
    }
}
