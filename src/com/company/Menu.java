package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Menu {
    private ArrayList<ProjectTeam> newProjects = new ArrayList<>();
    private ArrayList<ActiveProgrammers> newProgrammers = new ArrayList<>();

    public static void menu(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while(!quit) {
            MainMenu();
            int action = scanner.nextInt();
            switch(action) {
                case 1:
                    projectsMenu(projects,programmers, date);
                    continue;

                case 2:
                    programmersMenu(projects,programmers, date);
                    continue;

                case 3:
                    showReport(projects, programmers, date);
                    continue;

                case 4:
                    ManageDatabase.save(projects, programmers, date);
                    continue;

                case 5:
                    ManageDatabase.load(projects, programmers);
                    continue;

                case 6:
                    quit = true;
                    ManageDatabase.save(projects,programmers, date);
                    showReport(projects, programmers, date);
                    continue;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
            }
        }
    }

    private static void MainMenu() {
        System.out.println("====== Main Menu ======");
        System.out.println("Please Select one of the following options:");
        System.out.println("1. Projects");
        System.out.println("2. Programmers");
        System.out.println("3. Report");
        System.out.println("4. Save");
        System.out.println("5. Load");
        System.out.println("6. Quit");
    }

    private static void projectsMenu(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        Scanner scanner = new Scanner(System.in);
        int actproj = 0;

        while(actproj != 4) {

            System.out.println("====== Project Menu ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Add New Project");
            System.out.println("2. Remove Project");
            System.out.println("3. Extend Project");
            System.out.println("4. Back");

            actproj = scanner.nextInt();
            switch (actproj) {
                case 1:
                    addProject(projects, programmers, date);
                    continue;

                case 2:
                    removeProject(projects, programmers, date);
                    continue;

                case 3:
                    extendProject(projects, programmers);
                    continue;

                case 4:
                    continue;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
            }
        }
    }

    private static void programmersMenu(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        Scanner scanner = new Scanner(System.in);
        int actprog = 0;
        while(actprog != 5) {

            System.out.println("====== Programmer Menu ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Add New Programmer without Project");
            System.out.println("2. Add Programmer to a Project");
            System.out.println("3. Edit Programmer");
            System.out.println("4. Inactivate Programmer");
            System.out.println("5. Back");

            actprog = scanner.nextInt();
            switch (actprog) {
                case 1:
                    addProgrammer(projects, programmers, "", LocalDate.parse("0001-01-01"), date);
                    continue;

                case 2:
                    addProgrammer(projects, programmers, "exists", LocalDate.parse("0001-01-01"), date);
                    continue;

                case 3:
                    editProgMenu(projects, programmers, date);
                    System.out.println("Edition Completed");
                    continue;

                case 4:
                    inactivateProgrammer(projects, programmers, date, -1);
                    System.out.println("Programmer inactivated");
                    continue;

                case 5:
                    continue;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
            }
        }
    }

    private static void extendProject(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers) {
        Scanner scanner = new Scanner(System.in);
        String nameProj = "";
        LocalDate newEndDate = null;
        LocalDate endDate = null;
        System.out.println("Please choose a Project to remove");
        for (int i = 0; i < projects.size(); i++) {
            System.out.println(i+1 + " " + projects.get(i).getName());
        }
        boolean next = false;
        while(!next) {
            String idStr = scanner.nextLine();
            int id;
            try {
                id = Integer.parseInt(idStr) - 1;
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
                continue;
            }
            if (0 <= id && id < projects.size()) {
                nameProj = projects.get(id - 1).getName();
                endDate = projects.get(id - 1).getEndDate();
                next = true;
            }
        }

        // user input project end date
        System.out.println("Please choose an end date (yyyy-MM-dd):");
        next = false;
        while (!next) {
            String end = scanner.nextLine();
            try {
                newEndDate = LocalDate.parse(end);
                if (newEndDate.isAfter(endDate)) {
                    next = true;
                } else {
                    System.out.println("Please insert a date after the current termination date");
                }
            } catch (Exception e) {
                System.out.println("Please insert a valid date (yyyy-MM-dd).");
            }
        }


        System.out.println("Do you want to extend all project programmers end date? (s/n)");
        String refreshProgrammers = scanner.nextLine();
        while (!refreshProgrammers.toLowerCase().equals("s") || !refreshProgrammers.toLowerCase().equals("n")) {
            System.out.println("Please choose a valid option (s/n)");
            refreshProgrammers = scanner.nextLine();
        }
        if (refreshProgrammers.equals("s")) {
            for (ActiveProgrammers programmer : programmers) {
                if (programmer.getProject().equals(nameProj)) {
                    programmer.setEndDate(newEndDate);
                }
            }
        }
        System.out.println("Project successfully remove and programmers inactivated");
    }

    private static void editProgMenu(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        Scanner scanner = new Scanner(System.in);
        int edprog = 0;
        while(edprog != 9) {

            System.out.println("====== Edit Programmer ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Edit Activity");
            System.out.println("2. Edit End Date");
            System.out.println("3. Edit Wage");
            System.out.println("4. Edit % Salary");
            System.out.println("5. Back");

            edprog = scanner.nextInt();
            switch (edprog) {
                case 1:
                    changeActivity(programmers);
                    continue;

                case 2:
                    changeEndDate(projects, programmers);
                    continue;

                case 3:
                    changeWage(programmers);
                    continue;

                case 4:
                    changeSalary(programmers);
                    continue;

                case 9:
                    continue;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
            }
        }
    }

    private static void showReport(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        int totalTeams;
        int totalProgrammers;
        int totalActive;
        int totalDays = 0;
        int totalLeft = 0;
        ArrayList<String> toPrint = new ArrayList<>();
        totalTeams = projects.size();
        totalProgrammers = programmers.size();
        totalActive = 0;
        for (ActiveProgrammers programmer : programmers) {
            if (programmer.isActive()) {
                totalActive++;
            }
        }

        for (ProjectTeam project : projects) {
            String name = project.getName();
            toPrint.add("\n*** Project team: " + name + " ***");
            String firstName;
            String lastName;
            String activity;
            LocalDate startDate;
            LocalDate endDate;
            long duration;
            int daysWorked;
            double salary = 0.00;
            for (ActiveProgrammers programmer : programmers) {
                if (!programmer.isActive()) {
                    totalLeft += programmer.getWorkedDays();
                }
                if (programmer.getProject().equals(name)) {
                    firstName = programmer.getFirstName();
                    lastName = programmer.getLastName();
                    activity = programmer.getActivity();
                    startDate = programmer.getStartDate();
                    endDate = programmer.getEndDate();
                    duration = DAYS.between(startDate, endDate);
                    if (startDate.getMonthValue() != date.getMonthValue()) {
                        daysWorked = date.getDayOfMonth() + programmer.getWorkedDays();
                    } else {
                        daysWorked = date.getDayOfMonth() - startDate.getDayOfMonth() + 1 + programmer.getWorkedDays();
                    }
                    totalDays += daysWorked;
                    if (endDate.getMonthValue() != date.getMonthValue()) {
                        totalLeft += date.lengthOfMonth() - date.getDayOfMonth();
                    } else {
                        totalLeft += endDate.getDayOfMonth() - date.getDayOfMonth();
                    }
                    if (programmer.getSalary().equals("full")) {
                        salary = daysWorked * programmer.getWage();
                    } else if (programmer.getSalary().equals("half")) {
                        salary = daysWorked * programmer.getWage() * 0.5;
                    }
                    toPrint.add(lastName + ", " + firstName + ", in charge of " + activity + " from " + startDate + " to " + endDate
                            + " (duration " + duration + " days), has worked " + daysWorked + " days this month (total salary $" + salary + ")");
                }
            }
        }

        // Print of the Report on console
        System.out.println("=======================");
        System.out.println("  IT COMPANY - REPORT  ");
        System.out.println("=======================\n");
        System.out.println("IT Company is actually composed of " + totalTeams + " project teams, and " + totalProgrammers + " programmers.");
        System.out.println("This month, " + totalActive + " programmers have been worked " + totalDays + " days, and " + totalLeft + " days left worked.\n");
        System.out.println("=== Project Team  details ===");

        // Print projects part
        for (String elem: toPrint) {
            System.out.println(elem);
        }
    }

    private static void addProject(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        Scanner scanner = new Scanner(System.in);
        boolean next = false;
        String name = "";
        LocalDate endDate = LocalDate.parse("0001-01-01");
        int id = 0;

        // user input project name
        System.out.println("Please choose a name for the new Project:");
        ArrayList<String> projNames = new ArrayList<>();
        for (ProjectTeam proj : projects ) {
            projNames.add(proj.getName().toLowerCase());
        }
        while (!next) {
            name = scanner.nextLine();
            if (projNames.contains(name.toLowerCase())) {
                System.out.println("Choose a different name, this name already exists in the system");
            } else {
                next = true;
            }
        }

        // user input project end date
        System.out.println("Please choose an end date (yyyy-MM-dd):");
        next = false;
        while (!next) {
            String end = scanner.nextLine();
            try {
                endDate = LocalDate.parse(end);
                if (endDate.isAfter(date)) {
                    next = true;
                } else {
                    System.out.println("Please insert a date of tomorrow or after");
                }
            } catch (Exception e) {
                System.out.println("Please insert a valid date (yyyy-MM-dd).");
            }
        }

        // add new project
        System.out.println("You need to add at least 2 programmers in the project");
        next = false;
        while (!next) {
            int numberProg = 0;
            for (ActiveProgrammers programmer : programmers) {
                if (programmer.getProject().equals(name)) {
                    numberProg ++;
                }
            }
            if (numberProg < 2) {
                addProgrammer(projects, programmers, name, endDate, date);
                next = true;
            }
        }
        for (ProjectTeam proj : projects) {
            if (proj.getId() > id) {
                id = proj.getId();
            }
        }
        id++;
        ProjectTeam newProj = new ProjectTeam(id, name, date, endDate);
        projects.add(newProj);
        System.out.println("New project successfully added");
    }

    public static void removeProject(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a Project to remove");
        for (int i = 0; i < projects.size(); i++) {
            System.out.println(i+1 + " " + projects.get(i).getName());
        }
        boolean next = false;
        while(!next) {
            String idStr = scanner.nextLine();
            int id;
            try {
                id = Integer.parseInt(idStr) - 1;
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
                continue;
            }
            if (0 <= id && id < projects.size()) {
                String nameProj = projects.get(id - 1).getName();
                projects.remove(id - 1);
                for (int i = 0; i < programmers.size(); i++) {
                    if (programmers.get(i).getProject().equals(nameProj)) {
                        inactivateProgrammer(projects, programmers, date, i);
                    }
                }
                next = true;
            }
            System.out.println("Project successfully remove and programmers inactivated");
        }
    }

    private static void addProgrammer(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, String project, LocalDate endProject, LocalDate startDate) {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        String firstName = "";
        String lastName = "";
        boolean isActive = false;
        String activity;
        LocalDate endDate = LocalDate.parse("0001-01-01");
        int workedDays = 0;
        double wage = 0.00;
        String salary = "";

        // get existing project name, end date
        if (project.equals("exist")) {
            System.out.println("Please choose a Project to remove");
            for (int i = 0; i < projects.size(); i++) {
                System.out.println(i+1 + " " + projects.get(i).getName());
            }
            boolean next = false;
            while(!next) {
                String idStr = scanner.nextLine();
                int projId;
                try {
                    projId = Integer.parseInt(idStr) - 1;
                } catch (Exception e) {
                    System.out.println("Please insert a valid option");
                    continue;
                }
                if (0 <= projId && projId < projects.size()) {
                    project = projects.get(projId - 1).getName();
                    endProject = projects.get(projId - 1).getEndDate();
                    next = true;
                }
            }
        }

        boolean next = false;

        // check if there are any inactive programmer
        boolean isInactive = false;
        ArrayList<String> inactProg = new ArrayList<>();
        ArrayList<Integer> inactProgId = new ArrayList<>();
        for (ActiveProgrammers programmer : programmers) {
            if (!programmer.isActive()) {
                inactProg.add(programmer.getFirstName() + " " + programmer.getFirstName());
                inactProgId.add(programmer.getId());
                isInactive = true;
            }
        }
        if (project.equals("")) {
            isInactive = false;
        } else if (project.equals("exists")) {
            isInactive = true;
        }
        if (isInactive) {
            System.out.println("Do you want to add currently inactive programmers? (s/n)");
            while (!next) {
                String option = scanner.nextLine();
                if (option.toLowerCase().equals("s")) {
                    System.out.println("Please select the programmer you want to add.");
                    for (int i = 0; i < inactProg.size(); i++) {
                        System.out.println( i+1 + ". " + inactProg.get(i));
                    }
                    boolean isID = false;
                    while (!isID) {
                        int ID = scanner.nextInt();
                        if (ID-1 >= inactProg.size() || ID-1 < 0) {
                            System.out.println("Please insert a valid option");
                        } else {
                            id = inactProgId.get(ID-1);
                            for (ActiveProgrammers programmer : programmers) {
                                if (programmer.getId() == id) {
                                    firstName = programmer.getFirstName();
                                    lastName = programmer.getLastName();
                                    workedDays = programmer.getWorkedDays();
                                    wage = programmer.getWage();
                                    salary = programmer.getSalary();
                                }
                            }
                            isID = true;
                        }
                    }
                } else if (option.toLowerCase().equals("n")) {
                    next = true;
                } else {
                    System.out.println("Please insert a valid option (s/n)");
                }
            }
        }
        System.out.println("Please Insert First Name");
        firstName = scanner.nextLine();
        System.out.println("Please Insert Last Name");
        lastName = scanner.nextLine();
        next = false;
        System.out.println("Please Insert Wage value (€/day)");
        while (!next) {
            try {
                wage = Double.parseDouble(scanner.nextLine());
                next = true;
            } catch (Exception e) {
                System.out.println("Please insert a valid number");
            }
        }
        next = false;
        System.out.println("Will receive full salary (f) or half salary (h)");
        while(!next) {
            String option = scanner.nextLine();
            if (option.toLowerCase().equals("f")) {
                salary = "full";
                next = true;
            } else if (option.toLowerCase().equals("h")){
                salary = "half";
                next = true;
            } else {
                System.out.println("Please insert a valid option.");
            }
        }
        int lastId = 0;
        for (ActiveProgrammers prog : programmers) {
            if (prog.getId() > lastId) {
                lastId = prog.getId();
            }
        }
        id = lastId + 1;
        if (project.equals("")) {
            ActiveProgrammers newProgrammer = new ActiveProgrammers(id, firstName, lastName, wage, salary);
            programmers.add(newProgrammer);
        } else {
            System.out.println("Please choose an activity end date (yyyy-MM-dd):");
            next = false;
            while (!next) {
                String end = scanner.nextLine();
                try {
                    endDate = LocalDate.parse(end);
                    if (endDate.isBefore(endProject) || endDate.isEqual(endProject) && endDate.isAfter(startDate)) {
                        next = true;
                    } else {
                        System.out.println("Please insert a date of tomorrow or after and not after the end of the project");
                    }
                } catch (Exception e) {
                    System.out.println("Please insert a valid date (yyyy-MM-dd).");
                }
            }
            System.out.println("Please insert the activity of the programmer");
            activity = scanner.nextLine();
            ActiveProgrammers newProgrammer = new ActiveProgrammers(id, firstName, lastName, true, project, activity, startDate, endDate, workedDays, startDate.getMonthValue(), wage, salary);
            programmers.add(newProgrammer);
            System.out.println("New programmer successfully added");
        }
    }

    public static void inactivateProgrammer(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date, int progId) {
        Scanner scanner = new Scanner(System.in);
        String nameProj = "";
        LocalDate endDate = null;
        int id = -1;
        boolean askName;
        askName = progId == -1;
        if (askName) {
            System.out.println("Please choose a programmer to inactivate");
            for (int i = 0; i < programmers.size(); i++) {
                System.out.println(i + 1 + " " + programmers.get(i).getFirstName() + programmers.get(i).getLastName());
            }
            boolean next = false;
            while (!next) {
                String idStr = scanner.nextLine();
                try {
                    id = Integer.parseInt(idStr) - 1;
                } catch (Exception e) {
                    System.out.println("Please insert a valid option");
                    continue;
                }
                if (0 <= id && id < programmers.size()) {
                    nameProj = programmers.get(id).getProject();
                    next = true;
                }
            }
        } else {
            id = progId;
        }
        programmers.get(id).setActive(false);
        programmers.get(id).setProject("");
        programmers.get(id).setActivity("");
        int WD;
        if (programmers.get(id).getStartDate().getMonthValue() != date.getMonthValue()) {
            WD = date.getDayOfMonth() + programmers.get(id).getWorkedDays();
        } else {
            WD = date.getDayOfMonth() - programmers.get(id).getStartDate().getDayOfMonth() + 1 + programmers.get(id).getWorkedDays();
        }
        programmers.get(id).setWorkedDays(WD);
        programmers.get(id).setStartDate(LocalDate.parse("0000-01-01"));
        programmers.get(id).setEndDate(LocalDate.parse("0000-01-01"));

        if (progId == -1) {
            int totalProg = 0;
            for (ActiveProgrammers prog : programmers) {
                if (prog.getProject().equals(nameProj)) {
                    totalProg ++;
                }
            }
            if (totalProg < 2) {
                System.out.println("your project is now with less than 2 programmers, you need to add another one");
                for (ProjectTeam proj : projects) {
                    if (proj.getName().equals(nameProj)) {
                        endDate = proj.getEndDate();
                    }
                }
                addProgrammer(projects, programmers, nameProj, endDate, date);
            }
        }
    }

    private static void changeActivity(ArrayList<ActiveProgrammers> programmers) {
        Scanner scanner = new Scanner(System.in);
        String activity;
        boolean next = false;
        int id = -1;
        System.out.println("Please select the programmer:");
        for (int i = 0; i < programmers.size(); i++) {
            if (programmers.get(i).isActive()) {
                System.out.println(i+1 + " " + programmers.get(i).getFirstName() + programmers.get(i).getLastName());
            }
        }
        while (!next) {
            String idStr = scanner.nextLine();
            try {
                id = Integer.parseInt(idStr) - 1;
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
                continue;
            }
            if (0 <= id && id < programmers.size() && programmers.get(id).isActive()) {
                next = true;
            } else {
                System.out.println("Please insert a valid option");
            }
        }
        System.out.println("Please insert the new activity:");
        String newActivity = scanner.nextLine();
        programmers.get(id).setActivity(newActivity);
        System.out.println("Activity successfully changed");
    }

    private static void changeEndDate(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers) {
        Scanner scanner = new Scanner(System.in);
        boolean next = false;
        int id = -1;
        System.out.println("Please select the programmer:");
        for (int i = 0; i < programmers.size(); i++) {
            if (programmers.get(i).isActive()) {
                System.out.println(i+1 + " " + programmers.get(i).getFirstName() + programmers.get(i).getLastName());
            }
        }
        while (!next) {
            String idStr = scanner.nextLine();
            try {
                id = Integer.parseInt(idStr) - 1;
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
                continue;
            }
            if (0 <= id && id < programmers.size() && programmers.get(id).isActive()) {
                next = true;
            } else {
                System.out.println("Please insert a valid option");
            }
        }

        // get project end date
        LocalDate endProject = LocalDate.parse("0001-01-01");
        for (ProjectTeam proj : projects) {
            if (proj.getName().equals(programmers.get(id).getProject())) {
                endProject = proj.getEndDate();
            }
        }

        // set new date
        LocalDate oldDate = programmers.get(id).getEndDate();
        LocalDate endDate = null;
        System.out.println("Please choose an activity end date (yyyy-MM-dd):");
        next = false;
        while (!next) {
            String end = scanner.nextLine();
            try {
                endDate = LocalDate.parse(end);
                if (endDate.isBefore(endProject) || endDate.isEqual(endProject) && endDate.isAfter(oldDate)) {
                    next = true;
                } else {
                    System.out.println("Please insert a date after  the current end Date and not after the end of the project");
                }
            } catch (Exception e) {
                System.out.println("Please insert a valid date (yyyy-MM-dd).");
            }
        }

        programmers.get(id).setEndDate(endDate);
        System.out.println("End Date successfully changed");
    }

    private static void changeWage(ArrayList<ActiveProgrammers> programmers) {
        Scanner scanner = new Scanner(System.in);
        boolean next = false;
        int id = -1;
        System.out.println("Please select the programmer:");
        for (int i = 0; i < programmers.size(); i++) {
                System.out.println(i+1 + " " + programmers.get(i).getFirstName() + programmers.get(i).getLastName());
        }
        while (!next) {
            String idStr = scanner.nextLine();
            try {
                id = Integer.parseInt(idStr) - 1;
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
                continue;
            }
            if (0 <= id && id < programmers.size()) {
                next = true;
            } else {
                System.out.println("Please insert a valid option");
            }
        }
        System.out.println("Please Insert Wage value (€/day)");
        next = false;
        double wage = 0.00;
        while (!next) {
            try {
                wage = Double.parseDouble(scanner.nextLine());
                next = true;
            } catch (Exception e) {
                System.out.println("Please insert a valid number");
            }
        }
        programmers.get(id).setWage(wage);
        System.out.println("Wage successfully changed");
    }

    private static void changeSalary(ArrayList<ActiveProgrammers> programmers) {
        Scanner scanner = new Scanner(System.in);
        boolean next = false;
        int id = -1;
        System.out.println("Please select the programmer:");
        for (int i = 0; i < programmers.size(); i++) {
            System.out.println(i+1 + " " + programmers.get(i).getFirstName() + programmers.get(i).getLastName());
        }
        while (!next) {
            String idStr = scanner.nextLine();
            try {
                id = Integer.parseInt(idStr) - 1;
            } catch (Exception e) {
                System.out.println("Please insert a valid option");
                continue;
            }
            if (0 <= id && id < programmers.size()) {
                next = true;
            } else {
                System.out.println("Please insert a valid option");
            }
        }
        String salary = programmers.get(id).getSalary();
        if (salary.equals("full")) {
            programmers.get(id).setSalary("half");
            System.out.println("Salary changed to half");
        } else if (salary.equals("half")){
            programmers.get(id).setSalary("full");
            System.out.println("Salary changed to full");
        }
    }
}