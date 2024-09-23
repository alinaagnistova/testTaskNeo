package org.example.taskneo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.taskneo.utils.DateRange;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@DateRange(message = "Start date should be before end date")
public class Account {
    @Min(value = 0, message = "Minimum average salary is 0")
    @NotNull(message = "Can't be null")
    @JsonProperty("salary")
    private double averageSalary;
    @Min(value = 0, message = "Minimum vacation days is 0")
    @NotNull(message = "Can't be null")
    @JsonProperty("days")
    private int vacationDays;
    @JsonProperty("start")
    private LocalDate startDate;
    @JsonProperty("end")
    private LocalDate endDate;
}
