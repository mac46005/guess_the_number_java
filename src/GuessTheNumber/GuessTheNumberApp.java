package GuessTheNumber;

import GuessTheNumber.logic.IApp;
import GuessTheNumber.models.Player;
import GuessTheNumber.views.GameUI;

public class GuessTheNumberApp implements IApp {
    GameUI gameUI = new GameUI();
    private int input = 0;
    private boolean isRunning = false;
    private Player player = new Player();
    public int run(){
        gameUI.WelcomeMessage();

        while(isRunning){
            input = gameUI.getInputMessage();
        }
        return 0;
    }
}
