package com.android.project21;

/**
 * Created by jonnymartin on 19/04/2016.
 */
public class Player {
    //private Deck myDeck;
    public int balance = 0;
    public int[]playerCardArray = {0,0,0,0,0};
    public int[]dealerCardArray = {0,0,0,0,0};


    public void setup()

    {

    // myDeck.shuffle();

    }

    public void hit(Player aPlayer)

    {

     if (aPlayer.equals ("Player")) {

        // playerCardArray.hit();
     } else {
      //   dealerCardArray.hit();
     }


    }

    public int getBalance()

    {

       return this.balance;

    }

}
