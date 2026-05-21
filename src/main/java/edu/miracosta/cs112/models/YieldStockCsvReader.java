package edu.miracosta.cs112.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class YieldStockCsvReader {

    // Updated CSV_FILE_NAME to include the new directory
    private static final String CSV_FILE_NAME = "Stock Info/yield_stocks.csv";

    /**
     * Reads YieldStock data from a CSV file located in the resources folder.
     * The CSV format is: ticker,price,distributionYield,sentiment,price24hrData
     *
     * @return An ArrayList of YieldStock objects.
     * @throws IOException If an I/O error occurs.
     */
    public static ArrayList<YieldStock> readYieldStocksFromResources() throws IOException {
        System.out.println("YieldStockCsvReader: Attempting to read CSV from resources: " + CSV_FILE_NAME);
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        URL resource = YieldStockCsvReader.class.getResource("/" + CSV_FILE_NAME);

        if (resource == null) {
            System.err.println("YieldStockCsvReader ERROR: CSV file not found in resources: " + CSV_FILE_NAME);
            throw new IOException("CSV file not found in resources: " + CSV_FILE_NAME);
        }
        System.out.println("YieldStockCsvReader: Found resource at: " + resource.toExternalForm());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            String line;
            int lineNumber = 0;
            // Skip header if present (uncomment if your CSV has a header row)
            // br.readLine();
            while ((line = br.readLine()) != null) {
                lineNumber++;
                System.out.println("YieldStockCsvReader: Reading line " + lineNumber + ": " + line);
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        String ticker = data[0].trim();
                        double price = Double.parseDouble(data[1].trim());
                        double distributionYield = Double.parseDouble(data[2].trim());
                        String sentiment = data[3].trim();
                        String price24hrData = data[4].trim();

                        YieldStock newStock = new YieldStock(ticker, price, distributionYield, sentiment, price24hrData);
                        yieldStocks.add(newStock);
                        System.out.println("YieldStockCsvReader: Successfully parsed and added: " + newStock.getTicker());
                    } catch (NumberFormatException e) {
                        System.err.println("YieldStockCsvReader ERROR: Skipping malformed line " + lineNumber + " (NumberFormatException): " + line + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("YieldStockCsvReader ERROR: Skipping malformed line " + lineNumber + " (incorrect number of fields: " + data.length + " instead of 5): " + line);
                }
            }
        } catch (IOException ioe) {
            System.err.println("YieldStockCsvReader ERROR: IOException while reading CSV: " + ioe.getMessage());
            throw ioe; // Re-throw the exception
        }
        System.out.println("YieldStockCsvReader: Finished reading CSV. Total stocks loaded: " + yieldStocks.size());
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
