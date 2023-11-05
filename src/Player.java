import java.util.ArrayList;
import java.util.List;

class Player {
    private final String name;
    private final ArrayList<Card> hand = new ArrayList<>();
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
        score += card.getValue();
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void clearHand() {
        hand.clear();
        score = 0;
    }

    public String getName() {
        return name;
    }
}