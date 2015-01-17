// Program: Deck
// This programs creates another ADT called 'Deck' that contains 52 instances of 'Card', simply put.
// Author: Rob Cary
// Collaborators: None

import java.util.*;

public class Deck
{
	private ArrayList<Card> thedeck;
	private String[] r = {"a","2","3","4","5","6","7","8","9","t","j","q","k"}; // All the card ranks.
	private String[] s = {"d","h","s","c"}; // All the card suits.
	
	public Deck()
	{
		thedeck = new ArrayList<Card>(52); // I understand that the (52) is not necessary...but I like to see it there!
		
		for (int a = 0; a <= 3; a++) // 4 suits
		{
			for (int b = 0; b <= 12; b++) // 13 ranks for each suit!
			{
				thedeck.add(new Card(r[b],s[a]));
			}
		}
	}
	
	public String toString() // Again with the toString...
	{
		String[] strArray = new String[thedeck.size()];
		String deckStr = ("The Deck\n" + "--------\n");
		
		
		for (int j = 0; j < thedeck.size(); j++)
		{
			strArray[j] = thedeck.get(j).toString();
			deckStr += (strArray[j] + "\n");
		}
		
		return deckStr;
	}
	
	public Card getTopCard() // Draws the top card from the bottom of the deck.
	{
		Card temp = thedeck.get(thedeck.size()-1);
		thedeck.remove(thedeck.size()-1);
		
		return temp;
	}
	
	public void shuffle() // Takes 80 random pairs and switches them!
	{
		Random shuffler = new Random();
		Card temp;
		int i1, i2;
		
		for (int i = 0; i < 80; i++)
		{
			i1 = shuffler.nextInt(thedeck.size()-1);
			i2 = shuffler.nextInt(thedeck.size()-1);
			
			temp = (Card) thedeck.get(i2);
			thedeck.set(i2,thedeck.get(i1));
			thedeck.set(i1,temp);
		}
	}
}