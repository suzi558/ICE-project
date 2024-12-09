//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SQLite SQL = new SQLite();

        SQL.connect("jdbc:sqlite:identifier.sqlite");
        SQL.getQuestion();
        System.out.println(SQL.getQuestion());
    }
}