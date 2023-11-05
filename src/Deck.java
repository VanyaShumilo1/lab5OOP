import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                int value = i + 2;
                if (i >= 10) {
                    value = 10;
                }
                if (i == 12) {
                    value = 11;
                }
                cards.add(new Card(ranks[i], suit, value));
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = rand.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}