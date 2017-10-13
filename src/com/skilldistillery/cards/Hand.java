package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> cardsInHand = new ArrayList<>();
	
	
	public void addCard(Card card) {
		this.cardsInHand.add(card);
	}


	public List<Card> getCardsInHand() {
		return cardsInHand;
	}


	public void emptyHand() {		
		this.cardsInHand = new ArrayList<>();
	}
	
	public void addSpecificCard(Card card) {		//for test + debug only
		this.addCard(card);
	}


	public int getCurrentValue() {		//returns value of hand with checking for hard + soft aces
		int currentValue = 0;
		
		for (Card card : cardsInHand) {		//adds up the value of the hand, excluding aces
			if (card.getRank() != Rank.ACE) {
				currentValue += card.getRank().getValue();
			}
		}
		for (Card card : cardsInHand) {
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
