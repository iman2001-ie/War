import Card.java;


public class Player {
    private int wins;
    private Card card;
    private String name;

    public Player(String name) {
        this.wins = 0;
        this.card = null;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getWins() {
        return this.wins;
    }

    public void addWin() {
        this.wins += 1;
    }
}