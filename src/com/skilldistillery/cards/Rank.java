package com.skilldistillery.cards;

public enum Rank {
	TWO('\u2461'),
	THREE('\u2462'),
	FOUR('\u2463'),
	FIVE('\u2464'),
	SIX('\u2465'),
	SEVEN('\u2466'),
	EIGHT('\u2467'),
	NINE('\u2468'),
	TEN('\u2469'),
	JACK('\u24bf'),
	QUEEN('\u24c6'),
	KING('\u24c0'),
	ACE('\u24b6');
	
	private char abbreviation;

	private Rank(char abbreviation) {
		this.abbreviation = abbreviation;
	}

	public char getAbbreviation() {
		return abbreviation;
	}
	
	
	
	
	
}
