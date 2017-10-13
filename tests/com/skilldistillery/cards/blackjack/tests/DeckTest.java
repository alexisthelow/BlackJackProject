package com.skilldistillery.cards.blackjack.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class DeckTest {

	Deck d;
	
	@Before
	public void setUp() throws Exception {
		d = new Deck();
	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}

//	@Test
//	public void testDrawCard() {		//top card should be clubs 2, moving down rank -> suit
//		assertEquals(52, d.getDeck().size());
//		assertEquals("TWO of CLUBS", d.drawCard().toString());
//		assertEquals("THREE of CLUBS", d.drawCard().toString());
//		assertEquals("FOUR of CLUBS", d.drawCard().toString());
//		assertEquals("FIVE of CLUBS", d.drawCard().toString());
//	}
	
//	@Test
//	public void testDeckShuffle() {		//check to see that shuffle works, should return cards, print out long and short strings
//		d.shuffleDeck();
//		System.out.println(d.getNextCard().toString());
//		System.out.println(d.getNextCard().cardAbbreviation());
//		assertTrue(d.drawCard() instanceof Card);
//		System.out.println(d.getNextCard().toString());
//		System.out.println(d.getNextCard().cardAbbreviation());
//		assertTrue(d.drawCard() instanceof Card);
//		System.out.println(d.getNextCard().toString());
//		System.out.println(d.getNextCard().cardAbbreviation());
//		assertTrue(d.drawCard() instanceof Card);
//		System.out.println(d.getNextCard().toString());
//		System.out.println(d.getNextCard().cardAbbreviation());
//		assertTrue(d.drawCard() instanceof Card);
//		System.out.println(d.getNextCard().toString());
//		System.out.println(d.getNextCard().cardAbbreviation());
//		assertTrue(d.drawCard() instanceof Card);
//		
//	}

}
