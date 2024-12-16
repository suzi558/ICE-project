//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        var url = "jdbc:sqlite:sqlite.db";
        DataReader reader = new DataReader();
        reader.connect(url);
        GameUI Game = new GameUI(reader);

        Game.startGame();

        /*
        for (Questions q : db.getQuestions()) {
            System.out.println(q.toString());}
            ArrayList<Categories> categories = db.getCategories();
        for (Categories c: categories){
            System.out.println(c);
        }
    */






    }
}







