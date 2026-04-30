package edu.miracosta.cs112.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

public class MainController {

    // This connects to the AnchorPane we added in the FXML
    @FXML
    private AnchorPane contentPane;

    // Your existing button method (unchanged)
    @FXML
    protected void onHelloButtonClick(ActionEvent actionEvent) {
        System.out.println("Hello World!");
    }

    // This runs when any square is clicked
    @FXML
    private void handleSquareClick(MouseEvent event) {

        // Identify which square was clicked
        Rectangle clickedSquare =
                (Rectangle) event.getSource();

        // Remove old content
        contentPane.getChildren().clear();

        // Create new content
        Label label =
                new Label("You clicked: "
                        + clickedSquare.getId());

        // Position the label
        label.setLayoutX(20);
        label.setLayoutY(20);

        // Add it to the content area
        contentPane.getChildren().add(label);
    }
}