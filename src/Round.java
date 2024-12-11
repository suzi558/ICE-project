import java.util.ArrayList;

public class Round {
    private ArrayList<String> questions;
    private int currentQuestionIndex;
    private int score;

    // Constructor
    public Round(ArrayList<String> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0; // Start med det første spørgsmål (0-baseret indeks)
        this.score = 0; // Start med en score på 0
    }

    // Hent det næste spørgsmål
    public String getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        } else {
            return null; // Ingen flere spørgsmål
        }
    }

    // Tjek svar og opdater score
    public boolean checkAnswer(String correctAnswer, String playerAnswer) {
        boolean isCorrect = correctAnswer.equalsIgnoreCase(playerAnswer);

        if (isCorrect) {
            score += 10; // Tilføj point for korrekt svar (juster point efter behov)
        }

        return isCorrect;
    }

    // Hent den aktuelle score
    public int getScore() {
        return score;
    }

    // Tjek om der er flere spørgsmål
    public boolean hasMoreQuestions() {
        return currentQuestionIndex < questions.size();
    }
}

