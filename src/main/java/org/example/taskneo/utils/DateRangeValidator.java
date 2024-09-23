package org.example.taskneo.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.taskneo.model.Account;

import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<DateRange, Account> {

    @Override
    public boolean isValid(Account account, ConstraintValidatorContext context) {
        if (account.getStartDate() == null || account.getEndDate() == null) {
            return true;
        }
        LocalDate startDate = account.getStartDate();
        LocalDate endDate = account.getEndDate();
        return startDate.isBefore(endDate);
    }
}

