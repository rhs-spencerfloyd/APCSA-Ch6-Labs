package CardGame;

/**
 * Name: Spencer Floyd
 * Date: 10-24-18
 * Period: 1
 *
 * CardGame.Card.java
 *
 * Represents a Card with a face and a suit.
 */

public class Card
{
    private String face;
    private String suit;
    private int value;

    public Card (String cardFace, String cardSuit, int cardValue)
    {
        face = cardFace;
        suit = cardSuit;
        value = cardValue;
    }

    public String toString()
    {
        return face + " of " + suit;
    }

    public String getFace() {
        return face;
    }
    
    public String getSuit() {
        return suit;
    }

    public int getValue() { return value; }

}
