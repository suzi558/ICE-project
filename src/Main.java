import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var url = "jdbc:sqlite:sqlite.db";

        SQLite SQL = new SQLite();

        SQL.connect(url);
        SQL.getQuestion();

        ArrayList<String> categories = SQL.getCategories();
        getCategories(categories);

        ArrayList<String> questions = SQL.getQuestion();
        getData(questions);
    }

    public static void getCategories(ArrayList<String> categories){
        for (String c: categories) {
            System.out.println(c); }
        }

    public static void getData(ArrayList<String> questions){
        for (String s: questions){
            System.out.println(s);
        }
    }

}