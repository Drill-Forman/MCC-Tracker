package edu.miracosta.cs112.models;

import java.util.Objects;

public class YieldStock extends FinancialInstrument {
    private double distributionYield;

    // 1. Default Constructor
    public YieldStock() {
        super("Unknown", 0.0);
        this.distributionYield = 0.0;
    }

    // 2. Partial Constructor
    public YieldStock(String ticker, double price) {
        super(ticker, price);
        this.distributionYield = 0.0;
    }

    // 3. Full Constructor
    public YieldStock(String ticker, double price, double distributionYield) {
        super(ticker, price);
        this.distributionYield = distributionYield;
    }

    public double getDistributionYield() { return distributionYield; }
    public void setDistributionYield(double distributionYield) { this.distributionYield = distributionYield; }

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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YieldStock that = (YieldStock) o;
        return Double.compare(that.distributionYield, distributionYield) == 0 &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getTicker(), that.getTicker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicker(), getPrice(), distributionYield);
    }
}