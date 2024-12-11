import java.util.Scanner;

public class TextUI {
    private Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to Trivial Pursuit!");
        System.out.println("Lets begin!");
    }

    public int chooseNumberOfTeams() {
        System.out.print("How many teams are playing: ");
        return scanner.nextInt();
    }

    public void showCategories(String[] categories) {
        System.out.println("Categories:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
    }

    public int chooseCategory() {
        System.out.print("Chose a category (write a number): ");
        return scanner.nextInt();
    }

    public void showQuestion(String question, String[] options) {
        System.out.println("Question: " + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public int getAnswer() {
        System.out.print("Write your answer (write a number): ");
        return scanner.nextInt();
    }

    public void showScore(int[] teamScores) {
        System.out.println("Stillingen:");
        for (int i = 0; i < teamScores.length; i++) {
            System.out.println("Team " + (i + 1) + ": " + teamScores[i] + " point");
        }
    }

    public void showCorrectAnswer() {
        System.out.println("Correct answer, good job!");
    }

    public void showWrongAnswer() {
        System.out.println("Wrong answer. good luck next time!");
    }

    public void showWinner(int winningTeam) {
        System.out.println("The winner is: Team " + winningTeam + "! Congratulations!");
    }

    public void showTimer(int seconds) {
        System.out.println("You have" + seconds + " seconds to answer.");
    }

    public void closeScanner() {
        scanner.close();
    }
}

