package edu.miracosta.cs112.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    Button hiButton;

    @FXML
    protected void onHelloButtonClicked(ActionEvent actionEvent) {
        System.out.println("Hello World!");
    }

    @FXML
    private void handleSquareClick(MouseEvent event) {
        Rectangle clickedSquare = (Rectangle) event.getSource();
        contentPane.getChildren().clear();
        Label label = new Label("You clicked: " + clickedSquare.getId());
        label.setLayoutX(20);
        label.setLayoutY(20);
        contentPane.getChildren().add(label);
    }
}