public class Questions {
    private int id;
    private String text;
    private String correctAnswer;
    private String otherChoice1;
    private String otherChoice2;
    private int points;
    private int categoryID;

    public Questions(int id, String text, String correctAnswer, String otherChoice1, String otherChoice2, int points, int categoryID) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.otherChoice1 = otherChoice1;
        this.otherChoice2 = otherChoice2;
        this.points = points;
        this.categoryID = categoryID; // Tilføj denne linje
    }
    public int getId() {
        return id;
    }
    public int getCategoryID() {
        return categoryID;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getOtherChoice1() {
        return otherChoice1;
    }

    public String getOtherChoice2() {
        return otherChoice2;
    }

    public int getPoints() {
        return points;
    }
}
