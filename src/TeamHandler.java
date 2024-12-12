import java.util.ArrayList;

public class TeamHandler {
    public ArrayList<Team> teams;
    private SQLite sqlite;

    // Konstruktør
    public TeamHandler() {
        teams = new ArrayList<>();
        sqlite = new SQLite(); // Opretter en instans af SQLite
    }

    // Metode til at tilføje et team
    public void addTeam(Team team) {
        teams.add(team);
    }

    // Metode til at gemme et team
   /* public void saveTeam(Team team) {
      //  sqlite.saveData();
    }*/

    // Metode til at få vinderen af spillet
    public Team getWinner() {
        Team winner = null;
        int maxPoints = 0;

        for (Team team : teams) {
            if (team.getPoints() > maxPoints) {
                maxPoints = team.getPoints();
                winner = team;
            }
        }
        return winner;
    }

    // Metode til at opdatere point
    public void updatePoint(Team team, int points) {
        team.addPoint(points);
    }
}