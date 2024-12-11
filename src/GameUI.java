import java.util.ArrayList;

public class GameUI {

    private SQLite db;          // Databaseklasse
    private TextUI textUI;      // Brugergrænseflade til at håndtere input/output
    private ArrayList<String> teamNames;   // Liste over team-navne
    private int numTeams;       // Antal hold, der spiller

    // Konstruktoren skal nu tage en SQLite instans i stedet for en String
    public GameUI(SQLite db) {
        this.db = db;  // Tildeler SQLite instansen til db
        this.textUI = new TextUI();
        this.teamNames = new ArrayList<>();
    }

    // Start spillet
    public void startGame() {
        textUI.displayMsg("Welcome to Trivial Pursuit!");

        // Step 1: Vælg antal hold
        numTeams = textUI.promptNumeric("How many teams will play?");

        // Step 2: Navngiv holdene
        for (int i = 0; i < numTeams; i++) {
            String teamName = textUI.promptText("Enter name for Team " + (i + 1) + ":");
            teamNames.add(teamName);
        }

        // Step 3: Vælg kategori
        int chosenCategory = textUI.promptCategory(db);

        // Step 4: Hent spørgsmål og vis dem
        ArrayList<String> questions = db.getQuestions(chosenCategory); // Brug db til at hente spørgsmål baseret på valgt kategori
        textUI.displayQuestions(questions);
    }
}




