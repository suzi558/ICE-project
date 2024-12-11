import java.sql.*;
import java.util.ArrayList;

public class SQLite {
    private Connection conn;

    public void connect(String url) {
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("SQL connect works! HALLELUJAH");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public ArrayList<Questions> getQuestions() {
        ArrayList<Questions> questions = new ArrayList<>();
        String query = "SELECT id, Question, correctAnswer, otherChoice, otherChoice2, point FROM QUESTIONS;";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("Question");
                String correctAnswer = rs.getString("correctAnswer");
                String otherChoice = rs.getString("otherChoice");
                String otherChoice2 = rs.getString("otherChoice2");
                int point = rs.getInt("point");

                questions.add(new Questions(id, question, correctAnswer, otherChoice, otherChoice2, point));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving questions: " + e.getMessage());
        }
        return questions;
    }

    public ArrayList<Questions> getQuestionsByCategory(int categoryId) {
        ArrayList<Questions> questions = new ArrayList<>();
        String query = "SELECT id, Question, correctAnswer, otherChoice, otherChoice2, point FROM QUESTIONS WHERE category_id = ?;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, categoryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String questionText = rs.getString("Question");
                    String correctAnswer = rs.getString("correctAnswer");
                    String otherChoice1 = rs.getString("otherChoice");
                    String otherChoice2 = rs.getString("otherChoice2");
                    int points = rs.getInt("point");

                    questions.add(new Questions(id, questionText, correctAnswer, otherChoice1, otherChoice2, points));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving questions for category " + categoryId + ": " + e.getMessage());
        }
        return questions;
    }
}






