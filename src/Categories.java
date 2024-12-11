import java.util.ArrayList;
import java.util.List;

public class Categories {
    private int id;
    private String categoryName;
    private List<Questions> questions;

    public Categories(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.questions = new ArrayList<>();
    }

    public void loadQuestions(SQLite sqlite) {
        // Assuming you have a method in SQLite class to get questions by category
        ArrayList<Questions> questionData = sqlite.getQuestionsByCategory(this.id);

        if (questionData.isEmpty()) {
            System.out.println("No questions found for category: " + this.categoryName);
            return;
        }

        // Simply add all questions to the list
        this.questions.addAll(questionData);
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    // Getters for id and categoryName if needed
    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

