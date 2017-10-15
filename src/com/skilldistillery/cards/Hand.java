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
	
	public int getAces() {		//return 0+ based on how many aces are in a hand
		int aces = 0;
		for (Card card : cardsInHand) {
			if (card.getRank() == Rank.ACE) {
				aces++;
			}
		}
		return aces;
	}


	public int getCurrentValue() {		//returns value of hand with checking for hard + soft aces
		int currentValue = 0;
		
		for (Card card : cardsInHand) {		//adds up the value of the hand, excluding aces
			if (card.getRank() != Rank.ACE) {
				currentValue += card.getRank().getValue();
			}
		}
		int aces = 0;
		for (Card card : cardsInHand) {
			if (card.getRank() == Rank.ACE) {		//TODO -- this method may return problems with more than one ace. should check to see if there is more than one ace before adding full value
				aces++;
			}
		}
			
//				if (currentValue + 11 <= 21) {		//if adding a full ace wouldn't exceed 21
//					currentValue += 11;				//add 11
//				}
//				else {								//otherwise
//					currentValue += 1;				//add 1
//				}
		if (aces >= 1) {								//if there is more than one ace
			currentValue += (aces - 1) * 1;			//add all but one as value 1
			if(currentValue + 11 > 21) {				//if adding 11 would bust
				currentValue += 1;					//add the final one as value 1
			}
			else {									//adding 11 won't bust, so add it
				currentValue += 11;
			}
		}
		
		if (currentValue > 21) {						//they're bust, set value to 0
			currentValue = 0;
		}
		return currentValue;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Card card : cardsInHand) {
			builder.append(card.cardAbbreviation()).append(" ");
		}
		return builder.toString();
	}
	
	
	
	
}
