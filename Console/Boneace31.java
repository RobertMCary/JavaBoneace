// Program: Boneace31
// This program creates an ADT called 'Boneace31' and its necessary fields and methods, which handles the playing of the game.
// Programmer: Rob Cary
// Collaborators: None

import javax.swing.*;

public class Boneace31
{
	private int playerTotal = 0;
	private int compTotal = 0;
	private static boolean over = false;
	private static String cardLoc;
	
	private static Deck theDeck;
	private static Hand playerHand;
	private static Hand compHand;
	
	public Boneace31() // Constructor creates the deck, hands, shuffles, and deals three cards each.
	{
		theDeck = new Deck();
		theDeck.shuffle();
		theDeck.shuffle();
		playerHand = new Hand(3);
		compHand = new Hand(3);
		
		for (int i = 0; i < 3; i++)
		{
			playerHand.add(theDeck.getTopCard());
			compHand.add(theDeck.getTopCard());
		}
	}
	
	public static boolean gameOver() // Determines the game to be over.
	{
		over = true;
		return over;
	}
	
	public static void drawCardP() // Player draws a card.
	{
		playerHand.add(theDeck.getTopCard());
	}
	
	public static int playerHandSize() // Return player's hand as an integer (number of cards).
	{
		return playerHand.handSize();
	}
	
	public static void drawCardC() // Computer draws a card.
	{
		compHand.add(theDeck.getTopCard());
	}
	
	public static int compHandSize() // Return comp's hand as an integer (number of cards).
	{
		return compHand.handSize();
	}
	
	public static String pCardLocation(int i) // Returns the directory of a card in the player's hand indexed at i.
	{
		return playerHand.cardLoc(i);
	}
	
	public static String cCardLocation(int i) // Returns the directory of a card in the computer's hand indexed at i.
	{
		return compHand.cardLoc(i);
	}
	
	public static void showPHand() // Prints player's hand to console.
	{
		System.out.println(playerHand.toString());
	}
	
	public void showPScore() // Prints player's score to console and 'refreshes' it.
	{
		playerTotal = playerHand.checkScore();
		System.out.println(playerTotal);
	}
	
	public static String returnPScore() // Returns the player's score as a string.
	{
		int pT = playerHand.checkScore();
		return Integer.toString(pT);
	}
	
	public static int returnPScoreInt() // Returns the player's score as an integer.
	{
		return playerHand.checkScore();
	}
	
	public void showCHand() // Prints comp's hand to console.
	{
		System.out.println(compHand.toString());
	}
	
	public void showCScore() // Prints comp's score to console and 'refreshes' it.
	{
		compTotal = compHand.checkScore();
		System.out.println(compTotal);
	}
	
	public static String returnCScore() // Returns the comp's score as a string.
	{
		int cT = compHand.checkScore();
		return Integer.toString(cT);
	}
	
	public static int returnCScoreInt() // Returns the comp's score as an integer.
	{
		return compHand.checkScore();
	}
	
	public void playerTurn(String input) // Takes the player's turn (used in the console version).
	{
		while (input.equalsIgnoreCase("h") && over == false)
		{	
			playerHand.add(theDeck.getTopCard());
			playerTotal = playerHand.checkScore();
			System.out.println(playerTotal);
			if (playerTotal > 31) {
				System.out.println("You lose!");
				over = true;
			} else if (playerTotal == 31) {
				System.out.println("31 exactly! Congrats, you win!");
				over = true;
			} else if (input.equalsIgnoreCase("s")) {
				over = true;
			} else {
				input = JOptionPane.showInputDialog("Do you want to stick (s) or hit (h)? ");
			}
		}
	}

	public void compTurn() // Takes the comp's turn (used in the console version).
	{
		while (over == false && playerTotal < 31)
		{	
			compHand.add(theDeck.getTopCard());
			compTotal = compHand.checkScore();
			System.out.println(compTotal);
			if (compTotal == playerTotal) {
				System.out.println("Same cards...The computer wins! Better luck next time.");
				over = true;
			} else if (compTotal > playerTotal && compTotal < 31) {
				System.out.println("The computer wins!");
				over = true;
			} else if (compTotal > 31) {
				System.out.println("Computer busts...you win!");
				over = true;
			} else if (compTotal == 31) {
				System.out.println("Computer got 31...you lose.");
				over = true;
			}
		}
	}
}