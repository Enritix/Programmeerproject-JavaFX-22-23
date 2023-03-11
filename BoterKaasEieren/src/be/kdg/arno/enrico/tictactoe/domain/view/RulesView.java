package be.kdg.arno.enrico.tictactoe.domain.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class RulesView extends BorderPane {

    Label rulesTitle;
    Button homeButton;

    public RulesView() {
        this.initialiseNodes();
        this.layoutNodes();


    }

    private void initialiseNodes(){

        rulesTitle = new Label("Rules");
        rulesTitle.setFont(Font.font("Lucida Calligraphy", 55));
        rulesTitle.setStyle("-fx-text-fill: #ed0202");

    }

    private void layoutNodes() {

    }


}
