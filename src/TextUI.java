import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    public Scanner scan = new Scanner(System.in);

    // Viser en besked til brugeren
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    // Beder brugeren om et numerisk svar
    public int promptNumeric(String msg) {
        System.out.println(msg);  // Viser beskeden til brugeren
        String input = scan.nextLine();  // Læser brugerens input som en streng
        try {
            return Integer.parseInt(input);  // Forsøger at konvertere strengen til et heltal
        } catch (NumberFormatException e) {
            displayMsg("Please type a valid number.");  // Fejlmeddelelse ved ugyldigt input
            return promptNumeric(msg);  // Rekursivt kald for at spørge igen
        }
    }

    // Beder brugeren om tekstinput
    public String promptText(String msg) {
        System.out.println(msg);  // Viser beskeden til brugeren
        return scan.nextLine();  // Læser og returnerer input som en streng
    }

    // Get Categories and Questions
    public void getCategoriesQuestions(ArrayList<String> questions) {
        System.out.println("Choose a category (Geography, Science, History, Entertainment, Sports):");
        String category = scan.nextLine();

        switch (category) {
            case "Geography":
                for (int i = 0; i <= 10; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "Science":
                for (int i = 10; i <= 20; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "History":
                for (int i = 20; i <= 30; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "Entertainment":
                for (int i = 30; i <= 40; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "Sports":
                for (int i = 40; i <= 50; i++) {  // Fixed loop condition
                    System.out.println(questions.get(i));
                }
                break;
            default:
                displayMsg("Invalid category.");
                break;
        }
    }

    // Viser en liste med overskrift
    public void displayList(ArrayList<String> options, String msg) {
        System.out.println("******* " + msg + " *******");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ": " + options.get(i));  // Viser listen som 1-baseret
        }
    }

    // Viser spillets status, fx point for spillere
    public void displayStatus(String msg, ArrayList<String> playerStatuses) {
        System.out.println("******* " + msg + " *******");
        for (String status : playerStatuses) {
            System.out.println(status);
        }
    }
}


