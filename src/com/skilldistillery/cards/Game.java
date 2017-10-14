package com.skilldistillery.cards;


public class Game {
	private Dealer dealer;
	private Player[] players;
	
	public Game() {
		super();
		this.dealer = new Dealer("Dealer");
		this.players = new Player[6];
	}
	
	public int addPlayerToGame(String name) {
		for (int i = 0; i < this.players.length; i++) {		//check list of players to see if there's anyone with that name yet
			if (players[i] != null && players[i].getName().equals(name)) {
				return -1;									//if so, return -1
			}
		}
		for (int i = 0; i < players.length; i++) {			//check list of players to find an empty spot
			if (players[i] == null) {
				players[i] = new Player(name);
				return 1;									//if found, place player there and return 1
			}
		}
		return 0;											//player isn't duplicate, but no space; return 0
	}
	
	public boolean removePlayerFromGame(String name) {
		for (int i = 0; i < players.length; i++) {			//look through the player list
			if (players[i] != null && players[i].getName().equals(name)) {		//if found
				players[i] = null;							//remove them
				return true;									//and return true
			}
		}
		return false;										//otherwise, return false
	}

	public void dealCardToHand(Hand hand) {			//deals card from dealer's deck to specified hand
		this.dealer.dealCard(hand);
	}
	
	public void dealingPhase() {						//should put two cards in each player's hand, plus the dealer
		for (int i = 1; i <= 2; i++) {				//deal two rounds
			for (int j = 0; j < players.length; j++) {				//for each player in the list
				if (players[j] != null) {
					this.dealer.dealCard(players[j].getHand());	//give them a card
				}
			}
			this.dealer.dealCard(dealer.getHand());		//then give the dealer a card
		}
	}
	
	public void hitPlayer(Player player) {
		this.dealer.dealCard(player.getHand());
	}
	
	public void standPlayer(Player player) {
		player.setStanding(true);
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Player[] getPlayers() {
		return players;
	}
	
	//getters and setters
	
	
}
