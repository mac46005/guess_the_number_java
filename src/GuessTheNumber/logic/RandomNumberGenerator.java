package GuessTheNumber.logic;

import java.util.Random;

public class RandomNumberGenerator {
    public int generateRandomInteger(int min, int max){
        Random rand = new Random();

        return rand.nextInt(max - min + 1) + min;
    }
}
