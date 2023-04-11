package GuessTheNumber;

import java.util.Scanner;

public class ConsoleManager {
    public static ConsoleManager instance = null;

    private Scanner scanner;

    private ConsoleManager(){
        scanner = new Scanner(System.in);
    }
    public static ConsoleManager getInstance(){
        if(instance == null){
            instance = new ConsoleManager();
        }
        return instance;
    }

    public String getInput(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
    public void printOutPut(String output){
        System.out.println(output);
    }
}
