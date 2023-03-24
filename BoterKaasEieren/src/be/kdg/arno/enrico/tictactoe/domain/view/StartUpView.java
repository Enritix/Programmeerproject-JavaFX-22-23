package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.Leaderboard;
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

/**
 * This class is the view for the start up menu.
 * This is the menu that gets opened as soon as the application starts.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class StartUpView extends BorderPane {
    //Properties.
    private static final int BUTTON_PREFWIDTH = 440;
    private static final int BUTTON_PREFHEIGHT = 20;
    private static final int SCOREBOARD_PREFWIDTH = 300;
    private static final int SCOREBOARD_PREFHEIGHT = 600;

    private Label lblScoreboardTitle;
    private ImageView ivLogo;

    private Label lblPlayer1;
    private Label lblPlayer2;
    private Label lblPlayer3;
    private Label lblPlayer4;
    private Label lblPlayer5;

    private Button btnPlay1v1;
    private Button btnPlayComputer;
    private Button btnPlayedGames;
    private Button btnRules;
    private Button btnExit;
    private VBox vbLeaderboard;

    //Constructor.
    public StartUpView() {
        initialiseNodes();
        layoutNodes();
    }

    //Methods.
    private void initialiseNodes() {
        try {
            ivLogo = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/logo_tictactoe.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivLogo.setFitHeight(180);
        ivLogo.setFitWidth(500);

        lblScoreboardTitle = new Label("Leaderboard");
        lblScoreboardTitle.setFont(Font.font("Verdana", 35));
        lblScoreboardTitle.setStyle("-fx-text-fill: #68C8FF; -fx-font-weight: bold");

        Leaderboard leaderboard = new Leaderboard();

        lblPlayer1 = new Label("1. " + leaderboard.getPosition(1));
        lblPlayer1.setFont(Font.font("Verdana", 30));
        lblPlayer1.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer2 = new Label("2. " + leaderboard.getPosition(2));
        lblPlayer2.setFont(Font.font("Verdana", 30));
        lblPlayer2.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer3 = new Label("3. " + leaderboard.getPosition(3));
        lblPlayer3.setFont(Font.font("Verdana", 30));
        lblPlayer3.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer4 = new Label("4. " + leaderboard.getPosition(4));
        lblPlayer4.setFont(Font.font("Verdana", 30));
        lblPlayer4.setStyle("-fx-text-fill: #68C8FF;");

        lblPlayer5 = new Label("5. " + leaderboard.getPosition(5));
        lblPlayer5.setFont(Font.font("Verdana", 30));
        lblPlayer5.setStyle("-fx-text-fill: #68C8FF;");

        btnPlay1v1 = new Button("Play 1 VS 1");
        btnPlay1v1.setFont(Font.font("Verdana", 30));
        btnPlay1v1.setId("startupButton");
        btnPlay1v1.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnPlay1v1.setMaxWidth(800);

        btnPlayComputer = new Button("Play VS Computer");
        btnPlayComputer.setFont(Font.font("Verdana", 30));
        btnPlayComputer.setId("startupButton");
        btnPlayComputer.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnPlayComputer.setMaxWidth(800);

        btnPlayedGames = new Button("Played Games");
        btnPlayedGames.setFont(Font.font("Verdana", 30));
        btnPlayedGames.setId("startupButton");
        btnPlayedGames.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnPlayedGames.setMaxWidth(800);

        btnRules = new Button("Rules");
        btnRules.setFont(Font.font("Verdana", 30));
        btnRules.setId("startupButton");
        btnRules.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnRules.setMaxWidth(800);

        btnExit = new Button("Exit the game");
        btnExit.setFont(Font.font("Verdana", 30));
        btnExit.setId("startupButton");
        btnExit.setPrefSize(BUTTON_PREFWIDTH, BUTTON_PREFHEIGHT);
        btnExit.setMaxWidth(800);
    }//initialiseNodes.

    private void layoutNodes() {

        VBox vbButtonBox = new VBox();
        vbButtonBox.setAlignment(Pos.CENTER);
        vbButtonBox.getChildren().addAll(btnPlay1v1, btnPlayComputer, btnPlayedGames, btnRules, btnExit);
        vbButtonBox.setSpacing(15);
        this.setCenter(vbButtonBox);
        VBox.setVgrow(vbButtonBox, Priority.ALWAYS);
        BorderPane.setMargin(vbButtonBox, new Insets(20));

        this.setBackground(Background.fill(new LinearGradient(0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#fdea16")),
                new Stop(1, Color.web("#fd60e9")))));

        HBox hbLogo = new HBox();
        hbLogo.setAlignment(Pos.CENTER);
        this.setTop(hbLogo);
        hbLogo.getChildren().add(ivLogo);

        VBox vbTopPlayers = new VBox();
        vbTopPlayers.setAlignment(Pos.TOP_LEFT);
        vbTopPlayers.setPrefSize(SCOREBOARD_PREFWIDTH, SCOREBOARD_PREFHEIGHT - 30);
        vbTopPlayers.getChildren().addAll(lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5);
        vbTopPlayers.setSpacing(20);
        vbTopPlayers.setId("startupLeaderboardMiddle");
        VBox.setMargin(vbTopPlayers, new Insets(15));


        vbLeaderboard = new VBox();
        vbLeaderboard.setAlignment(Pos.CENTER);
        vbLeaderboard.setPrefSize(SCOREBOARD_PREFWIDTH, SCOREBOARD_PREFHEIGHT);
        vbLeaderboard.setId("startupLeaderboardOutline");
        vbLeaderboard.getChildren().addAll(lblScoreboardTitle, vbTopPlayers);
        vbLeaderboard.setAlignment(Pos.CENTER);
        this.setRight(vbLeaderboard);
        BorderPane.setMargin(vbLeaderboard, new Insets(20));
    }//layoutNodes.

    //Getters and Setters.
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

    VBox getVbLeaderboard() {
        return vbLeaderboard;
    }
}



