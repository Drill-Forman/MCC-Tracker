package edu.miracosta.cs112.controllers;

import edu.miracosta.cs112.models.YieldStock;
import edu.miracosta.cs112.models.YieldStockCsvReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class YieldViewController {

    @FXML
    private VBox stockCardsVBox;

    @FXML
    public void initialize() {
        loadStockCards();
    }

    private void loadStockCards() {
        try {
            ArrayList<YieldStock> highYieldETFs = YieldStockCsvReader.readYieldStocksFromResources();

            // Clear any existing children (e.g., the title label is already in FXML)
            // We'll add stock cards below the title.

            // Start adding stock cards from the CSV data
            for (YieldStock stock : highYieldETFs) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/StockCard.fxml"));
                AnchorPane stockCardPane = fxmlLoader.load();
                StockCardController stockCardController = fxmlLoader.getController();
                stockCardController.setStockData(stock);
                stockCardsVBox.getChildren().add(stockCardPane);
            }
        } catch (IOException e) {
            System.err.println("Error loading stock data or FXML for stock cards: " + e.getMessage());
            e.printStackTrace();
            // Optionally, display an error message to the user in the UI
        }
    }
}
