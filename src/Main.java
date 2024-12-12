import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) {


        var url = "jdbc:sqlite:sqlite.db";

        SQLite SQL = new SQLite();

        SQL.connect(url);
SQL.connect("jdbc:sqlite:sqlite.db");
        SQLite.getQuestionsByCategory();
int chooseCategory = 4;
Questions question = SQL.getQuestionsByCategory(chooseCategory);

if(question != null){
    System.out.println("Question" + question.getText());
    System.out.println("correctAnswer" + question.getCorrectAnswer());
    System.out.println("otherChoice" + question.getOtherChoice1());
    System.out.println("otherChoice2" + question.getOtherChoice2());

}



    }

}