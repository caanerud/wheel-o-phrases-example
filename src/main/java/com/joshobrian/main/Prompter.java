package com.joshobrian.main;

import java.util.Scanner;

/**
 * Created by josh on 4/6/17.
 */
public class Prompter {
	private Scanner scanner;

	public Prompter(Scanner scanner){
		this.scanner = scanner;
	}
	public void getTitle(){
		System.out.println("\n\n-- Welcome to Wheel-O-Phases --\n\n");
	}

	public void promptForGame(int wager){
		System.out.printf("%nWager Amount: $%s%n", wager);
		System.out.print("\nPlease guess a letter: ");
	}

	public char guess(){
		return scanner.next().charAt(0);
	}

	public void showCurrentStatus(int incorrectCount,int totalCount,int money){
		System.out.printf("\n++++++++++++++++++++++++++++++++++\n");
		System.out.printf("Incorrect Guess Count: %s%n", incorrectCount);
		System.out.printf("Total Guess Count: %s%n", totalCount);
		System.out.printf("Amount in Bank: $%s%n", money);
		System.out.printf("\n++++++++++++++++++++++++++++++++++");
	}
}
