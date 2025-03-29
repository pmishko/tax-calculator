package com.taxation.TaxCalculator;

public class BetRequest {
    private int traderId;
    private double playedAmount;
    private double odd;

    public BetRequest(){}

    public BetRequest(int traderId, double playedAmount, double odd) {
        this.traderId = traderId;
        this.playedAmount = playedAmount;
        this.odd = odd;
    }

    public int getTraderId() {
        return traderId;
    }

    public double getPlayedAmount() {
        return playedAmount;
    }

    public double getOdd() {
        return odd;
    }
}
