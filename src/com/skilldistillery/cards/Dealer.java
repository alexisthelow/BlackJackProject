package com.skilldistillery.cards;

public class Dealer extends Player {
	private Deck deck;
	
	
	public void dealCard(Hand hand) {		//deal a card to specified hand from current deck
		hand.addCard(this.deck.drawCard());
	}

	
	public void newDeck() {		//makes a new deck for this dealer
		this.deck = new Deck();
	}

	
	
	
	//constructor
	public Dealer(String name) {		//TODO add random names for dealers
		super(name, 0);				//dealers have no wallet
		this.deck = new Deck();
	}
	
	
	
	//getters

	public Deck getDeck() {
		return deck;
	}

	
}
