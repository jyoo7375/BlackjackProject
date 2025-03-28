package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	// no more fields
	// no getter for the hand
	protected BlackjackHand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void hit(Card card) {
		this.hand.addCard(card);
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}

}
