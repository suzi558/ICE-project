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
        // Henter en liste af lister fra databasen baseret på kategorien (via id). results er en liste,
        // hvor hver indre liste repræsenterer en række i tabellen.

        if (results.isEmpty()) {
            System.err.println("Ingen spørgsmål fundet for kategori: " + this.id);
            return;
            //Hvis der ikke findes nogen rækker for denne kategori, udskrives
            // en fejlmeddelelse, og metoden afsluttes.
        }

        try {
            for (List<Object> col : results) { //For hver række (col), som er en liste af objekter, forsøger vi at udtrække dataene.
                if (col.size() >= 4) { // Sikrer, at rækken har nok kolonner
                    int id = (int) col.get(1);               // ID
                    String questionText = (String) col.get(2); // Spørgsmålstekst
                    String answer = (String) col.get(3);    //  correcte Svar
                    String otherChoice1 = (String) col.get(4); //Alternative valg
                    String otherChoice2 = (String) col.get(5); //Alternative valg
                    int points = (int) col.get(4);           // Point


                    //Et nyt spørgsmål oprettes med de udtrukne data og tilføjes til questions-listen.
                    questions.add(new Questions(id, questionText, answer, otherChoice1, otherChoice2, points));
                } else {
                    System.err.println("Ugyldig række med manglende data: " + col);
                } //Hvis en række mangler data, udskrives en fejlmeddelelse.
            }
        } catch (ClassCastException e) {
            System.err.println("Fejl ved typekonvertering af spørgsmål: " + e.getMessage());
            //håndterer situationer, hvor dataene ikke kan konverteres
            // til den forventede type (fx int eller String).
        }
    }
}
