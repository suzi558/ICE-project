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

    // Metode til at hente spørgsmål fra databasen
    public void loadQuestions(SQLite sqlite) {
        // Hent spørgsmål fra databasen, som er relateret til kategorien
        ArrayList<String> questionData = sqlite.getQuestion();  // Nu en ArrayList<String>

        if (questionData.isEmpty()) {
            System.out.println("Ingen spørgsmål fundet for kategori: " + this.categoryName);
            return;
        }

        try {
            // Gennemgår hver række af resultater fra databasen
            for (String row : questionData) {  // Iteration over en ArrayList<String>
                String[] parts = row.split(",");  // Splitter row-strengen til kolonner

                if (parts.length >= 6) { // Vi forventer, at vi har 6 kolonner (ID, spørgsmål, svar, valg, osv.)
                    int questionId = Integer.parseInt(parts[0]);  // ID for spørgsmålet
                    String questionText = parts[1];  // Spørgsmålstekst
                    String correctAnswer = parts[2];  // Korrekt svar
                    String otherChoice1 = parts[3];  // Alternative valg 1
                    String otherChoice2 = parts[4];  // Alternative valg 2
                    int points = Integer.parseInt(parts[5]);  // Point for spørgsmålet

                    // Et nyt spørgsmål oprettes med de udtrukne data og tilføjes til questions-listen
                    questions.add(new Questions(questionId, questionText, correctAnswer, otherChoice1, otherChoice2, points));
                } else {
                    System.err.println("Ugyldig række med manglende data: " + row);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Fejl ved typekonvertering af data: " + e.getMessage());
        }
    }


    // Getter for questions
    public List<Questions> getQuestions() {
        return questions;
    }
}
