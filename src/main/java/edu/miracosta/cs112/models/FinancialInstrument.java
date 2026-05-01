package edu.miracosta.cs112.models;

public abstract class FinancialInstrument {
    private String ticker;
    private double price;

    public FinancialInstrument(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() { return ticker; }
    public double getPrice() { return price; }

    public void setTicker(String ticker) { this.ticker = ticker; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateRisk(double vix);
}