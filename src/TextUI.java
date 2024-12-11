import java.util.ArrayList;

public class TextUI {

    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    public int promptNumeric(String prompt) {
        // Spørg brugeren om et tal (for eksempel antal hold)
        // Dette er et forsimplet eksempel, du skal bruge Scanner til at få input
        System.out.print(prompt);
        return 2; // Eksempel: returner 2 hold
    }

    public String promptText(String prompt) {
        // Spørg brugeren om tekstinput (f.eks. holdnavn)
        System.out.print(prompt);
        return "Team A"; // Eksempel: returner et standard holdnavn
    }

    public int promptCategory(SQLite db) {
        // Spørg brugeren om at vælge en kategori
        // Du kan bruge db til at hente kategorier, hvis det er nødvendigt
        System.out.println("Choose a category:");
        return 1; // Eksempel: returner en kategori-ID
    }

    public void displayQuestions(ArrayList<String> questions) {
        // Vis spørgsmålene til spilleren
        for (String question : questions) {
            System.out.println(question);
        }
    }

    public void displayStatus(String title, ArrayList<String> statuses) {
        // Vis status (som point-status)
        System.out.println(title);
        for (String status : statuses) {
            System.out.println(status);
        }
    }
}


