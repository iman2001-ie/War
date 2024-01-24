import java.util.ArrayList;
import java.util.Collections;
// import java.util.List;
import Card.java;


public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (int i = 2; i <= 14; i++) {
            for (int j = 0; j < 4; j++) {
                this.cards.add(new Card(i, j));
            }
        }
        for (int i = 0; i < 7; i++) {
            Collections.shuffle(this.cards);
        }
    }

    public Card removeCard() {
        if (this.cards.size() == 0) {
            return null;
        }
        return this.cards.remove(this.cards.size() - 1);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
