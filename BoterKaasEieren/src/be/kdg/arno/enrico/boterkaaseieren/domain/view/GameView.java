package be.kdg.arno.enrico.boterkaaseieren.domain.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

public class GameView extends BorderPane {
    public static final int FONT_SIZE = 30;
    public static final int SIZE = 3;
    private Label lblPlayer1;
    private Label lblPlayer2;
    private Button[][] btnBoardSquares = new Button[SIZE][SIZE]; //new Button[Board.SIZE][Board.SIZE];
    private Button btnNewGame;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblPlayer1 = new Label("Player 1");
        lblPlayer1.setFont(Font.font("Verdana", FONT_SIZE));
        lblPlayer1.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //player 2 text colour
        /*lblPlayer1.setBackground(new Background(
                new BackgroundFill(
                        Color.rgb(3,32,86), null, null)));*/
        lblPlayer2 = new Label("Player 2");
        lblPlayer2.setFont(Font.font("Verdana", FONT_SIZE));
        lblPlayer2.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //player 2 text colour
        /*lblPlayer2.setBackground(new Background(
                new BackgroundFill(
                        Color.rgb(3,32,86), null, null)));*/
        btnNewGame = new Button("New Game");
        btnNewGame.setFont(Font.font("Verdana", FONT_SIZE));
        /*btnNewGame.setBackground(new Background(
                new BackgroundFill(
                        Color.rgb(3,32,86), null, null))); //new game button bg*/
        btnNewGame.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 15px"); //new game button text colour --> bold: -fx-font-weight: bold;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                btnBoardSquares[i][j] = new Button();
                btnBoardSquares[i][j].setMaxSize(250, 250);
                btnBoardSquares[i][j].setStyle("-fx-background-color: #032056; -fx-background-radius: 15px"); //board squares background
            }
        }
    }

        private void layoutNodes() {
        /*this.setBackground(new Background(
                new BackgroundFill(
                        Color.rgb(0,0,0), null, null))); //full background*/
            this.setBackground(Background.fill(new LinearGradient(
                    0, 0, 1, 1, true,                      //sizing
                    CycleMethod.NO_CYCLE,                  //cycling
                    new Stop(0, Color.web("#fdea16")),     //colors
                    new Stop(1, Color.web("#fd60e9"))))
            );
        GridPane gpBoard = new GridPane();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    gpBoard.add(btnBoardSquares[i][j], i, j);
                    GridPane.setVgrow(btnBoardSquares[i][j], Priority.ALWAYS);
                    GridPane.setHgrow(btnBoardSquares[i][j], Priority.ALWAYS);
                }
            }
            gpBoard.setVgap(10);
            gpBoard.setHgap(10);
            this.setCenter(gpBoard);
            gpBoard.setMaxSize(300,300);
            /*gpBoard.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.rgb(104,200,255), null, null))); //board bg*/
            gpBoard.setBackground(Background.fill(new LinearGradient(
                            0, 0, 1, 1, true,                      //sizing
                            CycleMethod.NO_CYCLE,                  //cycling
                            new Stop(0, Color.web("#fdea16")),     //colors
                            new Stop(1, Color.web("#fd60e9"))))
                    );
            HBox hbTopRight = new HBox(lblPlayer2);
            hbTopRight.setSpacing(20);
            HBox hbTop = new HBox(lblPlayer1, hbTopRight);
            HBox.setHgrow(hbTopRight, Priority.ALWAYS);
            hbTopRight.setAlignment(Pos.BOTTOM_RIGHT);
            hbTop.setSpacing(20);
            lblPlayer2.setAlignment(Pos.BOTTOM_RIGHT);
            this.setTop(hbTop);
            BorderPane.setMargin(gpBoard, new Insets(10));
            BorderPane.setMargin(hbTop, new Insets(10));
            this.setBottom(btnNewGame);
            BorderPane.setAlignment(btnNewGame, Pos.BOTTOM_CENTER);
            BorderPane.setMargin(btnNewGame, new Insets(10));
        }

    }


