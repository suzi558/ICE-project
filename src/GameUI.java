import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class manages the main game flow, including team setup, category selection, and gameplay.
 */
public class GameUI {
    private Scanner scanner; // Used to get user input
    private DataReader sqlite; // Used to interact with the database
    private TeamHandler teamHandler; // Handles team-related operations
    private List<Categories> categories; // Stores all game categories

    /**
     * Constructor to initialize the GameUI with the given SQLite instance.
     * The constructor sets up the scanner for user input, assigns the SQLite instance,
     * initializes the team handler, and prepares the categories list.
     */
    public GameUI(DataReader sqlite) {
        this.scanner = new Scanner(System.in); // Initialize scanner for user input
        this.sqlite = sqlite; // Assign SQLite instance
        this.teamHandler = new TeamHandler(); // Initialize team handler
        this.categories = new ArrayList<>(); // Initialize categories list
    }

    /**
     * Starts the game by setting up teams, loading categories, and running the game loop.
     */
    public void startGame() {
        System.out.println("Welcome to the Trivial Pursuit!");
        setupTeams(); // Step 1: Set up participating teams
        loadCategories(); // Step 2: Load categories and their questions from the database
        playGame(); // Step 3: Main gameplay loop
        announceWinner(); // Step 4: Announce the winning team
    }

    /**
     * Sets up the teams by asking the user for the number of teams and their names.
     */
    private void setupTeams() {
        int numTeams;
        // Prompt the user until they enter a valid number of teams
        do {
            System.out.print("How many teams are participating? (2-5): ");
            numTeams = getNumericInput();
        } while (numTeams < 2 || numTeams > 5);

        // Collect team names and add them to the team handler
        for (int i = 1; i <= numTeams; i++) {
            System.out.print("Enter name for Team " + i + ": ");
            String teamName = scanner.nextLine();
            teamHandler.addTeam(new Team(teamName)); // Create and add a new team
        }
    }

    /**
     * Loads categories and their questions from the database.
     */
    private void loadCategories() {
        ArrayList<String> categoryNames = sqlite.getCategories(); // Fetch category names from database

        for (int i = 0; i < categoryNames.size(); i++) {
            categories.add(new Categories(i + 1, categoryNames.get(i))); // Create and add category objects
        }

        for (Categories category : categories) {
            category.loadQuestions(sqlite); // Load questions for each category
        }
    }

    /**
     * Runs the main gameplay loop, allowing teams to answer questions.
     */
    /**
     * Runs the main gameplay loop, allowing teams to answer questions.
     */
    private void playGame() {
        boolean questionsRemaining = true; // Flag to track if questions are available

        while (questionsRemaining) {
            for (Team team : teamHandler.teams) { // Loop through all teams
                System.out.println("It's " + team.getTeamName() + "'s turn!");
                Categories chosenCategory = chooseCategory(); // Team chooses a category
                Questions question = getQuestion(chosenCategory); // Get a question from the category

                if (question == null) {
                    System.out.println("No more questions in this category.");
                    questionsRemaining = areQuestionsRemaining(); // Check if any questions remain
                    if (!questionsRemaining) break; // Exit loop if no questions are left
                    continue; // Move to the next team's turn
                }

                // *** Tilføj den tilfældige blanding her ***
                // Display the question and shuffle the answer choices
                List<String> answerChoices = new ArrayList<>();
                answerChoices.add(question.getCorrectAnswer());
                answerChoices.add(question.getOtherChoice1());
                answerChoices.add(question.getOtherChoice2());

                Collections.shuffle(answerChoices); // Shuffle the answer choices

                System.out.println("Question: " + question.getText());
                for (int i = 0; i < answerChoices.size(); i++) {
                    System.out.println((i + 1) + ": " + answerChoices.get(i));
                }
                System.out.println("You have 10 seconds to answer!");

                // Start the timer and get the user's answer
                Timer.startTimer();
                int answer = getNumericInput();

                // Validate the answer
                if (answer >= 1 && answer <= 3 && answerChoices.get(answer - 1).equals(question.getCorrectAnswer())) {
                    System.out.println("Correct! You earn " + question.getPoints() + " points.");
                    team.addPoint(question.getPoints());
                } else {
                    System.out.println("Wrong answer. No points awarded.");
                }
            }
        }
    }


    /**
     * Allows the team to choose a category from the available options.
     * @return The chosen category.
     */
    private Categories chooseCategory() {
        System.out.println("Choose a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ": " + categories.get(i).getCategoryName()); // Display categories
        }

        int choice;
        do {
            choice = getNumericInput(); // Ensure valid input
        } while (choice < 1 || choice > categories.size());

        return categories.get(choice - 1); // Return the selected category
    }

    /**
     * Retrieves the next available question from the given category.
     * @param category The chosen category.
     * @return The next question or null if no questions remain.
     */
    private Questions getQuestion(Categories category) {
        List<Questions> questions = category.getQuestions();

        for (Questions question : questions) {
            if (question != null) {
                questions.remove(question); // Remove the question after retrieving it
                return question; // Return the question
            }
        }

        return null; // No questions left in the category
    }

    /**
     * Validates the team's answer against the correct answer.
     * @param answer The team's answer.
     * @param question The current question.
     * @return True if the answer is correct, otherwise false.
     */
    private boolean validateAnswer(int answer, Questions question) {
        switch (answer) {
            case 1: return question.getCorrectAnswer().equals(question.getCorrectAnswer());
            case 2: return question.getCorrectAnswer().equals(question.getOtherChoice1());
            case 3: return question.getCorrectAnswer().equals(question.getOtherChoice2());
            default: return false; // Invalid answer
        }
    }

    /**
     * Checks if there are any unanswered questions left across all categories.
     * @return True if questions remain, otherwise false.
     */
    private boolean areQuestionsRemaining() {
        for (Categories category : categories) {
            if (!category.getQuestions().isEmpty()) {
                return true; // Questions still available
            }
        }

        return false; // No questions remaining
    }

    /**
     * Announces the winning team at the end of the game.
     */
    private void announceWinner() {
        Team winner = teamHandler.getWinner(); // Get the team with the highest points
        System.out.println("The game is over! The winner is: " + winner.getTeamName() + " with " + winner.getPoints() + " points!");
    }

    /**
     * Prompts the user for a numeric input and validates it.
     * @return The validated numeric input.
     */
    private int getNumericInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine()); // Parse input as integer
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: "); // Handle invalid input
            }
        }
    }
}
