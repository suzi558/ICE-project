import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SQLite sqlite = new SQLite();
        String databaseUrl = "jdbc:sqlite:sqlite.db"; // Opdater denne med din faktiske database-sti

        // Forbind til databasen
        sqlite.connect(databaseUrl);

        // Hent kategorier
        System.out.println("Tilgængelige kategorier:");
        for (String category : sqlite.getCategories()) {
            System.out.println("- " + category);
        }

        // Lad brugeren vælge en kategori
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVælg en kategori:");
        String chosenCategory = scanner.nextLine();

        // Hent spørgsmål fra den valgte kategori
        Categories category = new Categories(1, chosenCategory); // ID er kun en placeholder
        category.loadQuestions(sqlite);

        // Vælg et spørgsmål fra kategorien
        if (category.getQuestions().isEmpty()) {
            System.out.println("Ingen spørgsmål fundet i kategorien.");
            return;
        }

        Questions question = category.getQuestions().get(0); // Henter det første spørgsmål
        System.out.println("\nSpørgsmål: " + question.getText());
        System.out.println("1. " + question.getCorrectAnswer());
        System.out.println("2. " + question.getOtherChoice1());
        System.out.println("3. " + question.getOtherChoice2());

        // Lad brugeren svare
        System.out.println("\nSkriv nummeret på dit svar:");
        int userAnswer = scanner.nextInt();

        // Tjek om svaret er korrekt
        if (userAnswer == 1) {
            System.out.println("Korrekt! Du får " + question.getPoints() + " point!");
        } else {
            System.out.println("Forkert! Det rigtige svar var: " + question.getCorrectAnswer());
        }
    }
}

