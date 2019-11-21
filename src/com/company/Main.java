package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ProjectTeam> projects = new ArrayList<>();
        ArrayList<Programmers> programmers = new ArrayList<>();

        ManageDatabase.load(projects, programmers);
//        for (int i = 0; i < projects.size(); i++) {
//            System.out.println(projects.get(i).getId());
//            System.out.println(projects.get(i).getName());
//            System.out.println(projects.get(i).getStartDate());
//        }

//	     Menu.menu(projects, programmers);
    }
}
