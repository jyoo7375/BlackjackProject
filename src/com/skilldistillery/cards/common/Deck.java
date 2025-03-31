package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}
	public int checkDeckSize() {
		return cards.size();
	}
	public Card dealCard() {
		if(checkDeckSize() < 1) {
			return null;
		}
		return cards.remove(0);	
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}

}

