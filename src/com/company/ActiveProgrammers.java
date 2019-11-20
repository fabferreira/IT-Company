package com.company;

import java.time.LocalDate;

public class ActiveProgrammers implements Programmers{
    private int id;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String status;
    private String project;
    private String activity;
    private java.time.LocalDate startDate;
    private java.time.LocalDate endDate;
    private int duration;
    private int workedDays;
    private double salary;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
