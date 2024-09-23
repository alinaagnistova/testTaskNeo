package org.example.taskneo;

import org.example.taskneo.controller.VacationPayController;
import org.example.taskneo.model.Account;
import org.example.taskneo.service.VacationPayService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TestTaskNeoApplicationTests {
    private final VacationPayService vacationPayService = new VacationPayService();
    private final VacationPayController calculator = new VacationPayController(vacationPayService);

    @Test
    void contextLoads() {
    }
    @Test
    void testStandardCalculation(){
        double result = calculator.calculate(new Account(2000,10, null, null));
        assertEquals(682.59, result, 0.01);
    }
    @Test
    void testZeroSalary(){
        double result = calculator.calculate(new Account(0,10, null, null));
        assertEquals(0, result, 0.01);
    }
    @Test
    void testWithStartEndDates(){
        double result = calculator.calculate(new Account(2000,5, LocalDate.of(2024,9,9), LocalDate.of(2024,9,13)));
        assertEquals(341.29, result, 0.01);
    }


}
