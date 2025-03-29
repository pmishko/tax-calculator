package com.taxation.TaxCalculator;

public class BetResponse {
    private double possibleReturnAmount;
    private double possibleReturnAmountBefTax;
    private double possibleReturnAmountAfterTax;
    private double taxRate;
    private double taxAmount;

    public BetResponse(double possibleReturnAmount, double possibleReturnAmountBefTax,
                       double possibleReturnAmountAfterTax, double taxRate, double taxAmount) {
        this.possibleReturnAmount = possibleReturnAmount;
        this.possibleReturnAmountBefTax = possibleReturnAmountBefTax;
        this.possibleReturnAmountAfterTax = possibleReturnAmountAfterTax;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
    }

    public double getPossibleReturnAmount() {
        return possibleReturnAmount;
    }

    public double getPossibleReturnAmountBefTax() {
        return possibleReturnAmountBefTax;
    }

    public double getPossibleReturnAmountAfterTax() {
        return possibleReturnAmountAfterTax;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }
}
