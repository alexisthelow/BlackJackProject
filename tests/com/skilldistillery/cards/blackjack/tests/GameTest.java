package com.skilldistillery.cards.blackjack.tests;

import static org.junit.Assert.*;

import javax.annotation.Generated;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Game;
import com.skilldistillery.cards.Player;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;

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
	
//	@Test
//	public void test_bet_is_pushed_when_player_and_dealer_bust() {
//		g.addPlayerToGame("Alexis");
//		g.getPlayers()[0].getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.JACK));
//		g.getPlayers()[0].getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.JACK));
//		g.getPlayers()[0].getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.JACK));
//		g.addPlayerToGame("Marc");
//		g.getPlayers()[1].getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.JACK));
//		g.getPlayers()[1].getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.JACK));
//		g.getPlayers()[1].getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.JACK));
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.KING));
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.KING));
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.KING));
//		g.announceWinners();
//		assertEquals(1000, g.getPlayers()[0].getWallet(), 0.001);
//		assertEquals(1000, g.getPlayers()[1].getWallet(), 0.001);
//	}
	
//	@Test
//	public void test_dealerTurn_ends_correctly() {
//		g.addPlayerToGame("Alexis");
//		g.getDealer().getDeck().shuffleDeck();
//		g.dealingPhase();
//		g.dealerTurn();
//	}
	
	
//	@Test
//	public void test_game_is_over_when_dealer_has_blackjack_and_players_who_have_21_win() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Airik");		//add two players
//		g.dealingPhase();
//		g.getPlayers()[0].getHand().emptyHand();
//		g.getPlayers()[0].getHand().addSpecificCard(new Card(Suit.DIAMONDS, Rank.ACE));
//		g.getPlayers()[0].getHand().addSpecificCard(new Card(Suit.DIAMONDS, Rank.KING));		//clear player hand and add blackjack
//		g.getDealer().getHand().emptyHand();
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.ACE));
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.KING));		//clear dealer hand and add blackjack
//		System.out.println(g.getPlayers()[0].getHand().toString());
//		System.out.println(g.getPlayers()[1].getHand().toString());
//		g.offerInsurance(g.getPlayers()[0]);
//		g.offerInsurance(g.getPlayers()[1]);
//		
//		assertTrue(g.getDealer().blackjackCheck());
//		assertTrue(g.getPlayers()[0].blackjackCheck());
//		assertFalse(g.getPlayers()[1].blackjackCheck());
//		g.announceWinners();
//	}
	
//	@Test
//	public void test_game_is_over_when_dealer_has_blackjack() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Airik");		//add two players
//		g.dealingPhase();
//		g.getDealer().getHand().emptyHand();
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.ACE));
//		g.getDealer().getHand().addSpecificCard(new Card(Suit.CLUBS, Rank.KING));		//clear dealer hand and add blackjack
//		System.out.println(g.getPlayers()[0].getHand().toString());
//		System.out.println(g.getPlayers()[1].getHand().toString());
//		
//		
//		assertTrue(g.getDealer().blackjackCheck());
//		g.announceWinners();
//	}
//	
	@Test
	public void test_mainLoop_executes() {
		g.mainLoop();
	}
	
	
//	@Test
//	public void test_playerTurn_correctly_stands() {
//		g.addPlayerToGame("Alexis");
//		g.getDealer().getDeck().shuffleDeck();
//		g.dealingPhase();
//		g.playerTurn(g.getPlayers()[0]);
//		assertTrue(g.getPlayers()[0].isStanding());
//	}
	
//	@Test
//	public void test_playerTurn_correctly_busts() {
//		g.addPlayerToGame("Alexis");
//		g.dealingPhase();
//		g.playerTurn(g.getPlayers()[0]);
//		assertTrue(g.getPlayers()[0].getHand().getCurrentValue() == 0);
//	}
	
//	@Test
//	public void test_playerTurn_correctly_outputs_cards() {
//		g.addPlayerToGame("Alexis");
//		g.dealingPhase();
//		g.playerTurn(g.getPlayers()[0]);
//		
//	}
	
	
//	@Test
//	public void test_getPlayerBet_correctly_places_bet_and_returns_control_after_successful_input() {
//		g.addPlayerToGame("Alexis");
//		g.getPlayerBet(g.getPlayers()[0]);
//		assertEquals(100, g.getPlayers()[0].getCurrentBet(), 0.001);
//		
//	}
	
