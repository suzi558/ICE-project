public class Team {
    private String teamName;
    private int points;


    public Team(String teamName) {
        this.teamName = teamName;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint(int points) {
        this.points += points;
    }
}