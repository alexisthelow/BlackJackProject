package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> deck = new ArrayList<>();

	public Deck() {
		super();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}
	
	public Card drawCard() {
		return this.deck.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}
	
	public Card getNextCard() {		//for debugging only
		return this.deck.get(0);
	}
	
	
	
}
