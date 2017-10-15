package com.skilldistillery.cards;

import java.util.Scanner;

public class Game {
	private Dealer dealer;
	private Player[] players;
	Scanner scanner = new Scanner(System.in);

	
	public Game() {
		super();
		this.dealer = new Dealer("Dealer");
		this.players = new Player[6];
	}
	
	public void mainLoop() {
		boolean quit = false;
		while (!quit) {		//while the game continues
			int numPlayers = getNumPlayers();					//ask how many players
			for (int i = 1; i <= numPlayers; i++) {				//add each player
				getPlayerNameAndAdd(i);
			}
			for (int i = 0; i < getPlayers().length; i++) {		//get each player's bet
				Player currentPlayer = getPlayers()[i];
				if (currentPlayer != null) {
					getPlayerBet(currentPlayer);
				}
			}
			dealingPhase();										//bets are placed, time to deal cards
			System.out.println("Dealer's hand shows: " + getDealer().getHand().getCardsInHand().get(0).cardAbbreviation());	//show one card in dealer's hand
			for (int i = 0; i < getPlayers().length; i++) {		//run each player's turn until stand or bust
				Player currentPlayer = getPlayers()[i];
				if (currentPlayer != null) {
					playerTurn(currentPlayer);					
				}
			}													//end of player turn loop
			
		}
	}
	
	public void dealerTurn() {
		System.out.println("Dealer's turn!");
		while (!getDealer().isStanding()) {
			Player dealer = getDealer();
			Hand dealerHand = getDealer().getHand();
			int dealerHandValue = getDealer().getHand().getCurrentValue();	//so i don't have to chain a bunch of calls
			System.out.println("\tDealer's cards: " + dealerHand.toString());
			System.out.println("\tCurrent value of dealer's hand: " + dealerHandValue);
			System.out.println("---Press enter to continue---");
			scanner.nextLine();
			if (getDealer().getHand().getCurrentValue() >= 18) {		//dealer has 18 or better, should stand
				System.out.println("\tDealer stands.");
				dealer.setStanding(true);
			}
			else if (getDealer().getHand().getCurrentValue() <= 17) {			//dealer has up to 17, may hit
				if (dealerHand.getAces() == 0 && dealerHandValue == 17) {		//dealer has hard 17, should stay
					System.out.println("\tDealer stands.");
					dealer.setStanding(true);		
				}
				else {														//dealer has soft 17 or less than 17, must hit
					boolean cont = hitPlayer(dealer);						//hit dealer
					if (!cont) {												//if hit was a bust
						System.out.println("\tDealer bust!!!");				//tell and show players
						System.out.println("\tDealer's cards: " + dealerHand.toString());
						System.out.println("\tValue of dealer's hand: " + getDealer().getHand().getCurrentValue());
						dealer.setStanding(true);							//end dealer turn
					}
				}
			}
		}
		System.out.println("\tDealer's turn is over.");
	}
	
	public void getPlayerBet(Player player) {					//asks player for their bet
		boolean inputSuccess = false;
		while (!inputSuccess) {
			System.out.print(player.getName() + ", please enter your bet. (Your wallet: " + player.getWallet() + "): ");
			if (scanner.hasNextInt()) {		//input is an int, run through placeBet to check validity
				int input = scanner.nextInt();
				scanner.nextLine();
				int betReturn = player.placeBet(input);
				if (betReturn == -1) {		//not enough in wallet to place bet
					System.out.println("You don't have enough money to place that wager! Please try again.");
				}
				else if (betReturn == 0){	//can't place a bet <= 0
					System.out.println("You can't place a bet that's less than or equal to zero! Please try again.");
				}
				else {									//all clear, go ahead
					inputSuccess = true;
				}
			}
			else {							//input isn't an int, try again
				scanner.nextLine();
				System.out.println("You didn't enter a number! Please try again.");
			}
		}
	}
	
	public void playerTurn(Player player) {		//runs each player's turn
		boolean inputSuccess = false;
		System.out.println(player.getName() + ", it's your turn!");		
		while (!inputSuccess) {
			System.out.println(player.getHand().toString());
			System.out.println("\tCurrent value of hand: " + player.getHand().getCurrentValue());
			System.out.print("Enter 1 to hit, 2 to stand: ");
			if (scanner.hasNextInt()) {					//input is an int, check to see if 1 or 2
				int input = scanner.nextInt();			//save input
				scanner.nextLine();						//clear scanner
				
				switch(input) {							//switch on input
					case 1:								//player wants to hit, run hitPlayer
						boolean cont = hitPlayer(player);

						if (!cont) {						//can they continue?
							System.out.println("\tBUST!!!");
							System.out.println("\t" + player.getHand().toString());
							System.out.println("\tValue of hand: " + player.getHand().getCurrentValue());
							inputSuccess = true;
						}
						
						break;
					case 2:								//player wants to stand, finish turn
						standPlayer(player);
						inputSuccess = true;
						break;
					default:								//invalid
						System.out.println("You didn't enter a valid menu choice! Please try again.");
						break;
				}
				
			}
			else {							//input isn't valid
				scanner.nextLine();
				System.out.println("You didn't enter a valid menu choice! Please try again.");
			}
		}
		System.out.println(player.getName() + ", your turn is over.");
	}
	
	public void getPlayerNameAndAdd(int playerNum) {
		boolean inputSuccess = false;
		while (!inputSuccess) {
			System.out.print("Player " + playerNum + ", please enter your name: ");
			String input = scanner.nextLine();
			int addCheck = addPlayerToGame(input);
			if (addCheck == -1) {
				System.out.println("There is already a player with that name! Please try again.");
			}
			else if (addCheck == 0) {										//TODO this should never happen
				System.out.println("There is no more space at this table!");
			}
			else {
				inputSuccess = true;
			}
		}
	}
	
	public int getNumPlayers() {
		boolean inputSuccess = false;
		int input = 0;
		while (!inputSuccess) {
			System.out.print("How many players are joining the table? (1-6): ");
			if (scanner.hasNextInt()) {		//it's an int
				input = scanner.nextInt();		//get it
				scanner.nextLine();				//clear scanner
				
				if (input >= 1 && input <= 6) {		//valid input
					inputSuccess = true;				//exit loop
				}
				else {	//number out of range, tell and ask again
					System.out.println("You can't have " + input + " players! Please try again.");
				}
				
			}
			else {		//invalid input
				System.out.println("You didn't enter a number! Please try again.");
				scanner.nextLine();			//clear scanner
			}
			
		}
		return input;
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
		}													//TODO actually probably don't need to check for space b/c i'm not allowing more players than I can hold
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
	
	public boolean hitPlayer(Player player) {			//return true if not bust, false if bust
		this.dealer.dealCard(player.getHand());			//deal card to player
		if (player.getHand().getCurrentValue() > 21) {	//if value is over 21, they're bust -- they can't go again
			return false;								//return false
		}
		else {											//otherwise, return true	-- they can go again
			return true;
		}
	}
	
	public void standPlayer(Player player) {
		player.setStanding(true);
	}
	
	public void announceWinners() {						//should check all players' hands against dealer's hand
		int dealerHandValue = this.getDealer().getHand().getCurrentValue();
		for (int j = 0; j < players.length; j++) {				//for each player in the list
			if (players[j] != null) {							//if they aren't null
				if (players[j].getHand().getCurrentValue() > dealerHandValue) {		//check their hand value against dealer's and set winner as appropriate
					players[j].winHand();
				}
			}
		}
	}

	
	//getters and setters
	public Dealer getDealer() {
		return dealer;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
}
