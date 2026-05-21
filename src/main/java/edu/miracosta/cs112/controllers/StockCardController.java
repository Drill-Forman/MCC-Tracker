package edu.miracosta.cs112.controllers;

import edu.miracosta.cs112.models.YieldStock;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import java.text.DecimalFormat;

public class StockCardController {

    @FXML private Label tickerLabel;
    @FXML private Label priceLabel;
    @FXML private Label ivLabel;
    @FXML private Label sentimentLabel;
    @FXML private Region sparklineRegion; // Placeholder for sparkline

    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("$#,##0.00");
    private static final DecimalFormat PERCENT_FORMAT = new DecimalFormat("0.00%");

    public void setStockData(YieldStock stock) {
        tickerLabel.setText(stock.getTicker());
        priceLabel.setText(CURRENCY_FORMAT.format(stock.getPrice()));

        // Assuming distributionYield is used as a proxy for IV for now
        // In a real scenario, IV would be calculated or fetched separately
        double impliedVolatility = stock.getDistributionYield().getValue(); // Using distributionYield as IV placeholder
        ivLabel.setText(PERCENT_FORMAT.format(impliedVolatility / 100.0));

        sentimentLabel.setText(stock.getSentiment().getValue());

        // For sparkline, we'll just show the raw data string for now
        // A proper sparkline implementation would involve drawing on a Canvas or similar
        // sparklineRegion.setStyle("-fx-background-color: lightgreen;"); // Example visual change
        // You could parse stock.getPrice24hrData() and draw here
    }
}
