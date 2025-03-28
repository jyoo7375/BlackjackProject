package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class BlackjackApplication {

	// no more fields
	// no deck type variables at all

	private Scanner sc;
	private Dealer dealer;
	private Player player;

	public BlackjackApplication() {
		this.sc = new Scanner(System.in);
		this.dealer = new Dealer();
		this.player = new Player();
	}

	public static void main(String[] args) {
		new BlackjackApplication().launch();
	}

	public void launch() {
		System.out.println("Welcome to Blackjack");
		int numCards = 2;
		for (int i = 0; i < numCards; i++) {
			Card playerCard = dealer.dealCard();
			player.hit(playerCard);
			System.out.println("Your " + playerCard);
			System.out.println("Your hand total is " + player.gethandValue());
		}
		Card dealerCard1 = dealer.dealCard();
		Card dealerCard2 = dealer.dealCard();
		dealer.hit(dealerCard1);
		dealer.hit(dealerCard2);
		System.out.println("Dealers cards:");
		System.out.println(dealerCard1);
		System.out.println("[Hidden]");
		
		String reply = "";
		
		while(!reply.equalsIgnoreCase("Stay") && player.gethandValue() < 21) {
			System.out.println("Would you like to Hit or stay?");
			reply = sc.next();
			if(reply.equalsIgnoreCase("Hit")) {
				Card newCard = dealer.dealCard();
				player.hit(newCard);
				System.out.println("You drew " + newCard);
				System.out.println("Your hand total is " + player.gethandValue());
			} else if (!reply.equalsIgnoreCase("Stay")) {
		System.out.println("Hit or Stay?");
			}
		}

	}

}
