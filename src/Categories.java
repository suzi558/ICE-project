import java.util.ArrayList;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

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
    List<List<Object>> result =
    }

}
