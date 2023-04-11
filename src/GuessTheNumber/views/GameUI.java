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
        Pattern pattern = Pattern.compile("^[0-9]+$");
        while(inputIncorrect){
            input = consoleManager.getInput("Please input an integer:");
            Matcher matcher = pattern.matcher(input);
            if(matcher.find() == true){
                break;
            }
        }
        return Integer.parseInt(input);
    }
    public void playerLow(){
        consoleManager.printOutPut("You are lower than the target");
    }
    public void playerHigh(){
        consoleManager.printOutPut("You are higher than the target");
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
        while(true){
            input = consoleManager.getInput("Do you want to play again?\nINTPUT: y(yes) or n(n)?");
            if(input.equals("y")){
                wantsRematch = true;
                break;
            }else if(input.equals("n")){
                break;
            }
            consoleManager.getInput("Please input either y or n!");
        }
        return wantsRematch;
    }
    public void displayPlayerWon(Player player, int target){
        StringBuilder sb = new StringBuilder();
        sb.append("You guessed the correct number!\n");
        sb.append("Target is " + target + "\n");
        sb.append("It took you " + player.getCurrentGameTries() + " to guess the correct number.\n");

        consoleManager.printOutPut(sb.toString());
    }
    public void promptPlayerContinue(){
        consoleManager.getInput("press any key to continue...");
    }
    public void invalidInput(){
        consoleManager.printOutPut("Please input a valid integer");
    }
}
