// Program: Hand
// This program creates a third ADT called 'Hand' that contains some cards and relies on both 'Deck' and 'Card'.
// Author: Rob Cary
// Collaborators: None

import java.util.*;

public class Hand
{
	private ArrayList<Card> myHand;
	
	public Hand() // Basic constructor
	{
		myHand = new ArrayList<Card>(5); // A hand is simply five cards...not an instance of the deck.
	}
	
	public Hand(int numCards)
	{
		myHand = new ArrayList<Card>(numCards); // Constructor that accepts the number of cards to be drawn.
	}
	
	public int handSize()
	{
		return myHand.size();
	}
	
	public void add(Card aCard) // Add a card to your hand.
	{
		myHand.add(aCard);
	}
	
	public boolean isEmpty() // Check to see if your hand is empty or not.
	{
		return myHand.size() == 0;
	}
	
	public void clear() // 'Empty' your hand.
	{
		myHand.clear();
	}
	
	public String toString() // Convert your hand to a convenient string.
	{
		String handStr = ("This hand:\n" + "----------\n");
		for (int k = 0; k < myHand.size(); k++)
		{
			handStr += (myHand.get(k).toString() + "\n");
		}
		return handStr;
	}
	
	public String cardLoc(int i) // Returns the card image location of any card in the player's hand.
	{
		return myHand.get(i).getP();
	}
	
	public int checkScore()
	{
		int total = 0;
		for (int i = 0; i < myHand.size(); i++)
		{
			String r = myHand.get(i).getR();
			if (r == "k" || r == "q" || r == "j" || r == "t") {
				total += 10;
			} else if (r == "a") {
				total += 1;
			} else {
				total += Integer.parseInt(r);
			}
		}
		return total;
	}
}