package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;

public class HandTest {

	Hand h;
	
	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@After
	public void tearDown() throws Exception {
		h = null;
	}

	@Test
	public void testGetHandValueForCardsEqualingNineteen() {		//successful
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.QUEEN));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.TWO));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.SEVEN));
		assertEquals(19, h.getCurrentValue());
	}

	@Test
	public void testGetHandValueForCardsEqualingTwentyWithOneAce() {		//successful
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.SIX));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.THREE));
		assertEquals(20, h.getCurrentValue());
	}
	
	@Test
	public void testGetHandValueForCardsEqualingTwentyWithTwoAces() {		//successful
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.SIX));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.DIAMONDS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.TWO));
		assertEquals(20, h.getCurrentValue());
	}
	
	@Test
	public void testGetHandValueForCardsEqualingTwentyOneWithFourAces() {		//successful
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.FIVE));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.DIAMONDS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.HEARTS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.TWO));
		h.addSpecificCard(new Card(Suit.SPADES, Rank.ACE));
		assertEquals(21, h.getCurrentValue());
	}
	
	@Test
	public void testGetHandValueForCardsEqualingTwentyOneWithFourAces_and_a_queen() {		//successful
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.QUEEN));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.DIAMONDS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.HEARTS, Rank.ACE));
		h.addSpecificCard(new Card(Suit.CLUBS, Rank.SEVEN));
		h.addSpecificCard(new Card(Suit.SPADES, Rank.ACE));
		assertEquals(21, h.getCurrentValue());
	}
	
	

}