//	@Test
//	public void test_getPlayerNameAndAdd_prints_correctly() {
//		g.getPlayerNameAndAdd(1);
//		assertEquals("Alexis", g.getPlayers()[0].getName());
//		g.getPlayerNameAndAdd(2);
//		assertEquals("Hana", g.getPlayers()[1].getName());
//		g.getPlayerNameAndAdd(3);
//		assertEquals("Cantrip", g.getPlayers()[2].getName());
//		g.getPlayerNameAndAdd(4);
//		assertEquals("Rosie", g.getPlayers()[3].getName());
//	}
//	
//	@Test		
//	public void test_GetPlayerNameAndAdd_rejects_on_fail_state() {			
//		g.getPlayerNameAndAdd(1);
//		g.getPlayerNameAndAdd(2);
//		g.getPlayerNameAndAdd(3);
//		g.getPlayerNameAndAdd(4);
//		g.getPlayerNameAndAdd(5);
//		g.getPlayerNameAndAdd(6);
//	}
//	
//	@Test
//	public void test_getNumPlayers_returns_correct_input() {
//		assertEquals(1, g.getNumPlayers());
//		assertEquals(6, g.getNumPlayers());
//		assertEquals(3, g.getNumPlayers());
//	}
//	
//	@Test
//	public void test_hitPlayer_gives_extra_card_to_Player() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Hana");
//		g.addPlayerToGame("Ginju");
//		g.addPlayerToGame("Cantrip");
//		g.dealingPhase();
//		g.hitPlayer(g.getPlayers()[0]);
//		g.hitPlayer(g.getPlayers()[3]);
//		
//		assertEquals(3, g.getPlayers()[0].getHand().getCardsInHand().size());
//		assertEquals(2, g.getPlayers()[1].getHand().getCardsInHand().size());
//		assertEquals(2, g.getPlayers()[2].getHand().getCardsInHand().size());
//		assertEquals(3, g.getPlayers()[3].getHand().getCardsInHand().size());
//	}
//	
//	@Test
//	public void test_setStanding_stands_Player_and_Dealer() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Hana");
//		g.addPlayerToGame("Ginju");
//		g.addPlayerToGame("Cantrip");
//		for (int i = 0; i < g.getPlayers().length; i++) {
//			if (g.getPlayers()[i] != null) {
//				g.getPlayers()[i].setStanding(true);
//			}
//		}
//		g.getDealer().setStanding(true);
//		assertTrue(g.getDealer().isStanding());
//		for (int i = 0; i < g.getPlayers().length; i++) {
//			if (g.getPlayers()[i] != null) {
//				assertTrue(g.getPlayers()[i].isStanding());
//			}
//		}
//	}
//	
//	@Test
//	public void test_dealingPhase_gives_each_player_and_the_dealer_two_cards() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Hana");
//		g.addPlayerToGame("Ginju");
//		g.addPlayerToGame("Cantrip");
//		g.dealingPhase();
//		assertEquals(2, g.getDealer().getHand().getCardsInHand().size());
//		for (int i = 0; i < g.getPlayers().length; i++) {
//			if (g.getPlayers()[i] != null) {
//				assertEquals(2, g.getPlayers()[i].getHand().getCardsInHand().size());
//				
//			}
//		}
//	}
//
//	@Test
//	public void test_addPlayerToGame_returns_1_if_no_duplicates_and_space_available() {
//		assertEquals(1, g.addPlayerToGame("Alexis"));
//	
//	}
//	
//	@Test
//	public void test_addPlayerToGame_returns_negative_1_when_duplicate() {
//		assertEquals(1, g.addPlayerToGame("Alexis"));
//		assertEquals(-1, g.addPlayerToGame("Alexis"));
//	
//	}
//	
//	@Test
//	public void test_addPlayerToGame_returns_0_when_out_of_space() {
//		assertEquals(1, g.addPlayerToGame("Alexis"));
//		assertEquals(1, g.addPlayerToGame("Hana"));
//		assertEquals(1, g.addPlayerToGame("Ginju"));
//		assertEquals(1, g.addPlayerToGame("Rosie"));
//		assertEquals(1, g.addPlayerToGame("Cantrip"));
//		assertEquals(1, g.addPlayerToGame("Ronnie"));
//		assertEquals(0, g.addPlayerToGame("Annie"));
//		
//	}
//	
//	@Test
//	public void test_removePlayerFromGame_returns_true_when_player_is_present() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Hana");
//		g.addPlayerToGame("Marc");
//		assertTrue(g.removePlayerFromGame("Alexis"));
//		assertTrue(g.removePlayerFromGame("Hana"));
//		assertTrue(g.removePlayerFromGame("Marc"));
//	}
//	
//	@Test
//	public void test_removePlayerFromGame_returns_false_when_player_is_not_present() {
//		g.addPlayerToGame("Alexis");
//		g.addPlayerToGame("Hana");
//		g.addPlayerToGame("Marc");
//		assertFalse(g.removePlayerFromGame("Rosie"));
//		assertTrue(g.removePlayerFromGame("Alexis"));
//		assertFalse(g.removePlayerFromGame("Cantrip"));
//	}

}
