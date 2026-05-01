package edu.miracosta.cs112.models;

import java.util.ArrayList;
import java.util.List;

public class YieldTester {
    public static void main(String[] args) {
        System.out.println("--- Testing YieldStock Model ---");

        YieldStock stock1 = new YieldStock("NVDY", 25.50, 50.0);
        YieldStock stock2 = new YieldStock("TSLY", 15.00, 60.0);

        List<FinancialInstrument> portfolio = new ArrayList<>();
        portfolio.add(stock1);
        portfolio.add(stock2);

        double currentVix = 20.0;
        for (FinancialInstrument f : portfolio) {
            System.out.println(f.getTicker() + " Risk: " + f.calculateRisk(currentVix));
        }

        System.out.println("Test Complete.");
    }
}