package be.kdg.aaron.enrico.boterkaaseieren;

import be.kdg.aaron.enrico.boterkaaseieren.domain.view.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    public static void main(String[] args) {
        javafx.application.Application.launch(args);
    }
    BKEView bkeView;
    @Override
    public void start(Stage stage) throws Exception {

        //Fields to specify number of rows/columns
        TextField rowField = new TextField("3");
        TextField columnField = new TextField("3");

        //Function to set an action when text field loses focus
        buildTextFieldActions(rowField, columnField);

        HBox fields = new HBox(10);
        fields.getChildren().add(rowField);
        fields.getChildren().add(new Label("x"));
        fields.getChildren().add(columnField);

        BKEView bkeView = new BKEView(3,3);
        BorderPane mainPanel = new BorderPane();
        mainPanel.setCenter(bkeView.getDisplay());
        mainPanel.setTop(fields);

        Scene scene = new Scene(mainPanel, 800, 800);
        stage.setTitle("Test grid display");
        stage.setScene(scene);
        stage.show();
    }
    private void buildTextFieldActions(final TextField rowField, final TextField columnField) {
        rowField.focusedProperty().addListener((ov, t, t1) -> //TODO: lambda wegwerken!
                 {
            if (!t1) {
                if (!rowField.getText().equals("")) {
                    try {
                        int nbRow = Integer.parseInt(rowField.getText());
                        BKEView bkeView = new BKEView(5,5);
                        bkeView.setRows(nbRow);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            }
        });

        columnField.focusedProperty().addListener((ov, t, t1) -> //TODO: lambda wegwerken!
        {
            if (!t1) {
                if (!columnField.getText().equals("")) {
                    try {
                        int nbColumn = Integer.parseInt(columnField.getText());
                        BKEView bkeView = new BKEView(5,5);
                        bkeView.setColumns(nbColumn);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            }
        });
    }

    public void getView() {
        this.bkeView = new BKEView(3,3);
        //TODO
    }
}
