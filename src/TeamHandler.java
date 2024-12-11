import java.util.ArrayList;

public class TeamHandler {
    private ArrayList<Team> teams;
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

    // Metode til at hente alle teams
    public ArrayList<Team> getTeams() {
        return teams;
    }

    // Metode til at gemme team-data i databasen
    public void saveTeam(Team team) {
        // SQL for at gemme team-data i SQLite-database
    }
}
