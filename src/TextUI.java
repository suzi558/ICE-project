import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    // Viser en besked til brugeren
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

        // Beder brugeren om et numerisk svar
    public int promptNumeric(String msg) {
        System.out.println(msg);  // Spørg brugeren
        String input = scan.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            displayMsg("Please type a valid number");
            return promptNumeric(msg);
        }
    }

    // Beder brugeren om tekstinput
    public String promptText(String msg) {
        System.out.println(msg);  // Stille brugeren et spørgsmål
        return scan.nextLine();
    }

    // Viser en liste over kategorier og beder brugeren vælge én
    public int promptCategory(ArrayList<String> categories) {
        displayMsg("Choose a category:");
        displayList(categories, "Categories");
        int choice = promptNumeric("Enter the number of your choice:");
        if (choice > 0 && choice <= categories.size()) {
            return choice - 1;  // Returnér indeks
        } else {
            displayMsg("Invalid choice. Try again.");
            return promptCategory(categories);
        }
    }

    // Viser en liste over muligheder og beder brugeren vælge én
    public int promptChoice(String question, ArrayList<String> choices) {
        displayMsg("Question: " + question);
        displayList(choices, "Choices");
        int choice = promptNumeric("Enter the number of your choice:");
        if (choice > 0 && choice <= choices.size()) {
            return choice - 1;  // Returnér indeks
        } else {
            displayMsg("Invalid choice. Try again.");
            return promptChoice(question, choices);
        }
    }

    // Viser en liste med overskrift
    public void displayList(ArrayList<String> options, String msg) {
        System.out.println("******* " + msg + " *******");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ": " + options.get(i));
        }
    }

    // Viser spillets status (f.eks. point for spillere)
    public void displayStatus(String msg, ArrayList<String> playerStatuses) {
        System.out.println("******* " + msg + " *******");
        for (String status : playerStatuses) {
            System.out.println(status);
        }
    }
}
