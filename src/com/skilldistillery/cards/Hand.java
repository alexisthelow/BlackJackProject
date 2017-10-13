package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> hand = new ArrayList<>();
	
	
	public void addCard(Card card) {
		this.hand.add(card);
	}


	public List<Card> getHand() {
		return hand;
	}


	public void setHand(List<Card> hand) {
		this.hand = hand;
	}


	public int getCurrentValue() {
		int currentValue = 0;
		
		for (Card card : hand) {		//adds up the value of the hand, excluding aces
			if (card.getRank() != Rank.ACE) {
				currentValue += card.getRank().getValue();
			}
		}
		for (Card card : hand) {
			if (card.getRank() == Rank.ACE) {
				if (currentValue + 11 < 21) {		//if adding a full ace wouldn't exceed 21
					currentValue += 11;				//add 11
				}
				else {								//otherwise
					currentValue += 1;				//add 1
				}
			}
		}
		return currentValue;
	}
	
	
	
	
}
