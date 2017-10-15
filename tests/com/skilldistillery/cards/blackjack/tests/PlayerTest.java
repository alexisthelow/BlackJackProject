package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Player;

public class PlayerTest {
	
	Player p;

	@Before
	public void setUp() throws Exception {
		p = new Player("Alexis");
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

//	@Test
//	public void testNewPlayerIsAccurate() {
//		assertEquals("Alexis", p.getName());
//		assertEquals(1000, p.getWallet(), 0.001);
//	}
	
	@Test
	public void testPlaceWagerDecrementsPlayerWallet() {
		assertEquals(1000, p.getWallet(), 0.001);
		p.placeBet(20);
		assertEquals(980, p.getWallet(), 0.001);
		p.placeBet(91);
		assertEquals(889, p.getWallet(), 0.001);
	}
	
	@Test
	public void test_place_wager_returns_false_if_bet_is_larger_than_wallet() {
		assertEquals(-1, p.placeBet(1001));
	}
	
	@Test
	public void test_placeWager_returns_0_if_bet_is_0_or_less() {
		assertEquals(0, p.placeBet(0));
		assertEquals(0, p.placeBet(-1));
	}
	
	@Test
	public void test_placeWager_returns_1_only_if_bet_is_valid() {
		assertEquals(1, p.placeBet(10));
		assertEquals(-1, p.placeBet(1000));
		assertEquals(0, p.placeBet(0));
	}
	
	@Test
	public void test_winHand_adds_currentBet_times_2_to_wallet() {
		p.placeBet(100);
		p.winHand();
		assertEquals(1100, p.getWallet(), 0.001);
	}

}
