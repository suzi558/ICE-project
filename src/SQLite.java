import java.sql.*;
import java.util.ArrayList;

public class SQLite {

    private Connection conn;

    // Konstruktor - opretter forbindelse til databasen
    public SQLite() {
        try {
            // Erstat med din database-URL, hvis du bruger en rigtig SQLite-database
            String url = "jdbc:sqlite:trivial_pursuit.db";  // SQLite databasefil
            conn = DriverManager.getConnection(url);        // Opretter forbindelsen
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("Connection to SQLite failed: " + e.getMessage());
        }
    }

    // Henter spørgsmål for en valgt kategori
    public ArrayList<String> getQuestions(int categoryId) {
        ArrayList<String> questions = new ArrayList<>();
        String query = "SELECT question_text FROM questions WHERE category_id = ?";  // SQL-forespørgsel

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, categoryId);  // Sætter kategori-ID'et
            ResultSet rs = pstmt.executeQuery();  // Udfører forespørgslen

            // Henter spørgsmål fra resultatsættet
            while (rs.next()) {
                String question = rs.getString("question_text");
                questions.add(question);
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving questions: " + e.getMessage());
        }

        return questions;  // Returner listen af spørgsmål
    }

    // Lukker forbindelsen til databasen
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}





