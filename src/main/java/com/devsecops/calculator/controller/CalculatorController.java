package com.devsecops.calculator.controller;

import com.devsecops.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calc")
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return service.add(a, b);
    }

    @GetMapping("/sub")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return service.subtract(a, b);
    }
}
