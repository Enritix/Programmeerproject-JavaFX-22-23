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

public class RulesView extends BorderPane {

    ImageView back;
    Label rulesTitle;
    Button homeButton;

    public RulesView() {
        initialiseNodes();
        layoutNodes();


    }

    private void initialiseNodes() {

        try {
            back = new ImageView(new Image(new FileInputStream("resources/images/back.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        rulesTitle = new Label("Rules");
        rulesTitle.setFont(Font.font("Lucida Calligraphy", 55));
        rulesTitle.setStyle("-fx-text-fill: #ed0202");
    }

    private void layoutNodes() {

        this.setBackground(Background.fill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#fdea16")),     //colors
                new Stop(1, Color.web("#fd60e9")))));

            HBox backbox = new HBox();
            backbox.setAlignment(Pos.BOTTOM_LEFT);
            backbox.getChildren().addAll(back);
            backbox.setSpacing(15);
            this.setBottom(backbox);
            VBox.setVgrow(backbox, Priority.ALWAYS);
            BorderPane.setMargin(backbox, new Insets(20));
        }

    }

