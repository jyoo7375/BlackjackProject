package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
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
	
	public boolean isBlackjack() {
		return hand.isBlackjack();
	}
	public boolean isBust() {
		return hand.isBust();
	}

}
