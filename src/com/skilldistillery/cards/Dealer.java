package com.skilldistillery.cards;

public class Dealer {
	private String name;
	private Deck deck;
	private Hand hand;
	
	
	public void dealCard(Player player) {		//deal a card to specified player from current deck
		player.addCardToHand(this.deck.drawCard());
	}

	public void emptyHand() {	//should empty the dealer's hand
		this.hand = new Hand();
	}
	
	public void newDeck() {		//makes a new deck for this dealer
		this.deck = new Deck();
	}

	
	
	//constructor
	public Dealer(String name, Deck deck, Hand hand) {
		this.name = name;
		this.deck = new Deck();
		this.hand = new Hand();
	}
	
	//getters
	public String getName() {
		return name;
	}

	public Deck getDeck() {
		return deck;
	}

	public Hand getHand() {
		return hand;
	}
	
	
	
	
	
	
}
