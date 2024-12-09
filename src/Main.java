import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var url = "jdbc:sqlite:sqlite.db";

        SQLite SQL = new SQLite();

        SQL.connect(url);
        SQL.getQuestion();

        ArrayList<String> data = SQL.getQuestion();
        getData(data);
    }

    public static void getData(ArrayList<String> data){
        for (String s: data){
            System.out.println(s);
        }
    }

}