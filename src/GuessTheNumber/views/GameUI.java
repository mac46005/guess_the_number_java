package GuessTheNumber.views;

import GuessTheNumber.ConsoleManager;
import GuessTheNumber.models.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameUI {
    private ConsoleManager consoleManager;
    private String input = "";
    public GameUI(){
        consoleManager = ConsoleManager.getInstance();
    }

    public void welcomeMessage(){
        consoleManager.printOutPut("Welcome to GUESS THE NUMBER!!!!!\nInput the correct number and WIN!!!!");
    }
    public int getInputMessage(){
        boolean inputIncorrect = true;
        Pattern pattern = Pattern.compile("^[0-9]+&");
        while(inputIncorrect){
            input = consoleManager.getInput("Please input an integer:");
            Matcher matcher = pattern.matcher(input);
            if(matcher.find() == true){
                break;
            }
        }
        return Integer.parseInt(input);
    }

    public void displayPlayerStats(Player player){
        StringBuilder sb = new StringBuilder();
        sb.append("PLAYER STATS\n");
        sb.append("Total Games: " + player.getTotalGames() + "\n");
        sb.append("Won: " + player.getTotalWins() + "\n");
        sb.append("Lost: " + player.getLoses() + "\n");
        sb.append("Avg: " + player.getAvgWin() + "\n");
        sb.append("Largest Int guessed: "+ player.getLargestIntGuessed() + "\n");
        if(player.getCurrentGameTries() > 0){
            sb.append("Current Tries: " + player.getCurrentGameTries() + "\n");
        }
        consoleManager.printOutPut(sb.toString());
    }

    public boolean promptRematch(){
        String input = "";
        boolean wantsRematch = false;
        boolean isInvalidInput = true;
        while(isInvalidInput){
            input = consoleManager.getInput("Do you want to play again?\nINTPUT: y(yes) or n(n)?");
            if(input == "n"){
                wantsRematch =  false;
            }else{
                wantsRematch = true;
            }
            invalidInput();
        }
        return wantsRematch;
    }

    public void invalidInput(){
        consoleManager.printOutPut("Please input a valid integer");
    }
}
