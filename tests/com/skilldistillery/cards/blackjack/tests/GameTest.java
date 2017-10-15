package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Game;
import com.skilldistillery.cards.Player;

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
	public void test_getPlayerNameAndAdd_prints_correctly() {
		g.getPlayerNameAndAdd(1);
		assertEquals("Alexis", g.getPlayers()[0].getName());
		g.getPlayerNameAndAdd(2);
		assertEquals("Hana", g.getPlayers()[1].getName());
		g.getPlayerNameAndAdd(3);
		assertEquals("Cantrip", g.getPlayers()[2].getName());
		g.getPlayerNameAndAdd(4);
		assertEquals("Rosie", g.getPlayers()[3].getName());
	}
	
	@Test		
	public void test_GetPlayerNameAndAdd_rejects_on_fail_state() {			//TODO YOU ARE TESTING TO SEE IF GETPLAYERNAMEANDADD REJECTS THINGS
		g.getPlayerNameAndAdd(1);
		g.getPlayerNameAndAdd(2);
		g.getPlayerNameAndAdd(3);
		g.getPlayerNameAndAdd(4);
		g.getPlayerNameAndAdd(5);
		g.getPlayerNameAndAdd(6);
	}
	
	@Test
	public void test_getNumPlayers_returns_correct_input() {
		assertEquals(1, g.getNumPlayers());
		assertEquals(6, g.getNumPlayers());
		assertEquals(3, g.getNumPlayers());
	}
	
	@Test
	public void test_hitPlayer_gives_extra_card_to_Player() {
		g.addPlayerToGame("Alexis");
		g.addPlayerToGame("Hana");
		g.addPlayerToGame("Ginju");
		g.addPlayerToGame("Cantrip");
		g.dealingPhase();
		g.hitPlayer(g.getPlayers()[0]);
		g.hitPlayer(g.getPlayers()[3]);
		
		assertEquals(3, g.getPlayers()[0].getHand().getCardsInHand().size());
		assertEquals(2, g.getPlayers()[1].getHand().getCardsInHand().size());
		assertEquals(2, g.getPlayers()[2].getHand().getCardsInHand().size());
		assertEquals(3, g.getPlayers()[3].getHand().getCardsInHand().size());
	}
	
	@Test
	public void test_setStanding_stands_Player_and_Dealer() {
		g.addPlayerToGame("Alexis");
		g.addPlayerToGame("Hana");
		g.addPlayerToGame("Ginju");
		g.addPlayerToGame("Cantrip");
		for (int i = 0; i < g.getPlayers().length; i++) {
			if (g.getPlayers()[i] != null) {
				g.getPlayers()[i].setStanding(true);
			}
		}
		g.getDealer().setStanding(true);
		assertTrue(g.getDealer().isStanding());
		for (int i = 0; i < g.getPlayers().length; i++) {
			if (g.getPlayers()[i] != null) {
				assertTrue(g.getPlayers()[i].isStanding());
			}
		}
	}
	
	@Test
	public void test_dealingPhase_gives_each_player_and_the_dealer_two_cards() {
		g.addPlayerToGame("Alexis");
		g.addPlayerToGame("Hana");
		g.addPlayerToGame("Ginju");
		g.addPlayerToGame("Cantrip");
		g.dealingPhase();
		assertEquals(2, g.getDealer().getHand().getCardsInHand().size());
		for (int i = 0; i < g.getPlayers().length; i++) {
			if (g.getPlayers()[i] != null) {
				assertEquals(2, g.getPlayers()[i].getHand().getCardsInHand().size());
				
			}
		}
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
	
	@Test
	public void test_removePlayerFromGame_returns_true_when_player_is_present() {
		g.addPlayerToGame("Alexis");
		g.addPlayerToGame("Hana");
		g.addPlayerToGame("Marc");
		assertTrue(g.removePlayerFromGame("Alexis"));
		assertTrue(g.removePlayerFromGame("Hana"));
		assertTrue(g.removePlayerFromGame("Marc"));
	}
	
	@Test
	public void test_removePlayerFromGame_returns_false_when_player_is_not_present() {
		g.addPlayerToGame("Alexis");
		g.addPlayerToGame("Hana");
		g.addPlayerToGame("Marc");
		assertFalse(g.removePlayerFromGame("Rosie"));
		assertTrue(g.removePlayerFromGame("Alexis"));
		assertFalse(g.removePlayerFromGame("Cantrip"));
	}

}
