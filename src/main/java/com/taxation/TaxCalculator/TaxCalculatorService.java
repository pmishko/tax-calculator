package com.taxation.TaxCalculator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TaxCalculatorService {
    private final TraderConfigRepository configRepository;

    public  TaxCalculatorService (TraderConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public BetResponse calculateReturn(BetRequest request) {
        TraderConfiguration config = configRepository
                .getTraderConfiguration(request.getTraderId());
        double playedAmount = request.getPlayedAmount();
        if (playedAmount <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Played amount can't be 0 or less. Played amount: " + playedAmount);
        }
        double odd = request.getOdd();
        double grossPayout = odd * playedAmount;
        double taxBase;
        double taxAmount;
        double taxRate = 0;
        double netReturn;

        if (config.getTaxType() == TaxType.GENERAL) {
            // Apply tax on the entire gross payout
            taxBase = grossPayout;
            if (config.getTaxMethod() == TaxMethod.AMOUNT) {
                taxAmount = config.getTaxValue();
                taxRate = taxAmount / taxBase;
            } else {
                taxAmount = taxBase * config.getTaxValue();
                taxRate = config.getTaxValue();
            }
            netReturn = grossPayout - taxAmount;
        } else {
            // Apply tax only on the winnings
            taxBase = grossPayout - playedAmount;
            if (config.getTaxMethod() == TaxMethod.AMOUNT) {
                taxAmount = taxBase - config.getTaxValue();
                taxRate = taxAmount / taxBase;
            } else {
                taxAmount = taxBase * config.getTaxValue();
                taxRate = config.getTaxValue();
            }
            netReturn = grossPayout - taxAmount;
        }
        return new BetResponse(
                grossPayout,
                grossPayout,
                netReturn,
                taxRate,
                taxAmount
        );
    }
}
