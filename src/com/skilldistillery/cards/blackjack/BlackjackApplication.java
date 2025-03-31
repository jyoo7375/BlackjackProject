package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class BlackjackApplication {

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
		boolean playAgain = true;
		
		while(playAgain) {
			playRound();
			
			System.out.println("Would you like to play another round? yes or no?");
			String reply = sc.next();
			if(reply.equalsIgnoreCase("yes")) {
				resetHands();
			} else {
				playAgain = false;
				System.out.println("Thank you for playing!");
			}
		}
		
		sc.close();
	}
	
	private void playRound() {
		dealInitialPlayerCards();
		dealInitialDealerCards();
		playerTurn();

		System.out.println("Dealer's Turn");
		dealer.playTurn();
		determineWinner();
		
	}

	private void dealInitialPlayerCards() {
		int numCards = 2;
		for (int i = 0; i < numCards; i++) {
			Card playerCard = dealer.dealCard();
			player.hit(playerCard);
			System.out.println("Your " + playerCard);
		}
		System.out.println("Your hand total is " + player.getHandValue());
	}

	private void dealInitialDealerCards() {
		Card dealerCard1 = dealer.dealCard();
		Card dealerCard2 = dealer.dealCard();
		dealer.hit(dealerCard1);
		dealer.hit(dealerCard2);
		System.out.println("Dealers cards:");
		System.out.println(dealerCard1);
		System.out.println("[Hidden]");
		System.out.println("Dealers score is " + dealerCard1.getValue() + " with one card showing");
	}

	private void playerTurn() {
		String reply = "";
		if (player.isBlackjack()) {
			System.out.println("You got a blackjack!");
		}
		while (!reply.equalsIgnoreCase("Stay") && player.getHandValue() < 21) {
			System.out.println("Would you like to Hit or stay?");
			reply = sc.next();
			if (reply.equalsIgnoreCase("Hit")) {
				Card newCard = dealer.dealCard();
				player.hit(newCard);
				System.out.println("You drew " + newCard);
				System.out.println("Your hand total is " + player.getHandValue());
			} else if (!reply.equalsIgnoreCase("Stay")) {
				System.out.println("Hit or Stay?");
			}
		}
	}

	private void determineWinner() {
		int playerTotal = player.getHandValue();
		int dealerTotal = dealer.getHandValue();

		if (player.isBust()) {
			System.out.println("Busted Dealer wins.");
		} else if (dealer.isBust()) {
			System.out.println("Dealer busted. You Win!");
		} else if (playerTotal > dealerTotal) {
			System.out.println("You win!");
		} else if (playerTotal < dealerTotal) {
			System.out.println("Dealer wins!");
		} else {
			System.out.println("Its a tie!");
		}

	}
	
	private void resetHands() {
		player.hand.clear();
		dealer.hand.clear();
		dealer.resetDeck();
	}

}
