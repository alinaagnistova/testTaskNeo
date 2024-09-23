package org.example.taskneo.service;

import jakarta.validation.Valid;
import org.example.taskneo.model.Account;
import org.example.taskneo.utils.Holidays;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class VacationPayService {
    public double calculate(Account account) {
        double avgDays = 29.3;
        double dailySalary = account.getAverageSalary() / avgDays;
        double vacationSalary = account.getVacationDays() * dailySalary;
        if (!(account.getStartDate() == null) && !(account.getEndDate() == null)) {
            Holidays holidays = new Holidays(account.getStartDate(), account.getEndDate(), account.getVacationDays());
            Set<LocalDate> dates = holidays.getHolidaysInRange(account.getStartDate(), account.getEndDate());
            vacationSalary -= dailySalary * dates.size();
        }
        return vacationSalary;
    }
}
