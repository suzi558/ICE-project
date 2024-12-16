import java.util.ArrayList;
import java.util.List;

public class Categories {
    private DataReader reader;


    private int id; // Et unikt ID for kategorien.
    private String categoryName; // Navnet på kategorien.
    private List<Questions> questions; // En liste, der holder på alle spørgsmål i denne kategori.

    // Constructoren initialiserer id og CategoryName med de værdier, der gives som parametre.
    public Categories(String categoryName, int id) {
        this.id = id;
        this.categoryName = categoryName;
        this.questions = new ArrayList<>(); // Initialiser som en tom liste
    }

    public Categories(DataReader reader){
        this.reader = reader;
    }

    public int getId() { return id; }

    public String getCategoryName() {
        return categoryName;
    }

  //Printer alle kategorier
    public void getCategories() {
        for (Categories c : reader.getCategories()) {
            System.out.println(c.toString());
        }
    }



    // Metode til at hente spørgsmål fra databasen
    public void loadQuestions() {
        try {
            // Hent alle spørgsmål fra SQLite-klassen
            ArrayList<Questions> allQuestions = reader.getQuestions();

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

    public String toString(){
        return getId()+". "+getCategoryName();
    }

}