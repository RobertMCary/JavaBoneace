// Program: Boneace31Console
// This program plays the game of 31.
// Author: Rob Cary
// Collaborators: None

// Program: Boneace31Console
// This program utilizes the Boneace31 class to play the game on the console.
// Programmer: Rob Cary
// Collaborators: None

import javax.swing.*;

public class Boneace31Console
{
	public static void main(String[] args)
	{
		Boneace31 game = new Boneace31(); // New instance of the game.
		
		game.showPHand(); // Show the player their hand...
		game.showPScore(); // ...and their score.
		
		String input = JOptionPane.showInputDialog("Do you want to stick (s) or hit (h)? "); // Ask to hit or stick.
		
		game.playerTurn(input); // Take their turn based on the input they gave.
		System.out.println(""); // Separate your turn from the computer's turn with a blank line.
		game.compTurn(); // Computer takes its turn (if necessary).
	}
}