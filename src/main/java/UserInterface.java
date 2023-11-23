import java.util.*;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    private final Controller controller;
    boolean uiIsRunning = true;

    public UserInterface() {
        this.controller = new Controller();
    }

    public void startProgram() {

        controller.addMember("Laura", "Madsen", "lauramadsen@gmail.com", 62376453, "15/02/2003", "23/11/2023", true, true);

        boolean uiIsRunning = true;
        while (uiIsRunning) {
            showMainMenu();
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        showMembers();
                        break;
                    case 3:
                        // Implementer logik for search for a member
                        break;
                    case 4:
                        // Implementer logik for edit a member
                        break;
                    case 9:
                        exitProgram();
                        uiIsRunning = false;
                        break;
                    default:
                        System.out.println("Ugyldigt input. Indtast en gyldig handling (1, 2, 3, 4 eller 9).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ugyldigt input. Indtast en gyldig handling (1, 2, 3, 4 eller 9).");
                input.nextLine(); // Clear the invalid input from the scanner
            }
        }
    }
    private void showMainMenu() {
        System.out.println();
        System.out.println("Velkommen til SVØMMEKLUBBEN DELFINEN.");
        System.out.println();
        System.out.println("1. Tilføj nyt medlem");
        System.out.println("2. Vis liste over alle medlemmer");
        System.out.println("3. Søg efter et medlem");
        System.out.println("4. Rediger et medlem");
        System.out.println("9. Afslut");
        System.out.print("Vælg en handling: ");
    }

    private void addMember() {
        input.nextLine();
        System.out.println("Hvad er fornavnet på det nye medlem?");
        String name = input.nextLine();

        System.out.println("Hvad er deres efternavn?");
        String surName = input.nextLine();

        System.out.println("Hvad er deres email?");
        String email = input.nextLine();

        System.out.println("Hvad er deres telefon nr.?");
        int phoneNumber = input.nextInt();

        System.out.println("Hvornår har de fødselsdag? (dd/mm/yyyy)");
        String dateOfBirth = input.nextLine();

        System.out.println("Hvornår er de blevet et medlem? (dd/mm/yyyy)");
        String dateJoined = input.nextLine();

        System.out.println("Er det et aktivt medlem? (j/n)");
        boolean isActive = input.next().equalsIgnoreCase("j");

        System.out.println("Er det en konkurrence svømmer?(j/n)");
        boolean isCompetitor = input.next().equalsIgnoreCase("j");

        controller.addMember(name, surName, email, phoneNumber, dateOfBirth, dateJoined, isActive, isCompetitor);
    }

    private void showMembers() {
        System.out.println(controller.showMembers());
    }

    private void exitProgram() {
        uiIsRunning = false;
        System.out.println("Programmet afsluttes. Hav en god dag!");
    }

}