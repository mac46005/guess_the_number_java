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
        player.incrementTotalWins();
        player.incrementTotalGames();
        player.setLargestIntGuessed(randNum);
        gameUI.displayPlayerWon(player, randNum);
        gameUI.displayPlayerStats(player);
        player.setCurrentGameTries(0);
        randNum = randNumGen.generateRandomInteger(min,max);
        return gameUI.promptRematch();
    }
    private boolean processPlayerOverTarget(){
        player.incrementCurrentGameTries();
        gameUI.playerHigh();
        return gameUI.promptRematch();
    }
    private boolean processPlayerUnderTarget(){
        player.incrementCurrentGameTries();
        gameUI.playerLow();
        return gameUI.promptRematch();
    }
    private void showPlayerStats(){
        gameUI.displayPlayerStats(player);
    }
    public int run(){
        boolean isRunning = true;
        randNum = randNumGen.generateRandomInteger(min, max);
        gameUI.welcomeMessage();
        if(player.getTotalGames() > 0){
            showPlayerStats();
        }

        while(isRunning && player.getCurrentGameTries() != max){
            input = gameUI.getInputMessage();
            switch (checkIntEquality(input, randNum)){
                case 0:
                    isRunning = processPlayerWon();
                    break;
                case 1:
                    isRunning = processPlayerOverTarget();
                    break;
                case -1:
                    isRunning =processPlayerUnderTarget();
                    break;
            }
        }

        gameUI.goodbyeMessage();

        return 0;
    }
}
