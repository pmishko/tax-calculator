package com.taxation.TaxCalculator;

public class TraderConfiguration {
    private int traderId;
    private TaxType taxType;
    private TaxMethod taxMethod;
    private double taxValue;

    public TraderConfiguration(int traderId, TaxType taxType, TaxMethod taxMethod, double taxValue) {
        this.traderId = traderId;
        this.taxType = taxType;
        this.taxMethod = taxMethod;
        this.taxValue = taxValue;
    }

    public int getTraderId() {
        return traderId;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public TaxMethod getTaxMethod() {
        return taxMethod;
    }

    public double getTaxValue() {
        return taxValue;
    }
}
