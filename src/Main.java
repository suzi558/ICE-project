public class Main {
    public static void main(String[] args) {
        // Initialiser SQLite-objektet
        DataReader sqlite = new DataReader();
        sqlite.connect("jdbc:sqlite:sqlite.db"); // Tilpas URL til din database

        // Opret en instans af GameUI
        GameUI gameUI = new GameUI(sqlite);

        // Start spillet
        gameUI.startGame();
    }
}
