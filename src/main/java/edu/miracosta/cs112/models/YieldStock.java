package edu.miracosta.cs112.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class YieldStock extends FinancialInstrument {
    private DoubleProperty distributionYield = new SimpleDoubleProperty();
    private StringProperty sentiment = new SimpleStringProperty(); // New field
    private StringProperty price24hrData = new SimpleStringProperty(); // New field for sparkline data (e.g., comma-separated values)

    // 1. Default Constructor
    public YieldStock() {
        super("Unknown", 0.0);
        //this.distributionYield = 0.0;
        this.distributionYield.set(0.0);
        this.sentiment.set("Neutral");
        this.price24hrData.set("");
    }

    // 2. Partial Constructor (existing, updated with new defaults)
    public YieldStock(String ticker, double price) {
        super(ticker, price);
        this.distributionYield.set(0.0);
        this.sentiment.set("Neutral");
        this.price24hrData.set("");
    }

    // 3. Full Constructor (existing, updated with new defaults)
    public YieldStock(String ticker, double price, double distributionYield) {
        super(ticker, price);
        this.distributionYield.set(distributionYield);
        this.sentiment.set("Neutral");
        this.price24hrData.set("");
    }

    // 4. CSV Constructor (new)
    public YieldStock(String ticker, double price, double distributionYield, String sentiment, String price24hrData) {
        super(ticker, price);
        this.distributionYield.set(distributionYield);
        this.sentiment.set(sentiment);
        this.price24hrData.set(price24hrData);
    }

    public DoubleProperty getDistributionYield() { return distributionYield; }
    public void setDistributionYield(double distributionYield) { this.distributionYield.set(distributionYield); }

    public StringProperty getSentiment() { return sentiment; }
    public void setSentiment(String sentiment) { this.sentiment.set(sentiment); }

    public StringProperty getPrice24hrData() { return price24hrData; }
    public void setPrice24hrData(String price24hrData) { this.price24hrData.set(price24hrData); }

    @Override
    public double calculateRisk(double vix) {
        return (vix * distributionYield.getValue()) / 100.0;
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
        return Double.compare(that.distributionYield.getValue(), distributionYield.getValue()) == 0 &&
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


/* create object or class that accepts csv > maps data directly onto an object by row.
use class to call from model of data in the csv (use array list of all data, and use data as object for calculations)
 */