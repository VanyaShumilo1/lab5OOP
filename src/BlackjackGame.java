import java.util.Scanner;

class BlackjackGame {
    private final Deck deck;
    private final Player player;
    private final Player dealer;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    public void dealInitialCards() {
        deck.shuffle();
        player.clearHand();
        dealer.clearHand();
        player.addCard(deck.draw());
        player.addCard(deck.draw());
        dealer.addCard(deck.draw());
        dealer.addCard(deck.draw());
    }

    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (player.getScore() < 21) {
            System.out.println("Your hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
            System.out.print("Do you want to hit (h) or stand (s)? ");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("h")) {
                player.addCard(deck.draw());
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
    }

    public void dealerTurn() {
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.draw());
        }
    }

    public void determineWinner() {
        System.out.println("Player's hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
        System.out.println("Dealer's hand: " + dealer.getHand() + " (Score: " + dealer.getScore());

        if (player.getScore() > 21 || (dealer.getScore() <= 21 && dealer.getScore() >= player.getScore())) {
            System.out.println("Dealer wins!");
        } else if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void play() {
        dealInitialCards();
        playerTurn();
        dealerTurn();
        determineWinner();
    }
}