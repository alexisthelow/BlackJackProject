package com.skilldistillery.cards;

import java.util.LinkedList;
import java.util.List;

public class Deck {

	List<Card> deck = new LinkedList<>();

	public Deck() {
		super();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	
	}
	
	
	
}
