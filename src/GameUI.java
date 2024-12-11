import java.util.ArrayList;

public class GameUI {
    private SQLite db;        // Til at håndtere databasen
    private TextUI textUI;    // Til at interagere med brugeren
    private int totalScore;   // Holder styr på den samlede score

    // Constructor
    public GameUI(String dbUrl) {
        this.db = new SQLite();
        this.textUI = new TextUI();
        this.totalScore = 0;

        db.connect(dbUrl); // Forbind til databasen
    }

    // Starter spillet
    public void startGame() {
        textUI.displayMsg("Welcome to the Quiz Game!");
        boolean playAgain;

        do {
            int categoryId = chooseCategory();        // Spiller vælger en kategori
            ArrayList<String> questions = fetchQuestions(categoryId); // Hent spørgsmål fra databasen
            playRound(questions);                   // Spil en runde
            playAgain = askToPlayAgain();           // Spørg, om spilleren vil spille igen
        } while (playAgain);

        textUI.displayMsg("Thanks for playing! Your total score is: " + totalScore);
    }

    // Spørg brugeren om at vælge en kategori
    private int chooseCategory() {
        return textUI.promptCategory(db);
    }

    // Henter spørgsmål fra databasen baseret på kategori
    private ArrayList<String> fetchQuestions(int categoryId) {
        // Brug `SQLite` til at hente spørgsmål baseret på kategori-id
        return db.getQuestion(); // Du skal opdatere `SQLite` til at hente spørgsmål baseret på kategori-id
    }

    // Spiller en enkelt runde
    private void playRound(ArrayList<String> questions) {
        Round round = new Round(questions);
        textUI.displayMsg("Starting a new round!");

        while (round.hasMoreQuestions()) {
            String question = round.getNextQuestion();
            textUI.displayMsg("Question: " + question);

            // Her skal du implementere logikken for at hente det korrekte svar fra databasen
            String correctAnswer = "correctAnswerHere"; // Dette skal opdateres til at hente fra databasen
            String playerAnswer = textUI.promptText("Enter your answer:");

            boolean isCorrect = round.checkAnswer(correctAnswer, playerAnswer);

            if (isCorrect) {
                textUI.displayMsg("Correct! Well done.");
            } else {
                textUI.displayMsg("Wrong answer. The correct answer was: " + correctAnswer);
            }
        }

        int roundScore = round.getScore();
        totalScore += roundScore; // Tilføj runde-point til totalen
        textUI.displayMsg("Round over! Your score for this round: " + roundScore);
    }

    // Spørger spilleren, om de vil spille igen
    private boolean askToPlayAgain() {
        String response = textUI.promptText("Do you want to play another round? (yes/no)");
        return response.equalsIgnoreCase("yes");
    }
}

