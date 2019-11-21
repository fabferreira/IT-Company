package com.company;

import java.time.LocalDate;

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
        this(id, firstName, lastName, false, "", "", LocalDate.parse("0000-00-00"), LocalDate.parse("0000-00-00"), 0, LocalDate.now().getMonthValue(), wage, salary);
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

    public void setId(int id) {
        this.id = id;
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
    public void editPersonalInfo() {

    }

    @Override
    public void editProjectDetails() {

    }

    @Override
    public int calcDuration() {
        return 0;
    }

    @Override
    public int calcWorkedDays() {
        return 0;
    }

    @Override
    public double calcSalary() {
        return 0;
    }
}
