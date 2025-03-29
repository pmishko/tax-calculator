package com.taxation.TaxCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

public class TaxCalculatorServiceTest {

    @Mock
    private TraderConfigRepository configRepository;
    @InjectMocks
    private TaxCalculatorService taxCalculatorService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(configRepository.getTraderConfiguration(1))
                .thenReturn(new TraderConfiguration(1, TaxType.GENERAL, TaxMethod.RATE, 0.1));

        when(configRepository.getTraderConfiguration(2))
                .thenReturn(new TraderConfiguration(2, TaxType.GENERAL, TaxMethod.AMOUNT, 2));

        when(configRepository.getTraderConfiguration(3))
                .thenReturn(new TraderConfiguration(3, TaxType.WINNINGS, TaxMethod.RATE, 0.1));

        when(configRepository.getTraderConfiguration(4))
                .thenReturn(new TraderConfiguration(4, TaxType.WINNINGS, TaxMethod.AMOUNT, 2));
    }

    @Test
    void test_trader_1_general_tax_rate() {
        BetRequest request = new BetRequest(1, 5, 2);
        BetResponse response = taxCalculatorService.calculateReturn(request);

        assertEquals(10.0, response.getPossibleReturnAmount());
        assertEquals(10.0, response.getPossibleReturnAmountBefTax());
        assertEquals(0.1, response.getTaxRate());
        assertEquals(1.0, response.getTaxAmount());
        assertEquals(9.0, response.getPossibleReturnAmountAfterTax());
    }

    @Test
    void test_trader_2_general_tax_amount() {
        BetRequest request = new BetRequest(2, 5, 2);
        BetResponse response = taxCalculatorService.calculateReturn(request);

        assertEquals(10.0, response.getPossibleReturnAmount());
        assertEquals(10.0, response.getPossibleReturnAmountBefTax());
        assertEquals(0.2, response.getTaxRate());
        assertEquals(2.0, response.getTaxAmount());
        assertEquals(8.0, response.getPossibleReturnAmountAfterTax());
    }

    @Test
    void test_trader_3_winnings_tax_rate() {
        BetRequest request = new BetRequest(3, 5, 2);
        BetResponse response = taxCalculatorService.calculateReturn(request);

        assertEquals(10.0, response.getPossibleReturnAmount());
        assertEquals(10.0, response.getPossibleReturnAmountBefTax());
        assertEquals(0.1, response.getTaxRate());
        assertEquals(0.5, response.getTaxAmount());
        assertEquals(9.5, response.getPossibleReturnAmountAfterTax());
    }

    @Test
    void test_trader_4_winnings_tax_amount() {
        BetRequest request = new BetRequest(4, 5, 2);
        BetResponse response = taxCalculatorService.calculateReturn(request);

        assertEquals(10.0, response.getPossibleReturnAmount());
        assertEquals(10.0, response.getPossibleReturnAmountBefTax());
        assertEquals(0.6, response.getTaxRate());
        assertEquals(3.0, response.getTaxAmount());
        assertEquals(7.0, response.getPossibleReturnAmountAfterTax());
    }
}
