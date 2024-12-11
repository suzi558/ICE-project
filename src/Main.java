import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var url = "jdbc:sqlite:sqlite.db";

        SQLite SQL = new SQLite();

        SQL.connect(url);
        SQL.getQuestion();

        ArrayList<String> categories = SQL.getCategories();
        //getCategory1Questions(categories);

        ArrayList<String> questions = SQL.getQuestion();
        getData(questions);

    }

    public void getCategories(ArrayList<String> questions) {


        switch(TextUI.scan.nextLine())
        {

            case "1":
                for (int i = 0; i <= 10; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "2":
                for (int i = 10; i <= 20; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "3":
                for (int i = 20; i <= 30; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "4":
                for (int i = 30; i <= 40; i++) {
                    System.out.println(questions.get(i));
                }
                break;
            case "5":
                for (int i = 40; i == 50; i++) {
                    System.out.println(questions.get(i));
                }
                break;


        }
    }


    /*
    public static void getCategories(ArrayList<String> categories){
        for (String c: categories) {
            System.out.println(c); }

            for(int i = 0; i<=10; i++) {
                System.out.println(questions.get(i));
            }
            break;
        }
*/
    public static void getData(ArrayList<String> questions){
        for (String s: questions){
            System.out.println(s);
        }
    }

}