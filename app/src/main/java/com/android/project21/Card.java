package com.android.project21;

/**
 * Created by andrewporter on 10/04/2016.
 */
public class Card {
    private Suit cardSuit;
    private int cardValue;

    public Card(Suit suit, int number) {
        this.cardSuit = suit;
        this.cardValue = number;
    }

    public int getCardValue() {
        return cardValue;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }
}
