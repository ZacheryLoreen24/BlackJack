/* This is the card class, I made changes to the Card method
and
added the getValue method
 */

import java.util.*;
public class Card {
    private String face; // face o card ("Ace", "Deuce", ...)
    private String suit; // suit of card ("Hearts", Diamonds", etc)
    private int cardValue;
    private int playerValue;
    private int playerTotal;


    // two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card

        switch(face) { // switch case to set value of card
            case "Ace":
                cardValue = 11; // ace can be converted to 1 later
                break;
            case "Deuce":
                cardValue = 2;
                break;
            case "Three":
                cardValue = 3;
                break;
            case "Four":
                cardValue = 4;
                break;
            case "Five":
                cardValue = 5;
                break;
            case "Six":
                cardValue = 6;
                break;
            case "Seven":
                cardValue = 7;
                break;
            case "Eight":
                cardValue = 8;
                break;
            case "Nine":
                cardValue = 9;
                break;
            case "Ten":
            case "Jack":
            case "Queen":
            case "King":
                cardValue = 10;
                break;
        }
    } // end of Card Constructor

    public int getValue() {
        return cardValue;
    }

    // return String representation of Card
    public String toString() {
        return ("" + face + " of " + suit + " (" + this.getValue() + ")");
    } // end of toString method






} // end class Card