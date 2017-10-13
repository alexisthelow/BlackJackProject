package com.skilldistillery.cards;

public class Card implements Comparable<Card> {
	
	private Rank rank;
	private Suit suit;
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card c) {		//sorts on suit, then rank
		if (this.getSuit().ordinal() < c.getSuit().ordinal()) {	//lower suit, return -1
			return -1;
		}
		else if (this.getSuit().ordinal() > c.getSuit().ordinal()) {	//higher suit, return 1
			return 1;
		}
		else {	//suits must be equal, sort on rank
			if (this.getRank().ordinal() < c.getRank().ordinal()) {	//lower rank, return -1
				return -1;
			}
			else if (this.getRank().ordinal() > c.getRank().ordinal()) {	//higher rank, return 1
				return 1;
			}
			
		}
		return 0;	//suit and rank are equal, must be identical to other card
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank).append(" of ").append(suit);
		return builder.toString();
	}
	
	
	
	
}
