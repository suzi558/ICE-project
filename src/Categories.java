import java.util.ArrayList;
import java.util.List;


public class Categories {
    private int id;
    private String CategoryName;
    private List<Questions> questions;
    private SQLite sqLite;

    public Categories(int id, String categoryName) {
        this.id = id;
        CategoryName = categoryName;
        this.questions = questions;
        this.sqLite = sqLite;
    }

    public void loadQuestions(){
    List<List<Object>> results =sqLite.getQuestionsByCategory(this.id);
    if(!results.isEmpty()){
        List<Object[]> rows = (List<Object[]>) results.get(0);
        for(Object rowObj : rows){
            List<Object> row = (List<Object>) rowObj;
            questions.add(new Questions(
                    (int) row.get(0),
                    (String) row.get(2),
                    (String) row.get(3),
                    (int) row.get(6)
            ));
        }

        }
    }

}
