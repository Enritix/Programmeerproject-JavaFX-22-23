package be.kdg.arno.enrico.tictactoe.domain.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RulesView extends BorderPane {

    private static final int BUTTON_PREFWIDTH = 90;
    private static final int BUTTON_PREFHEIGHT = 90;

    private ImageView ivBack;
    private Label rulesTitle;

    private Text rules;
    private Button btnBack;

    public RulesView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

        try {
            ivBack = new ImageView(new Image(new FileInputStream("resources/images/arrow_back.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ivBack.setFitHeight(BUTTON_PREFHEIGHT);
        ivBack.setFitWidth(BUTTON_PREFWIDTH);

        rulesTitle = new Label("Rules");
        rulesTitle.setFont(Font.font("Lucida Calligraphy", 55));
        rulesTitle.setStyle("-fx-text-fill: #ed0202");

        rules = new Text("The game is played on a 3 by 3 grid of 9 empty squares.\n The two players alternate marking the empty squares, the first players marks Xs and the second player marks Os. \n If one player places three of the same marks in a straight line, that player wins. \n If all the squares are filled and there is no winner, the game ends in a draw.");
        rules.setFont(Font.font("Lucida Calligraphy", 25));
        rules.setStyle("-fx-text-fill: #ed0202");
        rules.setWrappingWidth(700);

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

        HBox titlebox = new HBox();
        titlebox.setAlignment(Pos.TOP_CENTER);
        titlebox.getChildren().addAll(rulesTitle);
        this.setTop(titlebox);

        HBox rulesbox = new HBox();
        rulesbox.setAlignment(Pos.CENTER);
        rulesbox.getChildren().addAll(rules);
        this.setCenter(rulesbox);

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