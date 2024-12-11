import java.util.ArrayList;
import java.util.List;

public class Categories {
    private int id; // Et unikt ID for kategorien.
    private String categoryName; // Navnet på kategorien.
    private List<Questions> questions; // En liste, der holder på alle spørgsmål i denne kategori.

    // Constructoren initialiserer id og categoryName med de værdier, der gives som parametre.
    public Categories(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.questions = new ArrayList<>(); // Initialiser som en tom liste
    }

    // Metode til at hente spørgsmål fra databasen
    public void loadQuestions(SQLite sqlite) {
        // Hent spørgsmål for denne kategori fra databasen
        List<Questions> questionData = sqlite.getQuestionsByCategory(id);  // Forvent at getQuestionsByCategory returnerer en liste med spørgsmål

        if (questionData.isEmpty()) {
            System.out.println("Ingen spørgsmål fundet for kategori: " + this.categoryName);
            return;
        }

        // Tilføj de hentede spørgsmål til listen
        questions.addAll(questionData);
    }

    // Getter for questions
    public List<Questions> getQuestions() {
        return questions;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for categoryName
    public String getCategoryName() {
        return categoryName;
    }
}

