//Velkomstbesked(Metode i TextUI)
//Opret Team(Brug metoden i Team)
//StartGame(En metode vi selv laver, hvor vi udelukkende kalder på vores metoder i bestemt rækkefølge)
 //- Inkluder timer (Når tid er gået ELLER svar skrevet, Andet hold til at svare i samme kategori og derefter vælge kategori og sprgsmål)
//Henter hold(metode i TeamHandler)
//Vælg kategori(brug promptNumeric i TextUI og meget i Categories klassen)
//Print spørgsmål til kategori(Daniel har den)
//Tildeler point til hold ved rigtigt svar(Teamhandler)
//Tildeler spillet en vinder(Brug metode i Teamhandler. Vinderen finder vi ved at det ene hold skal være foran med 30 point(Vi skal ændre i metoden))



import java.awt.desktop.QuitStrategy;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class GameUI {
    private Questions questions;
    private Categories categories;
    private TextUI ui;
    private Team team;
    private TeamHandler handler;
    private Random rand;
    private int round;
    private Team currentTeam;
    private DataReader reader;




    Team team1 = new Team();
    Team team2 = new Team();

    GameUI(DataReader reader) {
        this.reader = reader;
        this.ui = new TextUI();
        this.handler = new TeamHandler();
        this.questions = new Questions();
        this.categories = new Categories(reader);
        this.rand = new Random();
        this.round = 1;
    }

    public String teamCreate() {
        //Første trin | Velkomstbesked
        ui.displayMsg("Velkommen til Trivia Pursuit!");
        //Opretter hold

        String teamName1 = ui.promptText("Opret et holdnavn til hold 1.");
        team1.setTeamName(teamName1);


        String teamName2 = ui.promptText("Opret et holdnavn til hold 2.");
        team2.setTeamName(teamName2);
        return team1.getTeamName()+team2.getTeamName();
    }


    public void startGame() {

        teamCreate();

        currentTeam = team1;

        chooseCategory();


    }

    public void chooseCategory() {
        ArrayList<Questions> QuestionList = reader.getQuestions();
        ArrayList<String> randomQuest = new ArrayList<>();
        categories.getCategories();
        int number = ui.promptNumeric("Choose a category");



        switch (number) {

            case 1:
                int min = 0;
                int max = 9;
                int randomNumber = (rand.nextInt(max - min + 1) + min);
                randomQuest.add(QuestionList.get(randomNumber).getOtherChoice2());
                randomQuest.add(QuestionList.get(randomNumber).getOtherChoice1());

                randomQuest.add(random(), QuestionList.get(randomNumber).getCorrectAnswer());



                System.out.println("Test af random: " + randomNumber);

                ui.displayMsg(QuestionList.get(randomNumber).getText());

                ui.displayMsg("1. " + randomQuest.get(0));
                ui.displayMsg("2. " + randomQuest.get(1));
                ui.displayMsg("3. " + randomQuest.get(2));
                int point = QuestionList.get(randomNumber).getPoints();
                Timer.startTimer();
                if (ui.promptNumeric("Insert the number equal to your answer") == randomQuest.indexOf(QuestionList.get(randomNumber).getCorrectAnswer())+1) {
                    pointDealer(true, point);
                }
                else { pointDealer(false, point); }


                break;


            case 2:

                min = 10;
                max = 19;
                randomNumber = (rand.nextInt(max - min + 1) + min);
                System.out.println("Test af random: " + randomNumber);

                ui.displayMsg(QuestionList.get(randomNumber).getText());

                ui.displayMsg("1. " + QuestionList.get(randomNumber).getOtherChoice2());
                ui.displayMsg("2. " + QuestionList.get(randomNumber).getCorrectAnswer());
                ui.displayMsg("3. " + QuestionList.get(randomNumber).getOtherChoice1());
                Timer.startTimer();


                break;

            case 3:

                min = 20;
                max = 29;
                randomNumber = (rand.nextInt(max - min + 1) + min);
                System.out.println("Test af random: " + randomNumber);

                ui.displayMsg(QuestionList.get(randomNumber).getText());

                ui.displayMsg("1. " + QuestionList.get(randomNumber).getOtherChoice2());
                ui.displayMsg("2. " + QuestionList.get(randomNumber).getCorrectAnswer());
                ui.displayMsg("3. " + QuestionList.get(randomNumber).getOtherChoice1());
                Timer.startTimer();



                break;

            case 4:

                min = 30;
                max = 39;
                randomNumber = (rand.nextInt(max - min + 1) + min);
                System.out.println("Test af random: " + randomNumber);

                ui.displayMsg(QuestionList.get(randomNumber).getText());

                ui.displayMsg("1. " + QuestionList.get(randomNumber).getOtherChoice2());
                ui.displayMsg("2. " + QuestionList.get(randomNumber).getCorrectAnswer());
                ui.displayMsg("3. " + QuestionList.get(randomNumber).getOtherChoice1());
                Timer.startTimer();
                break;

            case 5:

                min = 40;
                max = 49;
                randomNumber = (rand.nextInt(max - min + 1) + min);
                System.out.println("Test af random: " + randomNumber);

                ui.displayMsg(QuestionList.get(randomNumber).getText());

                ui.displayMsg("1. " + QuestionList.get(randomNumber).getOtherChoice2());
                ui.displayMsg("2. " + QuestionList.get(randomNumber).getCorrectAnswer());
                ui.displayMsg("3. " + QuestionList.get(randomNumber).getOtherChoice1());
                Timer.startTimer();
                break;

            default:


                rounds();
        }


/*
public TeamHandler winnerOfGame(){
        handler.getWinner();

}

 */

    }

    public void rounds() {



    }


    public int pointDealer(boolean prut, int point) {

        //    (questions.getCorrectAnswer())

        currentTeam = (currentTeam == team1) ? team2 : team1;


        if ((prut)) {
            ui.displayMsg("The answer is correct! Your team get's " + point + " points");
            handler.updatePoint(currentTeam, point);


        } else {
            System.out.println("The answer is wrong! Time for the other team to change the score");
        }
        ui.displayMsg("Det er " + currentTeam.getTeamName() + "'s tur");
        round++;

        return point;
    }

    public int getWinner() {
        return getWinner();


    }

    public int random(){
        return (rand.nextInt(3));
    }



}