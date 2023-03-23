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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class PlayedGamesView extends BorderPane {
    private TableView<GameRecord> pgTable;
    private PlayedGames playedGames = new PlayedGames();
    private ImageView ivBack;
    private Button btnBack;


    public PlayedGamesView() {
        initialiseNodes();
        layoutNodes();
    }

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

        pgTable = new TableView<>();

        ObservableList<GameRecord> gameRecords = FXCollections.observableArrayList();
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

    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: linear-gradient(to right, #fdea16, #fd60e9)");
        this.setCenter(pgTable);
        HBox hbBackBox = new HBox();
        hbBackBox.setAlignment(Pos.BOTTOM_LEFT);
        hbBackBox.getChildren().addAll(btnBack);
        hbBackBox.setMaxHeight(10);
        hbBackBox.setStyle("-fx-background-color: transparent");
        this.setBottom(hbBackBox);
        BorderPane.setMargin(hbBackBox, new Insets(10));
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public ImageView getIvBack() {
        return ivBack;
    }
}
