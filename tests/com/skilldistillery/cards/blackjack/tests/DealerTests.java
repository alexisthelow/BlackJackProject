package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Dealer;
import com.skilldistillery.cards.Player;

public class DealerTests {

	Dealer d;
	Player p;
	
	@Before
	public void setUp() throws Exception {
		d = new Dealer("Guy");
		p = new Player("Alexis");
	}

	@After
	public void tearDown() throws Exception {
		d = null;
		p = null;
	}

	@Test
	public void testDealCardToPlayerAndDealer() {
		d.getDeck().shuffleDeck();
		d.dealCard(p.getHand());
		d.dealCard(d.getHand());
		d.dealCard(p.getHand());
		d.dealCard(d.getHand());
		assertEquals(2, d.getHand().getCardsInHand().size());
		assertEquals(2, p.getHand().getCardsInHand().size());
	}
	
	@Test
	public void test_newDeck_gives_dealer_new_unshuffled_deck() {
		d.getDeck().shuffleDeck();
		d.dealCard(d.getHand());
		d.dealCard(d.getHand());
		d.dealCard(d.getHand());
		d.dealCard(d.getHand());
		d.dealCard(d.getHand());
		for (Card card : d.getHand().getCardsInHand()) {
			System.out.println(card.cardAbbreviation());
			System.out.println(card.toString());
		}
		d.newDeck();
		assertEquals(52, d.getDeck().getDeck().size());
	}

}
