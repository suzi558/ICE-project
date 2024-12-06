import java.util.ArrayList;
import java.util.List;


public class Categories {
    private int id; // Et unikt ID for kategorien.
    private String CategoryName; //Navnet på kategorien.
    private List<Questions> questions; //En liste, der holder på alle spørgsmål i denne kategori.

    //Constructoren initialiserer id og categoryName med de værdier, der gives som parametre.
    public Categories(int id, String categoryName) {
        this.id = id;
        this.CategoryName = categoryName;
        this.questions = new ArrayList<>(); // Initialiser som en tom liste
    }


    public void loadQuestions(SQLite sqlite) {
        List<List<Object>> results = sqlite.getQuestionsByCategory(this.id);

        if (results.isEmpty()) {
            System.err.println("Ingen spørgsmål fundet for kategori: " + this.id);
            return;
        }

        try {
            for (List<Object> col : results) {
                if (col.size() >= 4) { // Sikrer, at rækken har nok kolonner
                    int id = (int) col.get(1);               // ID
                    String questionText = (String) col.get(2); // Spørgsmålstekst
                    String answer = (String) col.get(3);    // Svar
                    String otherChoice1 = (String) col.get(4);
                    String otherChoice2 = (String) col.get(5);
                    int points = (int) col.get(4);           // Point

                    questions.add(new Questions(id, questionText, answer, otherChoice1, otherChoice2, points));
                } else {
                    System.err.println("Ugyldig række med manglende data: " + col);
                }
            }
        } catch (ClassCastException e) {
            System.err.println("Fejl ved typekonvertering af spørgsmål: " + e.getMessage());
        }
    }
}
