import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Card class representing an individual card
class Card {
    private String color;
    private int value;

    public Card(String color, int value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}

// Deck class representing a deck of cards
class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initialize();
        shuffle();
    }

    private void initialize() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        for (String color : colors) {
            for (int value = 0; value <= 9; value++) {
                cards.add(new Card(color, value));
                if (value != 0) { // Skip adding another 0 card
                    cards.add(new Card(color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null; // Deck is empty
        }
    }
}

// Player class representing a player
class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void displayHand() {
        System.out.println(name + "'s Hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println();
    }
}
public class UnoGame {
    public static void main(String[] args) {
        int numPlayers = 4;

        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));
        players.add(new Player("Player 4"));


        Deck deck = new Deck();

        // Deal 7 cards to each player
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                if (card != null) {
                    player.addCard(card);
                }
            }
        }

        // Display each player's hand
        for (Player player : players) {
            player.displayHand();
        }
    }
}
