import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class SQLite {

Connection conn;

public void connect (String url){

    try {
        conn = DriverManager.getConnection(url);
        System.out.println("SQL connect works! HALLELUJAH");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    public ArrayList<String> getQuestion(){
    ArrayList<String> data = new ArrayList<>();

    //Query String
    String question = "SELECT Question, correctAnswer, otherChoice, otherChoice2, point FROM QUESTIONS;";

    try {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        // Execute
        ResultSet rs = stmt.executeQuery(question);

        while(rs.next()){
            String row = rs.getString("Question, correctAnswer, otherChoice, otherChoice2")+","+rs.getInt("point");
            data.add(row);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return data;
    }


    }





