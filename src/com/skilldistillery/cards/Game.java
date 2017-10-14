package com.skilldistillery.cards;


public class Game {
	private Dealer dealer;
	private Player[] players = new Player[6];
	
	public Game() {
		super();
		this.dealer = new Dealer("Dealer");
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
			if (players[i].getName().equals(name)) {		//if found
				players[i] = null;							//remove them
				return true;									//and return true
			}
		}
		return false;										//otherwise, return false
	}

	public void startNewGame() {
		
	}
	
}
