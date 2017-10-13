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

}
