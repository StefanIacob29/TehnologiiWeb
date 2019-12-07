package services;

import models.Card;

import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> alreadyPlayedCards = new ArrayList<>();
    private static final int MINIMUM_VALUE_OF_PLAYED_CARDS = 1;
    private static final int LAST_ELEMENT_OFFSET = 1;

    public void addCard(Card card){
        alreadyPlayedCards.add(card);
    }

/*    public ArrayList<Card> releaseAllCardsButFirst(){

    }*/

    public Card getTopCard(){
        // get the last element of an ArrayList
         return alreadyPlayedCards.get(alreadyPlayedCards.size() - 1);
    }

    public Card eraseTopCard(){
        Card requestCard = getTopCard();
        alreadyPlayedCards.remove(requestCard);
        return requestCard;
    }


}
