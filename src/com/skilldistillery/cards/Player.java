package com.skilldistillery.cards;

public class Player {

	private String name;
	private Hand hand;
	private double wallet;
	

	public boolean placeBet(double bet) {
		if (this.wallet - bet < 0) {			//can't place that bet
			return false;					//return false
		}
		else {								//can place bet
			this.wallet -= bet;				//decrement wallet
			return true;						//return true
		}
	}
	
	public void addCardToHand(Card card) {
		this.hand.addCard(card);
	}
	
	
	
	
	//constructor -- just needs a name
	public Player(String name) {
		super();
		this.name = name;
		this.hand = new Hand();
		this.wallet = 1000;		//default value for wallet. idk is 1000 bucks okay?
	}

	
	//getters and setters
	public Hand getHand() {
		return hand;
	}

	public String getName() {
		return name;
	}

	public double getWallet() {
		return wallet;
	}
	
	
	
	
	
}
