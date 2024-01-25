import java.util.Scanner;
import java.util.ArrayList;


public class Game {
    private Deck deck = new Deck();
    private Player p1;
    private Player p2;
    private Scanner scanner;
    private int round = 1;

    public Game() {
        System.out.println("Welome to the War Card Game!!!\r\n" + //
                "------------------------------\n");
        this.scanner = new Scanner(System.in);
        System.out.print("Please enter player 1's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Please enter player 2's name: ");
        String name2 = scanner.nextLine();
        this.deck = new Deck();
        this.p1 = new Player(name1);
        this.p2 = new Player(name2);
    }

    private void wins(Player winner) {
        System.out.println(winner.getName() + " wins this round!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.round++;
    }

    private void draw(String p1Name, Card p1Card, String p2Name, Card p2Card) {
        System.out.println("\nRound " + this.round + ":");
        System.out.println(p1Name + " drew " + p1Card + "; " + p2Name + " drew " + p2Card + ".");
    }

    public void playGame() {
        ArrayList<Card> cards = this.deck.getCards();
        System.out.println("\nBeginning War!!!");
        System.out.println("----------------");

        while (cards.size() >= 2) {
            System.out.print("Press q to quit. Press any other key to play: ");
            String response = scanner.nextLine();
            if (response.equals("q")) {
                break;
            }
            Card p1Card = deck.removeCard();
            Card p2Card = deck.removeCard();
            String p1Name = p1.getName();
            String p2Name = p2.getName();
            draw(p1Name, p1Card, p2Name, p2Card);
            if (p1Card.isGreaterThan(p2Card)) {
                p1.addWin();
                wins(p1);
            } else {
                p2.addWin();
                wins(p2);
            }
        }

        String win = winner(p1, p2);

        if (win == null) {
            System.out.println("\nWar is over. It was a tie!\n" + //
                    "");
        } else {
            System.out.println("\nWar is over. " + win + " wins!!!\n" + //
                    "");
        }
    }

    private String winner(Player p1, Player p2) {
        if (p1.getWins() > p2.getWins()) {
            return p1.getName();
        } else if (p2.getWins() > p1.getWins()) {
            return p2.getName();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
        game.scanner.close();
    }
}
