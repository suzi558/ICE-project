import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameUI {
    private Scanner scanner;
    private SQLite sqlite;
    private TeamHandler teamHandler;
    private List<Categories> categories;

    public GameUI(SQLite sqlite) {
        this.scanner = new Scanner(System.in);
        this.sqlite = sqlite;
        this.teamHandler = new TeamHandler();
        this.categories = new ArrayList<>();
    }

    public void startGame() {
        System.out.println("Welcome to Trivial Pursuit!");
        setupTeams();
        loadCategories();
        playGame();
        announceWinner();
    }

    private void setupTeams() {
        int numTeams;
        do {
            System.out.print("How many teams are participating? (2-5): ");
            numTeams = getNumericInput();
        } while (numTeams < 2 || numTeams > 5);

        for (int i = 1; i <= numTeams; i++) {
            System.out.print("Enter name for Team " + i + ": ");
            String teamName = scanner.nextLine();
            teamHandler.addTeam(new Team(teamName));
        }
    }

    private void loadCategories() {
        // Assume SQLite has a method to retrieve categories
        ArrayList<String> categoryNames = sqlite.getCategories();
        for (int i = 0; i < categoryNames.size(); i++) {
            categories.add(new Categories(i + 1, categoryNames.get(i)));
        }
        for (Categories category : categories) {
            category.loadQuestions(sqlite);
        }
    }

    private void playGame() {
        boolean questionsRemaining = true;
        while (questionsRemaining) {
            for (Team team : teamHandler.teams) {
                System.out.println("It's " + team.getTeamName() + "'s turn!");
                Categories chosenCategory = chooseCategory();
                Questions question = getQuestion(chosenCategory);

                if (question == null) {
                    System.out.println("No more questions in this category.");
                    questionsRemaining = areQuestionsRemaining();
                    if (!questionsRemaining) break;
                    continue;
                }

                System.out.println("Question: " + question.getText());
                System.out.println("1: " + question.getCorrectAnswer());
                System.out.println("2: " + question.getOtherChoice1());
                System.out.println("3: " + question.getOtherChoice2());
                System.out.println("You have 10 seconds to answer!");

                Timer.startTimer();

                int answer = getNumericInput();
                if (validateAnswer(answer, question)) {
                    System.out.println("Correct! You earn " + question.getPoints() + " points.");
                    team.addPoint(question.getPoints());
                } else {
                    System.out.println("Wrong answer. No points awarded.");
                }
            }
        }
    }

    private Categories chooseCategory() {
        System.out.println("Choose a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ": " + categories.get(i).getCategoryName());
        }

        int choice;
        do {
            choice = getNumericInput();
        } while (choice < 1 || choice > categories.size());

        return categories.get(choice - 1);
    }

    private Questions getQuestion(Categories category) {
        List<Questions> questions = category.getQuestions();
        if (!questions.isEmpty()) {
            return questions.remove(0); // Returner og fjern det første spørgsmål
        }
        return null;
    }

    private boolean validateAnswer(int answer, Questions question) {
        switch (answer) {
            case 1: return question.getCorrectAnswer().equals(question.getCorrectAnswer());
            case 2: return question.getCorrectAnswer().equals(question.getOtherChoice1());
            case 3: return question.getCorrectAnswer().equals(question.getOtherChoice2());
            default: return false;
        }
    }

    private boolean areQuestionsRemaining() {
        for (Categories category : categories) {
            if (!category.getQuestions().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void announceWinner() {
        Team winner = teamHandler.getWinner();
        System.out.println("The game is over! The winner is: " + winner.getTeamName() + " with " + winner.getPoints() + " points!");
    }

    private int getNumericInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}