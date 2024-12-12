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
/*
    // Henter og viser kategorier fra databasen, og beder brugeren vælge én
    public int promptCategory(SQLite db) {
        ArrayList<String> categories = db.getCategories();  // Hent kategorier fra databasen
        displayMsg("Choose a category:");  // Vis besked til brugeren
        displayList(categories, "Categories");  // Vis kategorier som en liste
        int choice = promptNumeric("Enter the number of your choice:");  // Bed brugeren om et valg

        if (choice > 0 && choice <= categories.size()) {
            return choice;  // Returnér brugerens valg (1-baseret)
        } else {
            displayMsg("Invalid choice. Try again.");  // Fejlmeddelelse
            return promptCategory(db);  // Rekursivt kald for at spørge igen
        }
    } */
/*
    // Henter og viser valgmuligheder fra databasen, og beder brugeren vælge én
    public int promptChoice(SQLite db, int questionId) {
        ArrayList<String> choices = db.getQuestion();  // Hent valgmuligheder fra databasen
        displayMsg("Here is your question:");  // Besked til brugeren
        displayList(choices, "Choices");  // Vis valgmuligheder som en liste
        int choice = promptNumeric("Enter the number of your choice:");  // Bed brugeren om et valg

        if (choice > 0 && choice <= choices.size()) {
            return choice;  // Returnér brugerens valg (1-baseret)
        } else {
            displayMsg("Invalid choice. Try again.");  // Fejlmeddelelse
            return promptChoice(db, questionId);  // Rekursivt kald for at spørge igen
        }
    }

 */

    public void getCategoriesQuestions(ArrayList<String> questions) {


        switch(textUI.scan.nextLine())
        {

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
                for (int i = 40; i == 50; i++) {
                    System.out.println(questions.get(i));
                }
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


