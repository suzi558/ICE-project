//Velkomstbesked(Metode i TextUI)
//Opret Team(Brug metoden i Team)
//StartGame(En metode vi selv laver, hvor vi udelukkende kalder på vores metoder i bestemt rækkefølge)
 //- Inkluder timer (Når tid er gået ELLER svar skrevet, Andet hold til at svare i samme kategori og derefter vælge kategori og sprgsmål)
//Henter hold(metode i TeamHandler)
//Vælg kategori(brug promptNumeric i TextUI og meget i Categories klassen)
//Print spørgsmål til kategori(Daniel har den)
//Tildeler point til hold ved rigtigt svar(Teamhandler)
//Tildeler spillet en vinder(Brug metode i Teamhandler. Vinderen finder vi ved at det ene hold skal være foran med 30 point(Vi skal ændre i metoden))



import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUI {
    private Questions questions;
    private Categories categories;
    private TextUI ui;
    private Team team;
    private TeamHandler handler;
    private DataReader reader;

    Team team1;
    Team team2;

    GameUI(DataReader reader) {
        this.team = new Team();
        this.ui = new TextUI();
        this.handler = new TeamHandler();
        this.questions = new Questions();
        this.categories = new Categories(reader);
        this.reader = new DataReader();
    }

    public String teamCreate() {
        //Første trin | Velkomstbesked
        ui.displayMsg("Velkommen til Trivia Pursuit!");
        //Opretter hold
        String teamName1 = ui.promptText("Opret et holdnavn til hold 1.");
        team.getTeamName(teamName1);

        String teamName2 = ui.promptText("Opret et holdnavn til hold 2.");
        team.getTeamName(teamName2);
        return teamName1 + teamName2;
    }

    public void startGame() {

        teamCreate();
        Timer.startTimer();
    }

    public void chooseCategory() {
        categories.getCategories();
        int number = ui.promptNumeric("Choose a category");




        switch (number) {

            case 1:
                categories.loadQuestions();
                break;


            case 2:
                categories.loadQuestions();
                break;

            case 3:
                categories.loadQuestions();
                break;

            case 4:
                categories.loadQuestions();
                break;

            case 5:
                categories.loadQuestions();
                break;
            default:


        }
/*
public TeamHandler winnerOfGame(){
        handler.getWinner();

}

 */

    }


}