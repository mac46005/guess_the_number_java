package GuessTheNumber.models;

public class Player {
    private int totalGames = 0;
    private int totalWins = 0;

    public Player(){

    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
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
}
