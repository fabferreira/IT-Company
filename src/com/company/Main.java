package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ProjectTeam> projects = new ArrayList<>();
        ArrayList<ActiveProgrammers> programmers = new ArrayList<>();
        LocalDate date = LocalDate.now(); // mudar esta data para a data do ficheiro

        ManageDatabase.load(projects, programmers);
        Menu.showReport(projects, programmers, date);

//        for (ProjectTeam project : projects) {
//            System.out.println(project.getId());
//            System.out.println(project.getName());
//            System.out.println(project.getStartDate());
//        }
//
//        for (ActiveProgrammers programmer : programmers) {
//            System.out.println(programmer.getId());
//            System.out.println(programmer.getFirstName());
//            System.out.println(programmer.getStartDate());
//        }


//	     Menu.menu(projects, programmers);
    }
}
