package com.company;

import java.time.LocalDate;

public interface Programmers {
    long calcDuration(LocalDate startDate, LocalDate endDate);
    int calcWorkedDays(LocalDate startDate, LocalDate currentDate, int workedDays);
    double calcSalary(String salary, double wage, int daysWorked);
}
