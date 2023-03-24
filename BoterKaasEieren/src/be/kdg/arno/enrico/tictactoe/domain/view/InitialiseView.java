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

public class InitialiseView extends BorderPane {

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

    public InitialiseView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblNameP1 = new Label(" Name of player X:");

        cbNamesP1 = new ComboBox<>();
        cbNamesP1.getItems().addAll(leaderboard.getNameFromLeaderboard());

        tfNameP1 = new TextField();
        ttName = new Tooltip();
        lblNameP2 = new Label(" Name of player O:");

        cbNamesP2 = new ComboBox<>();
        cbNamesP2.getItems().addAll(leaderboard.getNameFromLeaderboard());

        tfNameP2 = new TextField();
        lblDifficulty = new Label(" Difficulty:");
        cbDifficulty = new ComboBox<>(FXCollections.observableArrayList("Easy: 3x3 - 3 in a row", "Medium: 5x5 - 4 in a row", "Hard: 7x7 - 4 in a row", "Custom"));
        cbDifficulty.setValue("Easy: 3x3 - 3 in a row");
        lblCustom = new Label(" Custom:");
        ttCustom = new Tooltip();
        tfCustom = new TextField();
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
    }

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
        showPlayerList("p1", "text");
        cbNamesP1.setPrefHeight(40);
        cbNamesP1.setPrefWidth(100);
        cbNamesP1.prefWidthProperty().bind(tfNameP1.widthProperty().multiply(0.75));

        ttName.setText("A name can't contain any numbers or special characters and needs to be longer than 1 character!");
        ttName.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
        ttName.setTextAlignment(TextAlignment.CENTER);

        Tooltip.install(lblNameP1, ttName);

        lblNameP2.setPrefWidth(300);
        lblNameP2.setId("mainLabel");
        tfNameP2.setMaxWidth(Double.MAX_VALUE);
        tfNameP2.setPrefHeight(40);
        showPlayerList("p2", "text");
        cbNamesP2.setPrefHeight(40);
        cbNamesP2.prefWidthProperty().bind(tfNameP2.widthProperty().multiply(0.75));

        Tooltip.install(lblNameP2, ttName);

        HBox hbNameP1 = new HBox();
        hbNameP1.getChildren().addAll(lblNameP1, tfNameP1, cbNamesP1, btnEdit);
        hbNameP1.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbNameP1.setPadding(new Insets(0, 10, 0, 10));
        HBox.setHgrow(tfNameP1, Priority.ALWAYS);
        hbNameP1.setSpacing(10);

        HBox hbNameP2 = new HBox();
        hbNameP2.getChildren().addAll(lblNameP2, tfNameP2, cbNamesP2, btnEdit2);
        hbNameP2.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbNameP2.setPadding(new Insets(0, 10, 0, 10));
        HBox.setHgrow(tfNameP2, Priority.ALWAYS);
        hbNameP2.setSpacing(10);

        lblDifficulty.setPrefWidth(300);
        lblDifficulty.setId("mainLabel");

        HBox hbDifficulty = new HBox(lblDifficulty, cbDifficulty);
        hbDifficulty.setEffect(new DropShadow(UIConstants.DEFAULT_SHADOW, Color.BLACK));
        hbDifficulty.setPadding(new Insets(0, 10, 0, 10));
        hbDifficulty.setSpacing(10);

        cbDifficulty.setMaxWidth(Double.MAX_VALUE);
        cbDifficulty.setPrefHeight(40);
        HBox.setHgrow(cbDifficulty, Priority.ALWAYS);

        lblCustom.setPrefWidth(300);
        lblCustom.setId("mainLabel");

        ttCustom.setText("The custom size needs to be between the range of 4 and 8! 'e.g. 6'");
        ttCustom.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
        ttCustom.setTextAlignment(TextAlignment.CENTER);

        Tooltip.install(lblNameP1, ttName);

        hbCustom = new HBox(lblCustom, tfCustom);
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
    }

    public TextField getTfNameP1() {
        return tfNameP1;
    }

    public TextField getTfNameP2() {
        return tfNameP2;
    }

    public ComboBox<String> getCbDifficulty() {
        return cbDifficulty;
    }

    public Button getBtnPlay() {
        return btnPlay;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public TextField getTfCustom() {
        return tfCustom;
    }

    public void setCustom(boolean input) {
        hbCustom.setVisible(input);
        tfCustom.setText("");
    }

    public void showPlayerList(String player, String whichBox) {
        if (player.equals("p1") && whichBox.equals("text")) {
            tfNameP1.setVisible(true);
            /*tfNameP1.setPrefWidth(Double.MAX_VALUE);*/
            cbNamesP1.setVisible(false);
            /*cbNamesP1.setPrefWidth(0);*/

            tfNameP1.requestFocus();
        } else if (player.equals("p1") && whichBox.equals("combo")){
            tfNameP1.setVisible(false);
            /*tfNameP1.setPrefWidth(0);*/
            cbNamesP1.setVisible(true);
            /*cbNamesP1.setPrefWidth(Double.MAX_VALUE);*/
            cbNamesP1.requestFocus();
        }
        if (player.equals("p2") && whichBox.equals("text")) {
            tfNameP2.setVisible(true);
            /*tfNameP2.setPrefWidth(Double.MAX_VALUE);*/
            cbNamesP2.setVisible(false);
            /*cbNamesP2.setPrefWidth(0);*/
            tfNameP2.requestFocus();
        } else if (player.equals("p2") && whichBox.equals("combo")){
            tfNameP2.setVisible(false);
            /*tfNameP1.setPrefWidth(0);*/
            cbNamesP2.setVisible(true);
            /*cbNamesP2.setPrefWidth(Double.MAX_VALUE);*/
            cbNamesP2.requestFocus();
        }
    }

    public Tooltip getTtName() {
        return ttName;
    }

    public Label getLblNameP1() {
        return lblNameP1;
    }

    public Label getLblNameP2() {
        return lblNameP2;
    }

    public Label getLblCustom() {
        return lblCustom;
    }

    public Tooltip getTtCustom() {
        return ttCustom;
    }

    public HBox getHbCustom() {
        return hbCustom;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public Button getBtnEdit2() {
        return btnEdit2;
    }

    public ComboBox<String> getCbNamesP1() {
        return cbNamesP1;
    }

    public ComboBox<String> getCbNamesP2() {
        return cbNamesP2;
    }
}
