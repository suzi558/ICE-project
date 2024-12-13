//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) {

        var url = "jdbc:sqlite:sqlite.db";

        DataReader SQL = new DataReader();

        SQL.connect(url);

        for (Questions q: SQL.getQuestions()){
            System.out.println(q.toString());
        }





    }

}