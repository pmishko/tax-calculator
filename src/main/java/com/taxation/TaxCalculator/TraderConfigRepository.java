package com.taxation.TaxCalculator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TraderConfigRepository {
    private final Map<Integer, TraderConfiguration> traderConfig = new HashMap<>();

    @PostConstruct
    public void init(){
        traderConfig.put(1, new TraderConfiguration(1, TaxType.GENERAL, TaxMethod.RATE, 0.1));
        traderConfig.put(2, new TraderConfiguration(2, TaxType.GENERAL, TaxMethod.AMOUNT, 2));
        traderConfig.put(3, new TraderConfiguration(3, TaxType.WINNINGS, TaxMethod.RATE, 0.1));
        traderConfig.put(4, new TraderConfiguration(4, TaxType.WINNINGS, TaxMethod.AMOUNT, 2));
    }

    public TraderConfiguration getTraderConfiguration(int traderId) {
        return traderConfig.getOrDefault(traderId,
                // return something in case of traderId > 4
                new TraderConfiguration(traderId, TaxType.GENERAL, TaxMethod.RATE, 0.1));
    }
}
