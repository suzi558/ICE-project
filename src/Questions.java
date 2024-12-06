public class Questions {
    private int id;
    private String text;
    private String correctAnswer;
    private int points;
    private SQLite sqLite;

    public Questions(int id, String text, String correctAnswer, String otherChoice1, String otherChoice2, int points ) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getPoints() {
        return points;
    }
}
