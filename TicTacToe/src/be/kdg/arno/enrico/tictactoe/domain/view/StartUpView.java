package be.kdg.arno.enrico.tictactoe.domain.view;

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

public class StartUpView extends BorderPane {

    private static final int BUTTONPREFWIDTH = 440;
    private static final int BUTTONPREFHEIGHT = 20;
    private static final int SCOREBOARDPREFWIDTH = 300;
    private static final int SCOREBOARDPREFHEIGHT = 600;


    Label scoreboardTitle;
    Label title;

    Label p1 = new Label("p1");
    Label p2 = new Label("p2");
    Label p3 = new Label("p3");
    Label p4 = new Label("p4");
    Label p5 = new Label("p5");

    Button play1v1;
    Button playComputer;
    Button rules;
    Button exit;




    public StartUpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

        scoreboardTitle = new Label("Scoreboard");
        scoreboardTitle.setFont(Font.font("Verdana", 35));
        scoreboardTitle.setStyle("-fx-text-fill: #000000;");

        p1.setFont(Font.font("Verdana", 30));
        p1.setStyle("-fx-text-fill: #68C8FF;");

        p2.setFont(Font.font("Verdana", 30));
        p2.setStyle("-fx-text-fill: #68C8FF;");

        p3.setFont(Font.font("Verdana", 30));
        p3.setStyle("-fx-text-fill: #68C8FF;");

        p4.setFont(Font.font("Verdana", 30));
        p4.setStyle("-fx-text-fill: #68C8FF;");

        p5.setFont(Font.font("Verdana", 30));
        p5.setStyle("-fx-text-fill: #68C8FF;");



        title = new Label("Boter, kaas & eieren");
        title.setFont(Font.font("Lucida Calligraphy", 55));
        title.setStyle("-fx-text-fill: #ed0202");

        play1v1 = new Button("Play 1 versus 1");
        play1v1.setFont(Font.font("Verdana", 30));
        play1v1.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        play1v1.setPrefSize(BUTTONPREFWIDTH,BUTTONPREFHEIGHT);

        playComputer = new Button("Play against the computer");
        playComputer.setFont(Font.font("Verdana", 30));
        playComputer.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        playComputer.setPrefSize(BUTTONPREFWIDTH,BUTTONPREFHEIGHT);

        rules = new Button("Rules");
        rules.setFont(Font.font("Verdana", 30));
        rules.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        rules.setPrefSize(BUTTONPREFWIDTH,BUTTONPREFHEIGHT);

        exit = new Button("Exit the game");
        exit.setFont(Font.font("Verdana", 30));
        exit.setStyle("-fx-background-color: #032056; -fx-text-fill: #68C8FF; -fx-background-radius: 5px");
        exit.setPrefSize(BUTTONPREFWIDTH,BUTTONPREFHEIGHT);

    }

    private void layoutNodes() {
        VBox buttonbox = new VBox();
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.getChildren().addAll(play1v1, playComputer, rules, exit);
        buttonbox.setSpacing(15);
        this.setCenter(buttonbox);
        VBox.setVgrow(buttonbox, Priority.ALWAYS);
        BorderPane.setMargin(buttonbox, new Insets(20));

        this.setBackground(Background.fill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#fdea16")),     //colors
                new Stop(1, Color.web("#fd60e9")))));

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        this.setTop(hbox);
        hbox.getChildren().add(title);

        VBox topPlayers = new VBox();
        topPlayers.setAlignment(Pos.TOP_LEFT);
        topPlayers.setPrefSize(SCOREBOARDPREFWIDTH,SCOREBOARDPREFHEIGHT - 30);
        topPlayers.getChildren().addAll(p1, p2, p3, p4, p5);
        topPlayers.setSpacing(20);
        topPlayers.setStyle("-fx-background-color: #032056; -fx-background-radius: 5px, 50px, 5px, 50px");
        VBox.setMargin(topPlayers, new Insets(15));


        VBox scorebox = new VBox();
        scorebox.setAlignment(Pos.CENTER);
        scorebox.setPrefSize(SCOREBOARDPREFWIDTH, SCOREBOARDPREFHEIGHT);
        scorebox.setStyle("-fx-background-color: #3902ed; -fx-background-radius: 5px, 50px, 5px, 50px");
        scorebox.getChildren().addAll(scoreboardTitle, topPlayers);
        scorebox.setAlignment(Pos.CENTER);
        this.setRight(scorebox);
        BorderPane.setMargin(scorebox, new Insets(20));
    }

    public Button getPlay1v1() {
        return play1v1;
    }

    public Button getPlayComputer() {
        return playComputer;
    }

    public Button getRules() {
        return rules;
    }

    public Button getExit() {
        return exit;
    }
}



