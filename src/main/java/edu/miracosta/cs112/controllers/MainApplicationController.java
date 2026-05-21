package edu.miracosta.cs112.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent; // Import Parent
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox; // Import VBox

import java.io.IOException;

public class MainApplicationController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private AnchorPane homeTabContent;

    @FXML
    private AnchorPane stockTrackerTabContent;

    @FXML
    public void initialize() {
        try {
            // Load Home View into the Home tab
            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/home-view.fxml"));
            VBox homeView = homeLoader.load(); // Changed type from AnchorPane to VBox
            homeTabContent.getChildren().add(homeView);
            AnchorPane.setTopAnchor(homeView, 0.0);
            AnchorPane.setBottomAnchor(homeView, 0.0);
            AnchorPane.setLeftAnchor(homeView, 0.0);
            AnchorPane.setRightAnchor(homeView, 0.0);

            // Load Yield View into the Stock Tracker tab
            FXMLLoader yieldLoader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/Yield-View.fxml"));
            AnchorPane yieldView = yieldLoader.load(); // This is still an AnchorPane, so it's correct
            stockTrackerTabContent.getChildren().add(yieldView);
            AnchorPane.setTopAnchor(yieldView, 0.0);
            AnchorPane.setBottomAnchor(yieldView, 0.0);
            AnchorPane.setLeftAnchor(yieldView, 0.0);
            AnchorPane.setRightAnchor(yieldView, 0.0);

            // Settings tab content can be loaded similarly or added later
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, e.g., show an alert to the user
        }
    }
}
