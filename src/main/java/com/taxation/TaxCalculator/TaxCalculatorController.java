package com.taxation.TaxCalculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class TaxCalculatorController {

    private final TaxCalculatorService taxCalculatorService;

    public TaxCalculatorController(TaxCalculatorService taxCalculatorService) {
        this.taxCalculatorService = taxCalculatorService;
    }

    @PostMapping("/calculate-return")
    public BetResponse calculateReturn(@RequestBody BetRequest betRequest) {
        return taxCalculatorService.calculateReturn(betRequest);
    }
}
