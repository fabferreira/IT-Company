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
                    break;

                case 2:
                    programmersMenu();
                    break;

                case 3:
                    showReport(projects, programmers, date);
                    break;

                case 4:
                    ManageDatabase.save(projects, programmers, date);
                    break;

                case 5:
                    ManageDatabase.load(projects, programmers);
                    break;

                case 6:
                    quit = true;
                    ManageDatabase.save(projects,programmers, date);
                    break;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    break;
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
            System.out.println("3. Edit Project");
            System.out.println("4. Back");

            actproj = scanner.nextInt();
            switch (actproj) {
                case 1:
                    addProject(projects, programmers, date);
                    System.out.println("Project added");
                    break;

                case 2:
                    removeProject();
                    System.out.println("Project removed");
                    break;

                case 3:
                    editProjMenu();
                    System.out.println("Edition Completed");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
                    break;
            }
        }
    }

    private static void programmersMenu() {
        Scanner scanner = new Scanner(System.in);
        int actprog = 0;
        while(actprog != 5) {

            System.out.println("====== Programmer Menu ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Add New Programmer");
            System.out.println("2. Remove Programmer");
            System.out.println("3. Edit Programmer");
            System.out.println("4. Inactivate");
            System.out.println("5. Back");

            actprog = scanner.nextInt();
            switch (actprog) {
                case 1:
                    //addProgrammer();
                    System.out.println("Programmer added");
                    break;


                case 2:
                    removeProgrammer();
                    System.out.println("Programmer removed");
                    break;

                case 3:
                    editProgMenu();
                    System.out.println("Edition Completed");
                    break;

                case 4:
                    inactivateProgrammer();
                    System.out.println("Programmer inactivated");
                    break;

                case 5:
                    break;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
                    break;
            }
        }
    }

    private static void editProjMenu() {
        Scanner scanner = new Scanner(System.in);
        int edproj = 0;
        while(edproj != 4) {

            System.out.println("====== Edit Project ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Start Date");
            System.out.println("3. Edit End Date");
            System.out.println("4. Back");

            edproj = scanner.nextInt();
            switch (edproj) {
                case 1:
                    // escolher o projecto
                    // mudar o nome
                    System.out.println("Name changed");
                    break;

                case 2:
                    // escolher o projecto
                    // mudar a data de inicio
                    System.out.println("Start Date Changed");
                    break;

                case 3:
                    // escolher o projecto
                    // mudar a data de fim
                    System.out.println("End Date Changed");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
                    break;
            }
        }
    }

    private static void editProgMenu() {
        Scanner scanner = new Scanner(System.in);
        int edprog = 0;
        while(edprog != 9) {

            System.out.println("====== Edit Programmer ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Edit First Name");
            System.out.println("2. Edit Last Name");
            System.out.println("3. Edit Project");
            System.out.println("4. Edit Activity");
            System.out.println("5. Edit Start Date");
            System.out.println("6. Edit End Date");
            System.out.println("7. Edit Wage");
            System.out.println("8. Edit % Salary");
            System.out.println("9. Back");

            edprog = scanner.nextInt();
            switch (edprog) {
                case 1:
                    //escolher o programador
                    //mudar o primeiro nome
                    System.out.println("Programmer's First Name changed");
                    break;

                case 2:
                    //escolher o programador
                    //mudar o ultimo nome
                    System.out.println("Programmer's Last Name changed");
                    break;

                case 3:
                    //escolher o programador
                    //mudar o projecto
                    System.out.println("Project Changed");
                    break;

                case 4:
                    //escolher o programador
                    //mudar a data de inicio
                    System.out.println("Activity Changed");
                    break;

                case 5:
                    //escolher o programador
                    //mudar a data de fim
                    System.out.println("Start Date Changed");
                    break;

                case 6:
                    //escolher o programador
                    //mudar a data de fim
                    System.out.println("End Date Changed");
                    break;

                case 7:
                    //escolher o programador
                    //mudar o salário
                    System.out.println("Wage Changed");
                    break;

                case 8:
                    //escolher o programador
                    //mudar a % que recebe
                    System.out.println("% Salary Changed");
                    break;

                case 9:
                    break;

                default:
                    System.out.println("************************************");
                    System.out.println("Please insert a valid option");
                    System.out.println("************************************");
                    System.out.println();
                    break;
            }
        }
    }

    public static void showReport(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
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

        // user input project start date
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
                addProgrammer(programmers, name, endDate, date);
            } else {
                next = false;
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
    }

    private static void removeProject() {
        // exibir lista de projectos
        // escolher o projecto
        // remover o projecto seleccionado
        // colocar os programadores do projecto como inativos
    }

    private static void addProgrammer(ArrayList<ActiveProgrammers> programmers, String project, LocalDate endProject, LocalDate startDate) {
        int id = 0;
        String firstName = "";
        String lastName = "";
        boolean isActive = false;
        String activity;
        LocalDate endDate = LocalDate.parse("0001-01-01");
        int workedDays = 0;
        double wage = 0.00;
        String salary = "";

        boolean next = false;
        Scanner scanner = new Scanner(System.in);

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
        } else {
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
        }
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
        }
    }

    private static void removeProgrammer() {
        // exibir lista de programadores
        // escolher o programador
        // remover o programador seleccionado
    }

    private static void inactivateProgrammer() {
        // por isActive para false
        //remover infos do projecto no programador
        //defenir dias trabalhados no mes
    }

}