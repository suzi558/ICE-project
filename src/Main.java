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
        SQL.getQuestion();



    }

}