package Lab10;

import java.util.*;

//implement Deck methods which uses class Card
// populateDeck() and printDeck()
// assign each card to deck
// populate deck array using nested loops
// Google Java nested loops
// Print out full deck

public class Deck {

    // an array of size 52; elements are of type Card
    Card[] deck;
    final String[] suit = { "D", "S", "C", "H" };

    // construct an array of 52 cards
    public Deck() {
        deck = new Card[52];
    }

    public static void main(String[] args) {
        System.out.println("Lab 10 written by Elizabeth Graham\n");  // Output student name

        Deck d = new Deck();
        d.populateDeck();
        d.printDeck();

    }

    // assign each card to deck
    // populates array using nested loops
    // Google Java nested loops
    public void populateDeck() {

        int index = 0; // index into deck
        for (int i = 0; i < suit.length; i++) {
            for (int j = 1; j < 14; j++) {
                deck[index] = new Card(suit[i], j);
                index++;
            }
        }

        // outer for loop (i) for suit, inner for loop (j) for rank 1 - 13
    } // method

    public void printDeck() {
        double idx = 1;
        // for loop that prints all cards in deck
        for (int i = 0; i < deck.length; i++) {
            // inside loop: print each card in Deck using Card RankAndSuit()
            System.out.println(deck[i].RankAndSuit());

            // If the remainder of idx/13 is even or 1, add a blank line for spacing
            // This is just the first method that came to mind, probably overlooking something simple
            if (Double.valueOf((idx / 13.0)) % 2 == 0 || Double.valueOf((idx / 13.0)) % 2 == 1) {
                System.out.println();  // Add some spacing between the suits
            }
            idx++;
        }

    } // method

} // class
