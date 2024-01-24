import java.util.Scanner;
import java.util.ArrayList;
import Card.java;
import Deck.java;
import Player.java;


public class Game {
    private Deck deck = new Deck();
    private Player p1;
    private Player p2;

    public Game() {
        this.explainGame();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter player 1's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Please enter player 2's name: ");
        String name2 = scanner.nextLine();
        this.deck = new Deck();
        this.p1 = new Player(name1);
        this.p2 = new Player(name2);
    }

    public void explainGame() {
        String note = """
                Welome to the War card-game!!!
                ------------------------------
                
                Game Overview:
                
                War is a classic two-player card game that is simple yet exciting. 
                The objective is to win the most number of rounds!
                
                
                1. Pre-game Notes:
                
                   - The Ace is the highest-ranked card in this game.
                   - The suits are ranked differently as well. Here are the suits from 
                     strongest to weakest:
                     
                          clubs - 4 points
                          diamonds - 3 points
                          hearts - 2 points
                          spades - 1 point
                      
                
                2. Setup:
                
                   - A standard 52-card deck is divided equally between two players.
                   - Each player receives their own stack of cards, face down.
                
                
                
                3. Gameplay:
                
                   The Deal:
                   
                   - Players simultaneously reveal the top card of their stack.
                   - The player with the higher-ranked card (the higher-number card) 
                     wins that round of the game. 
                     
                   Ties("War"):
                   
                   - If the revealed cards are of equal rank, a "war" is declared.
                   - Then, the player with the higher-ranked suit wins that round of the game.
                   
                   Winning the Game:
                   
                   - The game continues until there are no more cards left.
                   - The player with the most number of won rounds, wins.
                   
                   
                   
                Enjoy the classic game of War! May luck be with you!
                """;
    
        System.out.println(note);
    }

    private void wins(Player winner) {
        System.out.println(winner.getName() + " wins this round!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void draw(String p1Name, Card p1Card, String p2Name, Card p2Card) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(p1Name + " drew " + p1Card + "; " + p2Name + " drew " + p2Card + ".");
    }

    public void playGame() {
        ArrayList<Card> cards = this.deck.getCards();
        System.out.println("\nBeginning War!!!");
        System.out.println("----------------");

        while (cards.size() >= 2) {
            System.out.print("\nPress q to quit. Press any other key to play:\n");
            Scanner scanner = new Scanner(System.in);
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
            System.out.println("War is over. It was a tie!");
        } else {
            System.out.println("War is over. " + win + " wins!!!");
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
    }
}
