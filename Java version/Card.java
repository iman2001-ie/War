public class Card {
    // Card class

    // Note: The suits are arranged in order of strength with clubs being 
    //       the strongest and spades being the weakest suit.
    private static final String[] suits = {"spades", "hearts", "diamonds", "clubs"};

    // The first two value are "None" so that the indexing matches the numbers.
    // Note: The "Ace" is a high card in this game.
    private static final String[] values = {null, null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private int value;
    private int suit;

    public Card(int v, int s) {
        this.value = v;
        this.suit = s;
    }

    public boolean isLessThan(Card c2) {
        if (this.value < c2.value) {
            return true;
        } else {
            return this.value == c2.value && this.suit < c2.suit;
        }
        
    }

    public boolean isGreaterThan(Card c2) {
        if (this.value > c2.value) {
            return true;
        } else {
            return this.value == c2.value && this.suit > c2.suit;
        }
    }

    @Override
    public String toString() {
        return values[this.value] + " of " + suits[this.suit];
    }
}
    

