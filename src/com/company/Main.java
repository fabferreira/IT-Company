package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ProjectTeam> projects = new ArrayList<>();
        ArrayList<ActiveProgrammers> programmers = new ArrayList<>();

        ManageDatabase.load(projects, programmers);
        LocalDate date = ManageDatabase.loadDate();
        updateData(projects, programmers, date);
        Menu.menu(projects, programmers, date);
    }

    private static void updateData(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        date = date.plusDays(1);
        for (ProjectTeam proj : projects) {
            if (proj.getEndDate().isBefore(date)){
                Menu.removeProject(projects, programmers, date);
            }
        }
        for (int i = 0; i < programmers.size(); i++) {
            if (programmers.get(i).getEndDate().isBefore(date)) {
                Menu.inactivateProgrammer(projects, programmers, date, i);
            }
        }
    }
}
