public class Main {
    public static void main(String[] args) {
        // Opretter en SQLite-instans (hvis nødvendigt)
        SQLite db = new SQLite();

        // Opretter en GameUI instans og giver den SQLite instansen
        GameUI gameUI = new GameUI(db);

        // Starter spillet
        gameUI.startGame();
    }
}

