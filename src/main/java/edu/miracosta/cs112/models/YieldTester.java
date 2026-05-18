package edu.miracosta.cs112.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YieldTester {
    public static void main(String[] args) {
        System.out.println("--- Testing YieldStock Model ---");

        List<FinancialInstrument> portfolio = new ArrayList<>();

        try {
            // Load stocks from CSV using the new reader
            ArrayList<YieldStock> loadedStocks = YieldStockCsvReader.readYieldStocksFromResources();
            portfolio.addAll(loadedStocks);
        } catch (IOException e) {
            System.err.println("Error loading stocks from CSV: " + e.getMessage());
            e.printStackTrace();
            // Fallback or exit if data loading is critical
            System.out.println("Using dummy data for testing due to CSV loading error.");
            portfolio.add(new YieldStock("NVDY", 25.50, 50.0, "75% Buy", "10,12,11,13"));
            portfolio.add(new YieldStock("TSLY", 15.00, 60.0, "60% Hold", "15,14,16,15"));
        }


        double currentVix = 20.0;
        for (FinancialInstrument f : portfolio) {
            System.out.println("Ticker: " + f.getTicker() +
                               ", Price: " + f.getPrice() +
                               ", Risk: " + f.calculateRisk(currentVix));
            if (f instanceof YieldStock) {
                YieldStock ys = (YieldStock) f;
                System.out.println("  Distribution Yield: " + ys.getDistributionYield() +
                                   ", Sentiment: " + ys.getSentiment() +
                                   ", 24hr Data: " + ys.getPrice24hrData());
            }
        }

        System.out.println("Test Complete.");
    }
}
