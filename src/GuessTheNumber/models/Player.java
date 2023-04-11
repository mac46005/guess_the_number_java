package GuessTheNumber.models;

public class Player {
    private int totalGames = 0;
    private int totalWins = 0;
    private int largestIntGuessed = 0;
    private int currentGameTries = 0;

    public Player(){

    }
    public int getTotalGames() {
        return totalGames;
    }
    public void incrementTotalWins(){
        this.totalWins++;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getLargestIntGuessed() {
        return largestIntGuessed;
    }

    public int getCurrentGameTries() {
        return currentGameTries;
    }
    public void incrementCurrentGameTries(){
        currentGameTries++;
    }
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }
    public void incrementTotalGames(){
        this.totalGames++;
    }
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getLoses(){
        return totalGames - totalWins;
    }
    public double getAvgWin(){
        return (((double)totalWins/(double)totalGames) * 100);
    }

    public void setLargestIntGuessed(int largestIntGuessed) {
        if(this.largestIntGuessed < largestIntGuessed){
            this.largestIntGuessed = largestIntGuessed;
        }
    }

    public void setCurrentGameTries(int currentGameTries) {
        this.currentGameTries = currentGameTries;
    }

}
