package edu.miracosta.cs112.models;

import java.util.Objects;

public class YieldStock extends FinancialInstrument {
    private double distributionYield;
    private String sentiment; // New field
    private String price24hrData; // New field for sparkline data (e.g., comma-separated values)

    // 1. Default Constructor
    public YieldStock() {
        super("Unknown", 0.0);
        this.distributionYield = 0.0;
        this.sentiment = "Neutral";
        this.price24hrData = "";
    }

    // 2. Partial Constructor (existing, updated with new defaults)
    public YieldStock(String ticker, double price) {
        super(ticker, price);
        this.distributionYield = 0.0;
        this.sentiment = "Neutral";
        this.price24hrData = "";
    }

    // 3. Full Constructor (existing, updated with new defaults)
    public YieldStock(String ticker, double price, double distributionYield) {
        super(ticker, price);
        this.distributionYield = distributionYield;
        this.sentiment = "Neutral";
        this.price24hrData = "";
    }

    // 4. CSV Constructor (new)
    public YieldStock(String ticker, double price, double distributionYield, String sentiment, String price24hrData) {
        super(ticker, price);
        this.distributionYield = distributionYield;
        this.sentiment = sentiment;
        this.price24hrData = price24hrData;
    }

    public double getDistributionYield() { return distributionYield; }
    public void setDistributionYield(double distributionYield) { this.distributionYield = distributionYield; }

    public String getSentiment() { return sentiment; }
    public void setSentiment(String sentiment) { this.sentiment = sentiment; }

    public String getPrice24hrData() { return price24hrData; }
    public void setPrice24hrData(String price24hrData) { this.price24hrData = price24hrData; }

    @Override
    public double calculateRisk(double vix) {
        return (vix * distributionYield) / 100.0;
    }

    @Override
    public String toString() {
        return "YieldStock{" +
                "ticker='" + getTicker() + '\'' +
                ", price=" + getPrice() +
                ", distributionYield=" + distributionYield +
                ", sentiment='" + sentiment + '\'' +
                ", price24hrData='" + price24hrData + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YieldStock that = (YieldStock) o;
        return Double.compare(that.distributionYield, distributionYield) == 0 &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getTicker(), that.getTicker()) &&
                Objects.equals(sentiment, that.sentiment) &&
                Objects.equals(price24hrData, that.price24hrData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicker(), getPrice(), distributionYield, sentiment, price24hrData);
    }
}
