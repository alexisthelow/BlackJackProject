package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Game;

public class GameTest {

	Game g;
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
	}

	@After
	public void tearDown() throws Exception {
		g = null;
	}

	@Test
	public void test_addPlayerToGame_returns_1_if_no_duplicates_and_space_available() {
		assertEquals(1, g.addPlayerToGame("Alexis"));
	
	}
	
	@Test
	public void test_addPlayerToGame_returns_negative_1_when_duplicate() {
		assertEquals(1, g.addPlayerToGame("Alexis"));
		assertEquals(-1, g.addPlayerToGame("Alexis"));
	
	}
	
	@Test
	public void test_addPlayerToGame_returns_0_when_out_of_space() {
		assertEquals(1, g.addPlayerToGame("Alexis"));
		assertEquals(1, g.addPlayerToGame("Hana"));
		assertEquals(1, g.addPlayerToGame("Ginju"));
		assertEquals(1, g.addPlayerToGame("Rosie"));
		assertEquals(1, g.addPlayerToGame("Cantrip"));
		assertEquals(1, g.addPlayerToGame("Ronnie"));
		assertEquals(0, g.addPlayerToGame("Annie"));
		
	}

}
