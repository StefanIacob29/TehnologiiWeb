package services;

import enums.Rank;
import enums.Suit;
import exceptions.EmptyDeckException;
import exceptions.NotEnoughCardsException;
import models.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Card> cards = new ArrayList<>();

    public Card dealCard() throws EmptyDeckException {
        if (cards.isEmpty()) {
            throw new EmptyDeckException("There are no cards to deal");
        }
        //get the last element from cards
        Card topCard = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return topCard;
    }

    public List<Card> dealCards(int numberOfCards) throws NotEnoughCardsException {
        if (cards.size() < numberOfCards) {
            throw new NotEnoughCardsException("There are not enough cards to deal" + numberOfCards);
        }
        // get the last numberOfCards elements from list
        List<Card> requestedCards = new ArrayList<>();
        requestedCards = cards.subList(Math.max(cards.size() - numberOfCards, 0), cards.size());
        cards.remove(cards.size() - numberOfCards);
        return requestedCards;
    }

    public void fill() {
        int numberOfSuitsWithoutJokerSpecificOnes = 4;
        int numberOfRanksWithoutJokers = 13;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
