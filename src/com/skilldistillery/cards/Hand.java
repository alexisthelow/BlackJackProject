package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> hand = new ArrayList<>();
	private int currentValue;
	
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	
	
	
}
