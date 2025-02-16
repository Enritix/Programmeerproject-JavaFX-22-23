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

/**
 * This class is the view for the rules window.
 * This is the window that gets opened as soon as the Rules button inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class RulesView extends BorderPane {
    //Properties.
    private ImageView ivBack;
    private Label lblRulesTitle;

    private Text txtRules;
    private Button btnBack;

    //Constructor.
    public RulesView() {
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

        lblRulesTitle = new Label("Rules");
        lblRulesTitle.setId("lblRules");

        txtRules = new Text("The game is played on a 3 by 3 grid of 9 empty squares.\n " +
                "The two players alternate marking the empty squares, the first player marks Xs and the second player marks Os. \n " +
                "If one player places three of the same marks in a straight line, that player wins and gets 3 points. \n " +
                "If all the squares are filled and there is no winner, the game ends in a draw and both players get 1 point.");
        txtRules.setFont(Font.font("Lucida Calligraphy", 25));
        txtRules.setStyle("-fx-text-fill: #ed0202;");
        txtRules.setWrappingWidth(700);

        btnBack = new Button("", ivBack);
        btnBack.setStyle("-fx-background-color: transparent");

    }//initialiseNodes.

    private void layoutNodes() {

        this.setBackground(Background.fill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#fdea16")),     //colors
                new Stop(1, Color.web("#fd60e9")))));

        HBox hbTitleBox = new HBox();
        hbTitleBox.setAlignment(Pos.TOP_CENTER);
        hbTitleBox.getChildren().addAll(lblRulesTitle);
        this.setTop(hbTitleBox);

        HBox hbRulesBox = new HBox();
        hbRulesBox.setAlignment(Pos.CENTER);
        hbRulesBox.getChildren().addAll(txtRules);
        this.setCenter(hbRulesBox);

        HBox hbBackBox = new HBox();
        hbBackBox.setAlignment(Pos.BOTTOM_LEFT);
        hbBackBox.getChildren().addAll(btnBack);
        hbBackBox.setMaxHeight(40);
        this.setBottom(hbBackBox);
        BorderPane.setMargin(hbBackBox, new Insets(20));


    }
    //Getters.
    Button getBtnBack() {
        return btnBack;
    }

}