package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand{
	
	
	//No fields

	@Override
	public int getHandValue() {
		int value = 0;
		for(Card card : cardsInHand) {
			value += card.getValue();
		}
		return value;
	}
	
	public boolean isBlackjack() {
		if(getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		if(getHandValue() > 21) {
			return true;
		} else {
			
			return false;
		}
	}


}
