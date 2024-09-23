package org.example.taskneo.utils;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class Holidays {
    private LocalDate start;
    private LocalDate end;
    private int vacationDays;
    private Set<LocalDate> holidays = new HashSet<>();


    public Holidays(LocalDate start, LocalDate end, int vacationDays) {
        this.start = start;
        this.end = end;
        this.vacationDays = vacationDays;
        fillCalendar();
    }

    public void fillCalendar() {
        int year = start.getYear();
        //january holidays
        holidays.add(LocalDate.of(year, 1, 1));
        holidays.add(LocalDate.of(year, 1, 2));
        holidays.add(LocalDate.of(year, 1, 3));
        holidays.add(LocalDate.of(year, 1, 4));
        holidays.add(LocalDate.of(year, 1, 5));
        holidays.add(LocalDate.of(year, 1, 8));
        // holidays
        holidays.add(LocalDate.of(year, 2, 23));
        holidays.add(LocalDate.of(year, 3, 8));
        holidays.add(LocalDate.of(year, 5, 1));
        holidays.add(LocalDate.of(year, 5, 9));
        holidays.add(LocalDate.of(year, 6, 12));
        //december holidays
        holidays.add(LocalDate.of(year, 12, 30));
        holidays.add(LocalDate.of(year, 12, 31));
        //weekends
        for (int i = 0; i < vacationDays; i++) {
            LocalDate date = start.plusDays(i);
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                holidays.add(date); // add saturdays and sundays
            }
        }
    }

    public Set<LocalDate> getHolidaysInRange(LocalDate from, LocalDate to) {
        return holidays.stream()
                .filter(date -> !date.isBefore(from) && !date.isAfter(to))
                .collect(Collectors.toSet());
    }
}
