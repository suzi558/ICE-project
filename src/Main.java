public class Main {
    public static void main(String[] args) {
        GameUI game = new GameUI("jdbc:sqlite:quizgame.db");
        game.startGame();
    }
}
