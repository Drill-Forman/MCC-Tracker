package edu.miracosta.cs112.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class YieldStockCsvReader {

    private static final String CSV_FILE_NAME = "yield_stocks.csv"; // Default CSV file name

    /**
     * Reads YieldStock data from a CSV file located in the resources folder.
     * The CSV format is: ticker,price,distributionYield,sentiment,price24hrData
     *
     * @return An ArrayList of YieldStock objects.
     * @throws IOException If an I/O error occurs.
     */
    public static ArrayList<YieldStock> readYieldStocksFromResources() throws IOException {
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        URL resource = YieldStockCsvReader.class.getResource("/" + CSV_FILE_NAME);

        if (resource == null) {
            throw new IOException("CSV file not found in resources: " + CSV_FILE_NAME);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            String line;
            // Skip header if present
            // br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        String ticker = data[0].trim();
                        double price = Double.parseDouble(data[1].trim());
                        double distributionYield = Double.parseDouble(data[2].trim());
                        String sentiment = data[3].trim();
                        String price24hrData = data[4].trim();

                        yieldStocks.add(new YieldStock(ticker, price, distributionYield, sentiment, price24hrData));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping malformed line (NumberFormatException): " + line);
                    }
                } else {
                    System.err.println("Skipping malformed line (incorrect number of fields): " + line);
                }
            }
        }
        return yieldStocks;
    }

    /**
     * Reads YieldStock data from a specified CSV file path.
     * The CSV format is: ticker,price,distributionYield,sentiment,price24hrData
     *
     * @param filePath The absolute path to the CSV file.
     * @return An ArrayList of YieldStock objects.
     * @throws IOException If an I/O error occurs.
     */
    public static ArrayList<YieldStock> readYieldStocksFromFile(String filePath) throws IOException {
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header if present
            // br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        String ticker = data[0].trim();
                        double price = Double.parseDouble(data[1].trim());
                        double distributionYield = Double.parseDouble(data[2].trim());
                        String sentiment = data[3].trim();
                        String price24hrData = data[4].trim();

                        yieldStocks.add(new YieldStock(ticker, price, distributionYield, sentiment, price24hrData));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping malformed line (NumberFormatException): " + line);
                    }
                } else {
                    System.err.println("Skipping malformed line (incorrect number of fields): " + line);
                }
            }
        }
        return yieldStocks;
    }
}
