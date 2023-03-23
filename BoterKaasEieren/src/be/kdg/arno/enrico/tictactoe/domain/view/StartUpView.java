package be.kdg.arno.enrico.tictactoe.domain.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class StartUpView extends BorderPane {

    private static final int BUTTON_PREFWIDTH = 440;
    private static final int BUTTON_PREFHEIGHT = 20;
    private static final int SCOREBOARD_PREFWIDTH = 300;
    private static final int SCOREBOARD_PREFHEIGHT = 600;


    Label lblScoreboardTitle;
    ImageView ivLogo;

    Label lblPlayer1 = new Label("1. Hans - 69");
    Label lblPlayer2 = new Label("2. Enrico - 55");
    Label lblPlayer3 = new Label("3. Arno - 28");
    Label lblPlayer4 = new Label("4. Jonas - 16");
    Label lblPlayer5 = new Label("5. Seppe - 12");

    Button btnPlay1v1;
    Button btnPlayComputer;
    Button btnPlayedGames;
    Button btnRules;
    Button btnExit;

    public StartUpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        try {
            ivLogo = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/logo_tictactoe.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivLogo.setFitHeight(180);
        ivLogo.setFitWidth(500);

        lblScoreboardTitle = new Label("Scoreboard");
        lblScoreboardTitle.setFont(Font.font("Verdana", 35));
        lblScoreboardTitle.setStyle("-fx-text-fill: #68C8FF; -fx-font-weight: bold");

        lblPlayer1.setFont(Font.font("Verdana", 30));
        lblPlayer1.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer2.setFont(Font.font("Verdana", 30));
        lblPlayer2.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer3.setFont(Font.font("Verdana", 30));
        lblPlayer3.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer4.setFont(Font.font("Verdana", 30));
        lblPlayer4.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer5.setFont(Font.font("Verdana", 30));
        lblPlayer5.setStyle("-fx-text-fill: #68C8FF;");

        btnPlay1v1 = new Button("Play 1 VS 1");
        btnPlay1v1.setFont(Font.font("Verdana", 30));
        btnPlay1v1.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        btnPlay1v1.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnPlay1v1.setMaxWidth(800);

        btnPlayComputer = new Button("Play VS Computer");
        btnPlayComputer.setFont(Font.font("Verdana", 30));
        btnPlayComputer.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        btnPlayComputer.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnPlayComputer.setMaxWidth(800);

        btnPlayedGames = new Button("Played Games");
        btnPlayedGames.setFont(Font.font("Verdana", 30));
        btnPlayedGames.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        btnPlayedGames.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnPlayedGames.setMaxWidth(800);

        btnRules = new Button("Rules");
        btnRules.setFont(Font.font("Verdana", 30));
        btnRules.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        btnRules.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnRules.setMaxWidth(800);

        btnExit = new Button("Exit the game");
        btnExit.setFont(Font.font("Verdana", 30));
        btnExit.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        btnExit.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnExit.setMaxWidth(800);

    }

    private void layoutNodes() {
        VBox buttonbox = new VBox();
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.getChildren().addAll(btnPlay1v1, btnPlayComputer, btnPlayedGames, btnRules, btnExit);
        buttonbox.setSpacing(15);
        this.setCenter(buttonbox);
        VBox.setVgrow(buttonbox, Priority.ALWAYS);
        BorderPane.setMargin(buttonbox, new Insets(20));

        this.setBackground(Background.fill(new LinearGradient(0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#fdea16")),     //colors
                new Stop(1, Color.web("#fd60e9")))));

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        this.setTop(hbox);
        hbox.getChildren().add(ivLogo);

        VBox topPlayers = new VBox();
        topPlayers.setAlignment(Pos.TOP_LEFT);
        topPlayers.setPrefSize(SCOREBOARD_PREFWIDTH, SCOREBOARD_PREFHEIGHT - 30);
        topPlayers.getChildren().addAll(lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5);
        topPlayers.setSpacing(20);
        topPlayers.setStyle("-fx-background-color: #0a3dd7; -fx-background-radius: 5px, 50px, 5px, 50px");
        VBox.setMargin(topPlayers, new Insets(15));


        VBox scorebox = new VBox();
        scorebox.setAlignment(Pos.CENTER);
        scorebox.setPrefSize(SCOREBOARD_PREFWIDTH, SCOREBOARD_PREFHEIGHT);
        scorebox.setStyle("-fx-background-color: #032056; -fx-background-radius: 5px, 50px, 5px, 50px");
        scorebox.getChildren().addAll(lblScoreboardTitle, topPlayers);
        scorebox.setAlignment(Pos.CENTER);
        this.setRight(scorebox);
        BorderPane.setMargin(scorebox, new Insets(20));
    }

    Button getBtnPlay1v1() {
        return btnPlay1v1;
    }

    Button getBtnPlayComputer() {
        return btnPlayComputer;
    }

    Button getBtnPlayedGames() {
        return btnPlayedGames;
    }

    Button getBtnRules() {
        return btnRules;
    }

    Button getBtnExit() {
        return btnExit;
    }
}



