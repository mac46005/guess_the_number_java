package GuessTheNumber.factories;

import GuessTheNumber.factories.IFactory;
import GuessTheNumber.models.Player;

public class PlayerFactory implements IFactory<Player> {
    @Override
    public Player createClassT() {
        return new Player();
    }


}
