import java.util.ArrayList;
import java.util.List;

public class Categories {
    private int id; // Et unikt ID for kategorien.
    private String categoryName; // Navnet på kategorien.
    private List<Questions> questions; // En liste, der holder på alle spørgsmål i denne kategori.

    // Constructoren initialiserer id og CategoryName med de værdier, der gives som parametre.
    public Categories(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.questions = new ArrayList<>(); // Initialiser som en tom liste
    }

    public String getCategoryName() {
        return categoryName;
    }


    // Metode til at hente spørgsmål fra databasen
    public void loadQuestions(DataReader sqlite) {
        try {
            // Hent alle spørgsmål fra SQLite-klassen
            ArrayList<Questions> allQuestions = sqlite.getQuestions();

            // Filtrer spørgsmålene baseret på kategori-ID
            for (Questions question : allQuestions) {
                if (question.getCategoryID() == this.id) {
                    questions.add(question);
                }
            }

            if (questions.isEmpty()) {
                System.out.println("Ingen spørgsmål fundet for kategori: " + this.categoryName);
            }

        } catch (Exception e) {
            System.err.println("Fejl under indlæsning af spørgsmål: " + e.getMessage());
        }
    }

    // Getter for questions
    public List<Questions> getQuestions() {
        return questions;
    }
}

