import java.util.ArrayList;

public class Categories {
    private int id;
    private String CategoryName;
    private ArrayList<Questions> questions;
    private SQLite sqLite;

    public Categories(int id, String categoryName) {
        this.id = id;
        CategoryName = categoryName;
        this.questions = questions;
        this.sqLite = sqLite;
    }

    public void loadQuestions(){

    }

}
