import java.sql.*;
import java.util.ArrayList;

public class DataReader {

    Connection conn;

    public void connect(String url) {

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("SQL connect works! HALLELUJAH");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Questions> getQuestions() {
        ArrayList<Questions> questionsList = new ArrayList<>();

        // Query String
        String question = "SELECT ID, Question, correctAnswer, otherChoice, otherChoice2, point, CategoryID FROM QUESTIONS;";

        try {
            Statement stmt = conn.createStatement();
            // Execute
            ResultSet rs = stmt.executeQuery(question);

            while (rs.next()) {
                // Fetch data for each column
                int id = rs.getInt("ID");
                String text = rs.getString("Question");
                String correctAnswer = rs.getString("correctAnswer");
                String otherChoice1 = rs.getString("otherChoice");
                String otherChoice2 = rs.getString("otherChoice2");
                int points = rs.getInt("point");
                int categoryID = rs.getInt("CategoryID");

                // Create a Questions object
                Questions quest = new Questions(id, text, correctAnswer, otherChoice1, otherChoice2, points, categoryID);

                // Add the Questions object to the list
                questionsList.add(quest);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return questionsList;
    }
}

/*
    public ArrayList<String> getCategories(){
            ArrayList<String> data = new ArrayList<>();

            String categories = "SELECT Category FROM Categories";

            try {

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(categories);

                while(rs.next()){

                    String row = rs.getString("Category");
                    data.add(row);
                }

            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        return data;
    }

    public ArrayList<String> getCorrectAnswer(){
        ArrayList<String> data = new ArrayList<>();

        String correct = "SELECT correctAnswer FROM QUESTIONS";

        try {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(correct);

            while(rs.next()){

                String row = rs.getString("correctAnswer");
                data.add(row);
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<String> getOtherChoice(){
        ArrayList<String> data = new ArrayList<>();

        String otherChoice = "SELECT otherChoice FROM QUESTIONS";

        try {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(otherChoice);

            while(rs.next()){

                String row = rs.getString("otherChoice");
                data.add(row);
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<String> getOtherChoice2(){
        ArrayList<String> data = new ArrayList<>();

        String otherChoice2 = "SELECT otherChoice2 FROM QUESTIONS";

        try {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(otherChoice2);

            while(rs.next()){

                String row = rs.getString("otherChoice2");
                data.add(row);
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<String> getPoint(){
        ArrayList<String> data = new ArrayList<>();

        String point = "SELECT Point FROM QUESTIONS";

        try {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(point);

            while(rs.next()){

                String row = rs.getString("Point");
                data.add(row);
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    }
*/




