package com.company;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ActiveProgrammers implements Programmers{
    private int id;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String project;
    private String activity;
    private LocalDate startDate;
    private LocalDate endDate;
    private int workedDays;
    private int month;
    private double wage;
    private String salary;

    public ActiveProgrammers(int id, String firstName, String lastName, double wage, String salary) {
        this(id, firstName, lastName, false, "", "", LocalDate.parse("0000-01-01"), LocalDate.parse("0000-01-01"), 0, LocalDate.now().getMonthValue(), wage, salary);
    }

    public ActiveProgrammers(int id, String firstName, String lastName, boolean isActive, String project, String activity, LocalDate startDate, LocalDate endDate, int workedDays, int month, double wage, String salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.project = project;
        this.activity = activity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workedDays = workedDays;
        this.month = month;
        this.wage = wage;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    @Override
    public long calcDuration(LocalDate startDate, LocalDate endDate) {
        return DAYS.between(startDate, endDate);
    }

    @Override
    public int calcWorkedDays(LocalDate startDate, LocalDate currentDate, int workedDays) {
        if (startDate.getMonthValue() != currentDate.getMonthValue()) {
            return currentDate.getDayOfMonth() + workedDays;
        } else {
            return currentDate.getDayOfMonth() - startDate.getDayOfMonth() + 1 + workedDays;
        }
    }

    @Override
    public double calcSalary(String salary, double wage, int daysWorked) {
        if (salary.equals("full")) {
            return daysWorked * wage;
        } else if (salary.equals("half")) {
            return daysWorked * wage * 0.5;
        } else {
            return 0.00;
        }
    }
}
