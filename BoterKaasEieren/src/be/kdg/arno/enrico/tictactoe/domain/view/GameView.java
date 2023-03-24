package be.kdg.arno.enrico.tictactoe.domain.view;


import be.kdg.arno.enrico.tictactoe.domain.model.Leaderboard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameView extends BorderPane {
    public static final int FONT_SIZE = 30;
    private Label lblPlayer1;
    private Label lblPlayer1Score;
    private Label lblPlayer2;
    private Label lblPlayer2Score;
    private Button[][] btnBoardSquares = new Button[UIConstants.boardSize][UIConstants.boardSize]; //new Button[Board.SIZE][Board.SIZE];
    private Button btnNewGame;
    private Button btnQuit;
    private Button btnBack;
    private ImageView ivBack;

    public GameView() {
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

        lblPlayer1 = new Label();
        lblPlayer1.setFont(Font.font("Verdana", FONT_SIZE));
        lblPlayer1.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //player 2 text colour

        lblPlayer1Score = new Label();
        lblPlayer1Score.setFont(Font.font("Verdana", FONT_SIZE));
        lblPlayer1Score.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px");

        lblPlayer2 = new Label();
        lblPlayer2.setFont(Font.font("Verdana", FONT_SIZE));
        lblPlayer2.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //player 2 text colour

        lblPlayer2Score = new Label();
        lblPlayer2Score.setFont(Font.font("Verdana", FONT_SIZE));
        lblPlayer2Score.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px");

        btnNewGame = new Button("New Game");
        btnNewGame.setFont(Font.font("Verdana", FONT_SIZE));

        btnNewGame.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //new game button text colour --> bold: -fx-font-weight: bold;
        btnQuit = new Button("Quit");
        btnQuit.setFont(Font.font("Verdana", FONT_SIZE));
        btnQuit.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //quit button text colour --> bold: -fx-font-weight: bold;
        for (int i = 0; i < UIConstants.boardSize; i++) {
            for (int j = 0; j < UIConstants.boardSize; j++) {
                btnBoardSquares[i][j] = new Button();
                btnBoardSquares[i][j].setMaxSize(UIConstants.BUTTON_MAXSIZE, UIConstants.BUTTON_MAXSIZE);
                btnBoardSquares[i][j].setMinSize(UIConstants.BUTTON_MINSIZE, UIConstants.BUTTON_MINSIZE);
                btnBoardSquares[i][j].setStyle("-fx-background-color: #032056; -fx-background-radius: 15px; -fx-text-fill: #68C8FF"); //board squares background
                btnBoardSquares[i][j].setFont(Font.font("Verdana", FONT_SIZE));
            }
        }
    }

        private void layoutNodes() {
            this.setBackground(Background.fill(new LinearGradient(
                    0, 0, 1, 1, true,                      //sizing
                    CycleMethod.NO_CYCLE,                  //cycling
                    new Stop(0, Color.web("#fdea16")),     //colors
                    new Stop(1, Color.web("#fd60e9"))))
            );
        GridPane gpBoard = new GridPane();
            for (int i = 0; i < UIConstants.boardSize; i++) {
                for (int j = 0; j < UIConstants.boardSize; j++) {
                    gpBoard.add(btnBoardSquares[i][j], i, j);
                    GridPane.setVgrow(btnBoardSquares[i][j], Priority.ALWAYS);
                    GridPane.setHgrow(btnBoardSquares[i][j], Priority.ALWAYS);
                }
            }
            gpBoard.setVgap(10);
            gpBoard.setHgap(10);
            this.setCenter(gpBoard);
            gpBoard.setMaxSize(300,300);
            gpBoard.setStyle(" -fx-background-color: transparent"); //board bg

            HBox hbTopLeft = new HBox(lblPlayer1, lblPlayer1Score);
            HBox hbTopRight = new HBox(lblPlayer2Score, lblPlayer2);
            hbTopLeft.setSpacing(20);
            hbTopRight.setSpacing(20);
            HBox hbTop = new HBox(hbTopLeft, hbTopRight);
            HBox.setHgrow(hbTop, Priority.ALWAYS);
            HBox.setHgrow(hbTopRight, Priority.ALWAYS);
            hbTopLeft.setAlignment(Pos.BOTTOM_LEFT);
            hbTopRight.setAlignment(Pos.BOTTOM_RIGHT);
            hbTop.setSpacing(20);
            lblPlayer1Score.setAlignment(Pos.BOTTOM_LEFT);
            lblPlayer1.setAlignment(Pos.BOTTOM_LEFT);
            lblPlayer2Score.setAlignment(Pos.BOTTOM_RIGHT);
            lblPlayer2.setAlignment(Pos.BOTTOM_RIGHT);
            this.setTop(hbTop);
            BorderPane.setMargin(gpBoard, new Insets(10));
            BorderPane.setMargin(hbTop, new Insets(10));
            this.setBottom(btnNewGame);
            BorderPane.setAlignment(btnNewGame, Pos.BOTTOM_LEFT);
            BorderPane.setMargin(btnNewGame, new Insets(10));


            HBox hbBottomLeft = new HBox(btnBack);
            hbBottomLeft.setAlignment(Pos.CENTER_LEFT);
            hbBottomLeft.setMaxWidth(UIConstants.BUTTON_PREFWIDTH*2);
            HBox.setHgrow(hbBottomLeft,Priority.ALWAYS);

            HBox hbBottomCenter = new HBox(btnNewGame, btnQuit);
            hbBottomCenter.setSpacing(20);
            hbBottomCenter.setAlignment(Pos.CENTER);
            hbBottomCenter.setPadding(new Insets(10));
            HBox.setHgrow(hbBottomCenter,Priority.SOMETIMES);
            BorderPane.setMargin(hbBottomCenter, new Insets(10));

            HBox hbBottomRight = new HBox();
            hbBottomRight.setAlignment(Pos.CENTER);
            hbBottomRight.setMaxWidth(UIConstants.BUTTON_PREFWIDTH*2);
            HBox.setHgrow(hbBottomRight,Priority.ALWAYS);

            HBox hbBottom = new HBox();
            hbBottom.getChildren().addAll(hbBottomLeft,hbBottomCenter,hbBottomRight);
            this.setBottom(hbBottom);

        }

    public Button[][] getBtnBoardSquares() {
        return btnBoardSquares;
    }

    public Button getBtnBack(){
        return btnBack;
    }

    public Button getBtnNewGame() {
        return btnNewGame;
    }

    public Button getBtnQuit() {
        return btnQuit;
    }

    public Label getLblPlayer1() {
        return lblPlayer1;
    }

    public Label getLblPlayer2() {
        return lblPlayer2;
    }

    public Label getLblPlayer1Score() {
        return lblPlayer1Score;
    }

    public Label getLblPlayer2Score() {
        return lblPlayer2Score;
    }

    public static void showMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        /*alert.setGraphic(new ImageView(new Image("/application_logo.png")));*/
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}


