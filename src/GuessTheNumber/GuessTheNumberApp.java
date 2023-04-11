package GuessTheNumber;

import GuessTheNumber.logic.IApp;
import GuessTheNumber.logic.RandomNumberGenerator;
import GuessTheNumber.models.Player;
import GuessTheNumber.views.GameUI;

public class GuessTheNumberApp implements IApp {
    GameUI gameUI = new GameUI();
    RandomNumberGenerator randNumGen = new RandomNumberGenerator();
    private int input = 0;
    private int randNum = 0;
    private int min = 0;
    private int max = 10;
    private Player player = new Player();
    private boolean isEqualToRandNum(int input){
        if(input == randNum){
            return true;
        }
        return false;
    }
    private int checkIntEquality(int input, int target){
        if(input == target){
            return 0;
        }else if(input > target){
            return 1;
        }else{
            return -1;
        }
    }
    private void incrementPlayerStats(){
        player.incrementTotalGames();
        player.incrementTotalWins();
    }
    private void resetPlayerTryCount(){
        player.setCurrentGameTries(0);
    }

    private boolean processPlayerWon(){
        boolean continueGame = false;
        return continueGame;
    }
    private void processPlayerOverTarget(){

    }
    private void processPlayerUnderTarger(){

    }
    private void showPlayerStats(){

    }
    public int run(){
        boolean isRunning = true;
        randNum = randNumGen.generateRandomInteger(min, max);
        gameUI.welcomeMessage();
        if(player.getTotalGames() > 0){
            showPlayerStats();
        }

        while(isRunning){
            input = gameUI.getInputMessage();
            switch (checkIntEquality(input, randNum)){
                case 0:
                    isRunning = processPlayerWon();
                    break;
                case 1:
                    processPlayerOverTarget();
                    break;
                case -1:
                    processPlayerUnderTarger();
                    break;
            }
        }
        return 0;
    }
}
