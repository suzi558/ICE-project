public class Team {
    private String teamName;
    private int points;


    public Team() {

        this.points = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {this.teamName = teamName;}

    public int getPoints() {
        return points;
    }

    public void addPoint(int points) {
        this.points += points;
    }
}
