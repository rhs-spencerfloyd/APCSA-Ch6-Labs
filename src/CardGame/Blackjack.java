package CardGame;

import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack {
    public static void main(String[] args) {

        // create scanner and deck of cards
        Scanner giveMeThe = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();

        // shuffle deck at beginning
        deck.shuffle();

        // create hands for dealer and player
        ArrayList<Card> dealer = new ArrayList<Card>();
        ArrayList<Card> player = new ArrayList<Card>();

        // deal 2 to dealer and player
        for (int i = 0; i < 2; i++) {
            dealer.add(deck.dealCard());
            player.add(deck.dealCard());
        }

        // show dealer's first card
        System.out.println("Dealer's First Card: " + dealer.get(0));

        // show player their cards
        System.out.println("\nYour hand: \n" + handToString(player));

        // check for instant win
        if (handValue(player) == 21) {
            System.out.println("You won Blackjack!");
            // show dealer's ending hand
            System.out.println("\nThe Dealer's ending hand was: \n" + handToString(dealer));
            System.exit(0);
        }
        if (handValue(dealer) == 21) {
            System.out.println("You lost Blackjack! The dealer's hand valued 21.");
            // show dealer's ending hand
            System.out.println("\nThe Dealer's ending hand was: \n" + handToString(dealer));
            System.exit(0);
        }

        // keep playing until someone busts or player says stay
        String input = "";
        do {

            // ask player what they want to do
            input = "";
            do {
                System.out.print("What do you want to do? (hit/stay) ");
                input = giveMeThe.nextLine();
            } while (!input.equals("stay") && !input.equals("hit"));

            // deal card to player if hit
            if (input.equals("hit")) {
                player.add(deck.dealCard());
            } else {
                // if player wants to stay, deal cards until dealer has >= 17
                while (handValue(dealer) < 17)
                    dealer.add(deck.dealCard());
            }

            // put a break in the console
            System.out.println("----------------------------------------");

            // show player their new hand
            System.out.println("\nYour hand: \n" + handToString(player));

        } while (handValue(player) < 21 && handValue(dealer) < 21 && !input.equals("stay"));

        // show dealer's ending hand
        System.out.println("\nThe Dealer's ending hand was: \n" + handToString(dealer));

        // calculate win/loss
        if (handValue(player) == 21)
            System.out.println("\nYou got Blackjack, you win!");
        else if (handValue(dealer) == 21)
            System.out.println("\nThe dealer got Blackjack, you lost!");
        else if (handValue(player) > 21 && handValue(dealer) > 21)
            System.out.println("\nIt's a tie! You and the dealer both busted!");
        else if (handValue(player) > 21)
            System.out.println("\nYou busted! Better luck next time!");
        else if (handValue(dealer) > 21)
            System.out.println("\nYou win, the dealer busted!");
        else {
            if (handValue(player) > handValue(dealer))
                System.out.println("\nYou win, your hand was closer to 21 than the dealer!");
            else {
                if (handValue(player) == handValue(dealer))
                    System.out.println("\nIt's a tie! You and the dealer both had " + handValue(player) + "!");
                else
                    System.out.println("\nYou lost, your hand was farther from 21 than the dealer!");
            }
        }
        System.exit(0);

    }


    // takes hand as input, outputs nicely formatted string
    public static String handToString(ArrayList<Card> hand) {
        String output = "";

        for (Card card : hand) {
            output += card + "\n";
        }
        output += "Total Value: " + handValue(hand);
        return output;
    }


    // calculates hand value given a hand
    public static int handValue(ArrayList<Card> hand) {
        int value = 0;
        int aces = 0;

        // add the value of all cards, excluding aces
        // add 1 to aces count for every ace
        for (Card card : hand) {
            if (card.getValue() == 0)
                aces++;
            else
                value += card.getValue();
        }

        // calculate hand with aces based on current value
        for (int i = 0; i < aces; i++) {
            value += getAceValue(value);
        }

        return value;
    }


    // calculates best use of ace value
    public static int getAceValue(int handWithoutAce) {
        if (handWithoutAce <= 10)
            return 11;
        return 1;
    }
}
