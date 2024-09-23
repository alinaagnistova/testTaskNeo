package org.example.taskneo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.taskneo.model.Account;
import org.example.taskneo.service.VacationPayService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController()
public class VacationPayController {
    private final VacationPayService vacationPayService;

    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping(value = "/calculate")
    public double calculate(@Valid @RequestBody Account account) {
        return vacationPayService.calculate(account);
    }
}

