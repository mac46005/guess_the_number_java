package factories;

import models.Player;

public class PlayerFactory implements IFactory<Player>{
    @Override
    public Player createClassT() {
        return new Player();
    }


}
