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

    private static final int BUTTON_PREFWIDTH = 200;
    private static final int BUTTON_PREFHEIGHT = 70;

    ImageView ivBack;
    Label rulesTitle;
    Button btnBack;

    public RulesView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

        try {
            ivBack = new ImageView(new Image(new FileInputStream("resources/images/back.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ivBack.setFitHeight(BUTTON_PREFHEIGHT);
        ivBack.setFitWidth(BUTTON_PREFWIDTH);

        rulesTitle = new Label("Rules");
        rulesTitle.setFont(Font.font("Lucida Calligraphy", 55));
        rulesTitle.setStyle("-fx-text-fill: #ed0202");

        btnBack = new Button();
        btnBack.setGraphic(ivBack);
        btnBack.setBackground(null);

    }

    private void layoutNodes() {

        this.setBackground(Background.fill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#fdea16")),     //colors
                new Stop(1, Color.web("#fd60e9")))));

            HBox backbox = new HBox();
            backbox.setAlignment(Pos.BOTTOM_LEFT);
            backbox.getChildren().addAll(btnBack);
            backbox.setMaxHeight(40);
            this.setBottom(backbox);
            BorderPane.setMargin(backbox, new Insets(20));
        }

        public Button getBtnBack() {
        return btnBack;
    }

    }

