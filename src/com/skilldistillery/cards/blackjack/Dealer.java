package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player{
	
	//no more fields
	// no getter for the deck
	private Deck deck;
	
	public Dealer() {
		super();
		deck = new Deck();
	}

	public Card dealCard() {
		return deck.dealCard();
		
	}
}
