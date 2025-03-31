package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player{

	private Deck deck;
	
	public Dealer() {
		super();
		deck = new Deck();
		deck.shuffle();
	}

	public Card dealCard() {
		return deck.dealCard();
		
	}
	
	public void resetDeck() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public void playTurn() {
		while(getHandValue() < 17) {
			Card card = dealCard();
			hit(card);
			System.out.println("Dealer drew " + card);
		}
		System.out.println("Dealer's final total is " + getHandValue());
	}
	
}
