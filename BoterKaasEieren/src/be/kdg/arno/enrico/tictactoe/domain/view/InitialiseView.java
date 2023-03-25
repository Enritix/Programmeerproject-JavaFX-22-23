package be.kdg.arno.enrico.tictactoe.domain.view;

import be.kdg.arno.enrico.tictactoe.domain.model.Leaderboard;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static be.kdg.arno.enrico.tictactoe.domain.view.UIConstants.BUTTON_PREFHEIGHT;
import static be.kdg.arno.enrico.tictactoe.domain.view.UIConstants.BUTTON_PREFWIDTH;

/**
 * This class is the view for the play 1 vs 1 window.
 * This is the window that gets opened as soon as the Play 1 VS 1 button inside the starting screen is clicked.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class InitialiseView extends BorderPane {
    //Properties.
    private Leaderboard leaderboard = new Leaderboard();
    private Label lblNameP1;
    private ComboBox<String> cbNamesP1;
    private TextField tfNameP1;
    private Label lblNameP2;
    private Tooltip ttName;
    private TextField tfNameP2;
    private ComboBox<String> cbNamesP2;
    private Label lblDifficulty;
    private ComboBox<String> cbDifficulty;
    private Label lblCustom;
    private Tooltip ttCustom;
    private TextField tfCustom;
    private ImageView ivBack;
    private Button btnBack;
    private Button btnPlay;
    private HBox hbCustom;
    private ImageView ivEdit;
    private Button btnEdit;
    private ImageView ivEdit2;
    private Button btnEdit2;
    private HBox hbNameP1;
    private HBox hbNameP2;
    private ImageView ivQuestionMark1;
    private ImageView ivQuestionMark2;
    private ImageView ivQuestionMark3;

    //Constructor.
    public InitialiseView() {
        initialiseNodes();
        layoutNodes();
    }

    //Methods.
    private void initialiseNodes() {
        try {
            ivQuestionMark1 = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/question_mark.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivQuestionMark1.setFitWidth(40);
        ivQuestionMark1.setFitHeight(40);

        lblNameP1 = new Label(" Name of player X:");

        cbNamesP1 = new ComboBox<>();
        cbNamesP1.getItems().addAll(leaderboard.getNameFromLeaderboard());
        cbNamesP1.setValue(leaderboard.readNames().get(0));

        tfNameP1 = new TextField("");
        ttName = new Tooltip();
        lblNameP2 = new Label(" Name of player O:");

        try {
            ivQuestionMark2 = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/question_mark.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivQuestionMark2.setFitWidth(40);
        ivQuestionMark2.setFitHeight(40);


        cbNamesP2 = new ComboBox<>();
        cbNamesP2.getItems().addAll(leaderboard.getNameFromLeaderboard());
        cbNamesP2.setValue(leaderboard.readNames().get(1));

        tfNameP2 = new TextField("");
        lblDifficulty = new Label(" Difficulty:");
        cbDifficulty = new ComboBox<>(FXCollections.observableArrayList("Easy: 3x3 - 3 in a row", "Medium: 5x5 - 4 in a row", "Hard: 7x7 - 4 in a row", "Custom"));
        cbDifficulty.setValue("Easy: 3x3 - 3 in a row");
        lblCustom = new Label(" Custom:");
        ttCustom = new Tooltip();
        tfCustom = new TextField();

        try {
            ivQuestionMark3 = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/question_mark.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivQuestionMark3.setFitWidth(40);
        ivQuestionMark3.setFitHeight(40);

        try {
            ivBack = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/arrow_back.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivBack.setFitHeight(BUTTON_PREFHEIGHT);
        ivBack.setFitWidth(BUTTON_PREFWIDTH);
        btnBack = new Button("", ivBack);
        btnBack.setStyle("-fx-background-color: transparent");
        btnPlay = new Button("Play");
        btnPlay.setPrefSize(180, 75);

        try {
            ivEdit = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/edit_button.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivEdit.setFitWidth(30);
        ivEdit.setFitHeight(30);
        btnEdit = new Button("", ivEdit);
        btnEdit.setStyle("-fx-background-color: #032056");
        btnEdit.setPrefSize(35, 35);

        try {
            ivEdit2 = new ImageView(new Image(new FileInputStream("BoterKaasEieren/resources/images/edit_button.png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ivEdit2.setFitWidth(30);
        ivEdit2.setFitHeight(30);
        btnEdit2 = new Button("", ivEdit2);
        btnEdit2.setStyle("-fx-background-color: #032056");
        btnEdit2.setPrefSize(35, 35);
    }//initialiseNodes.

    private void layoutNodes() {
        this.setBackground(Background.fill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#fdea16")),     //colors
                new Stop(1, Color.web("#fd60e9")))));

        lblNameP1.setPrefWidth(300);
        lblNameP1.setId("mainLabel");
        tfNameP1.setMaxWidth(Double.MAX_VALUE);
        tfNameP1.setPrefHeight(40);

        cbNamesP1.setPrefHeight(40);
        cbNamesP1.setPrefWidth(100);
        cbNamesP1.setMaxWidth(Double.MAX_VALUE);
        cbNamesP1.setMinWidth(UIConstants.BUTTON_MAXSIZE);

        ttName.setText("A name can't contain any numbers or special characters and needs to be longer than 1 character!");
        ttName.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
        ttName.setTextAlignment(TextAlignment.CENTER);

        Tooltip.install(ivQuestionMark1, ttName);

        lblNameP2.setPrefWidth(300);
        lblNameP2.setId("mainLabel");
        tfNameP2.setMaxWidth(Double.MAX_VALUE);
        tfNameP2.setPrefHeight(40);

        cbNamesP2.setPrefHeight(40);
        cbNamesP2.setMaxWidth(Double.MAX_VALUE);
        cbNamesP2.setMinWidth(UIConstants.BUTTON_MAXSIZE);

        Tooltip.install(ivQuestionMark2, ttName);

        hbNameP1 = new HBox();
        hbNameP1.getChildren().addAll(lblNameP1, ivQuestionMark1);
        switchPlayerBox("p1", "text");
        hbNameP1.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbNameP1.setPadding(new Insets(0, 10, 0, 10));
        HBox.setHgrow(tfNameP1, Priority.ALWAYS);
        hbNameP1.setSpacing(10);

        hbNameP2 = new HBox();
        hbNameP2.getChildren().addAll(lblNameP2, ivQuestionMark2);
        switchPlayerBox("p2", "text");
        hbNameP2.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbNameP2.setPadding(new Insets(0, 10, 0, 10));
        HBox.setHgrow(tfNameP2, Priority.ALWAYS);
        hbNameP2.setSpacing(10);

        lblDifficulty.setPrefWidth(300);
        lblDifficulty.setId("mainLabel");

        HBox hbDifficulty = new HBox(lblDifficulty, cbDifficulty);
        hbDifficulty.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbDifficulty.setPadding(new Insets(0, 10, 0, 10));
        hbDifficulty.setSpacing(60);

        cbDifficulty.setMaxWidth(Double.MAX_VALUE);
        cbDifficulty.setPrefHeight(40);
        HBox.setHgrow(cbDifficulty, Priority.ALWAYS);

        lblCustom.setPrefWidth(300);
        lblCustom.setId("mainLabel");

        ttCustom.setText("The custom size needs to be between the range of 4 and 8! 'e.g. 6'");
        ttCustom.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
        ttCustom.setTextAlignment(TextAlignment.CENTER);

        Tooltip.install(ivQuestionMark3, ttName);

        hbCustom = new HBox(lblCustom, ivQuestionMark3, tfCustom);
        hbCustom.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbCustom.setPadding(new Insets(0, 10, 0, 10));
        hbCustom.setSpacing(10);
        hbCustom.setVisible(false);

        tfCustom.setMaxWidth(Double.MAX_VALUE);
        tfCustom.setPrefHeight(40);
        HBox.setHgrow(tfCustom, Priority.ALWAYS);

        VBox vbForm = new VBox(hbNameP1, hbNameP2, hbDifficulty, hbCustom);
        vbForm.setSpacing(10);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setSpacing(10);

        HBox leftBox = new HBox();
        HBox.setHgrow(leftBox, Priority.ALWAYS);
        btnBack.setMaxWidth(Double.MAX_VALUE);
        btnPlay.setMaxWidth(Double.MAX_VALUE);

        HBox rightBox = new HBox();
        rightBox.getChildren().add(btnPlay);
        HBox.setHgrow(rightBox, Priority.ALWAYS);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(btnPlay, new Insets(0, 10, 0, 10));

        leftBox.getChildren().add(btnBack);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().addAll(leftBox, rightBox);

        vbForm.setAlignment(Pos.CENTER);
        vbForm.setStyle("-fx-background-color: #032056");
        super.setCenter(vbForm);
        super.setBottom(buttonBox);
        btnPlay.setMinSize(80, 40);
        BorderPane.setMargin(vbForm, new Insets(10));
        BorderPane.setMargin(btnPlay, new Insets(0, 10, 10, 10));
        BorderPane.setAlignment(btnPlay, Pos.BOTTOM_RIGHT);
    }//layoutNodes.

    public void setCustom(boolean input) {
        hbCustom.setVisible(input);
        tfCustom.setText("");
    }//setCustom.

    public void switchPlayerBox(String player, String whichBox) {
        if (player.equals("p1") && whichBox.equals("text")) {
            hbNameP1.getChildren().remove(cbNamesP1);
            hbNameP1.getChildren().remove(btnEdit);
            hbNameP1.getChildren().add(tfNameP1);
            hbNameP1.getChildren().add(btnEdit);
            cbNamesP1.setVisible(false);
        } else if (player.equals("p1") && whichBox.equals("combo")){
            hbNameP1.getChildren().remove(tfNameP1);
            hbNameP1.getChildren().remove(btnEdit);
            hbNameP1.getChildren().add(cbNamesP1);
            hbNameP1.getChildren().add(btnEdit);
            cbNamesP1.setVisible(true);
        }
        if (player.equals("p2") && whichBox.equals("text")) {
            hbNameP2.getChildren().remove(cbNamesP2);
            hbNameP2.getChildren().remove(btnEdit2);
            hbNameP2.getChildren().add(tfNameP2);
            hbNameP2.getChildren().add(btnEdit2);
            cbNamesP2.setVisible(false);
        } else if (player.equals("p2") && whichBox.equals("combo")){
            hbNameP2.getChildren().remove(tfNameP2);
            hbNameP2.getChildren().remove(btnEdit2);
            hbNameP2.getChildren().add(cbNamesP2);
            hbNameP2.getChildren().add(btnEdit2);
            cbNamesP2.setVisible(true);
        }
    }//switchPlayerBox.

    //Getters.
    TextField getTfNameP1() {
        return tfNameP1;
    }

    TextField getTfNameP2() {
        return tfNameP2;
    }

    ComboBox<String> getCbDifficulty() {
        return cbDifficulty;
    }

    Button getBtnPlay() {
        return btnPlay;
    }

    Button getBtnBack() {
        return btnBack;
    }

    TextField getTfCustom() {
        return tfCustom;
    }

    Tooltip getTtName() {
        return ttName;
    }

    Label getLblNameP1() {
        return lblNameP1;
    }

    Label getLblNameP2() {
        return lblNameP2;
    }

    Label getLblCustom() {
        return lblCustom;
    }

    Tooltip getTtCustom() {
        return ttCustom;
    }

    HBox getHbCustom() {
        return hbCustom;
    }

    Button getBtnEdit() {
        return btnEdit;
    }

    Button getBtnEdit2() {
        return btnEdit2;
    }

    ComboBox<String> getCbNamesP1() {
        return cbNamesP1;
    }

    ComboBox<String> getCbNamesP2() {
        return cbNamesP2;
    }

    ImageView getIvQuestionMark1() {
        return ivQuestionMark1;
    }

    ImageView getIvQuestionMark2() {
        return ivQuestionMark2;
    }

    ImageView getIvQuestionMark3() {
        return ivQuestionMark3;
    }
}
