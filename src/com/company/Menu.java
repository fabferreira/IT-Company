package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu(ArrayList<ProjectTeam> projetcs, ArrayList<Programmers> programmers) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while(!quit) {
            MainMenu();
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 1:
                    projectsMenu();
                    break;

                case 2:
                    programmersMenu();
                    break;

                case 3:
                    showReport();
                    break;

                case 4:
                    save();
                    break;

                case 5:
                    load();
                    break;

                case 6:
                    quit = true;
                    // colocar aqui ou no main um save automatico antes do programa fechar
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

    private static void projectsMenu() {
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
            scanner.nextLine();
            switch (actproj) {
                case 1:
                    addProject();
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
            scanner.nextLine();
            switch (actprog) {
                case 1:
                    addProgrammer();
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
            scanner.nextLine();
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
        while(edprog != 7) {

            System.out.println("====== Edit Programmer ======");
            System.out.println("Please Select one of the following options:");
            System.out.println("1. Edit First Name");
            System.out.println("2. Edit Last Name");
            System.out.println("3. Edit Project");
            System.out.println("4. Edit Activity");
            System.out.println("5. Edit Start Date");
            System.out.println("6. Edit End Date");
            System.out.println("7. Back");

            edprog = scanner.nextInt();
            scanner.nextLine();
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

    private static void showReport() {
        // mostrar o report como pedido
    }

    private static void save() {
        // fazer save do ficheiro
    }

    private static void load() {
        // fazer load do ficheiro
    }

    private static void addProject() {
        // criar novo projecto (confirmar se já existe)
        // adicionar novo projecto a lista de projectos
    }

    private static void removeProject() {
        // exibir lista de projectos
        // escolher o projecto
        // remover o projecto seleccionado
        // colocar os programadores do projecto como inativos
    }

    private static void addProgrammer() {
        // criar novo programador (confirmar se já existe)
        // adicionar novo programador a lista de programadores
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