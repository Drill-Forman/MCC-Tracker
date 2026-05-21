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
        System.out.println("YieldViewController: Initializing...");
        loadStockCards();
        System.out.println("YieldViewController: Initialization complete.");
    }

    private void loadStockCards() {
        System.out.println("YieldViewController: Attempting to load stock cards.");
        try {
            ArrayList<YieldStock> highYieldETFs = YieldStockCsvReader.readYieldStocksFromResources();
            System.out.println("YieldViewController: Successfully read " + highYieldETFs.size() + " stocks from CSV.");

            // Start adding stock cards from the CSV data
            for (YieldStock stock : highYieldETFs) {
                System.out.println("YieldViewController: Loading StockCard for Ticker: " + stock.getTicker());
                // CORRECTED PATH HERE: changed . to / in edu.miracosta.cs112
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/StockCard.fxml"));
                AnchorPane stockCardPane = fxmlLoader.load();
                StockCardController stockCardController = fxmlLoader.getController();
                stockCardController.setStockData(stock);
                stockCardsVBox.getChildren().add(stockCardPane);
                System.out.println("YieldViewController: Added StockCard for Ticker: " + stock.getTicker() + " to VBox.");
            }
            if (highYieldETFs.isEmpty()) {
                System.out.println("YieldViewController: No stocks loaded, VBox will be empty (apart from title).");
            }
        } catch (IOException e) {
            System.err.println("YieldViewController ERROR: Error loading stock data or FXML for stock cards: " + e.getMessage());
            e.printStackTrace();
            // Optionally, display an error message to the user in the UI
        }
    }
}
