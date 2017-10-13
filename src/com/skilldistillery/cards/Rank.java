package com.skilldistillery.cards;

public enum Rank {
	TWO('\u2461', 2),
	THREE('\u2462', 3),
	FOUR('\u2463', 4),
	FIVE('\u2464', 5),
	SIX('\u2465', 6),
	SEVEN('\u2466', 7),
	EIGHT('\u2467', 8),
	NINE('\u2468', 9),
	TEN('\u2469', 10),
	JACK('\u24bf', 10),
	QUEEN('\u24c6', 10),
	KING('\u24c0', 10),
	ACE('\u24b6', 1);
	
	private char abbreviation;
	private int value;

	private Rank(char abbreviation, int value) {
		this.abbreviation = abbreviation;
		this.value = value;
	}

	public char getAbbreviation() {
		return abbreviation;
	}
	
	
	
	
	
}
