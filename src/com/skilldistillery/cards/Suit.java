package com.skilldistillery.cards;

public enum Suit {
	CLUBS('\u2663'), 
	DIAMONDS('\u2662'), 
	HEARTS('\u2661'), 
	SPADES('\u2660');
	
	private char symbol;

	private Suit(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}
	
	
}
