package GuessTheNumber.views;

import GuessTheNumber.ConsoleManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameUI {
    private ConsoleManager consoleManager;
    private String input = "";
    public GameUI(){
        consoleManager = ConsoleManager.getInstance();
    }

    public void WelcomeMessage(){
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


}
