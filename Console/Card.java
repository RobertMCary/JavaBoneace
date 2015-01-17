// Program: Card
// This program creates an ADT called 'Card' and its necessary fields and methods.
// Programmer: Rob Cary
// Collaborators: None

import java.util.*;

public class Card
{
	private String s; // Card's suit
	private String r; // Card's rank
	private String p; // Card's picture name
	
	public Card(String rank,String suit) // Simple constructor that accepts a rank and a suit.
	{
		this.s = suit;
		this.r = rank;
		this.p = ("cards/" + (r+s) + ".gif");
	}
	
	public void setS(String suit) // Set the suit.
	{
		s = suit;
	}
	
	public void setR(String rank) // Set the rank.
	{
		r = rank;
	}
	
	public void setP(String picName) // Set the picture name.
	{
		p = picName;
	}
	
	public String getS() // Get the suit.
	{
		return s;
	}
	
	public String getR() // Get the rank.
	{
		return r;
	}
	
	public String getP() // Get the picture name.
	{
		return p;
	}
	
	public String toString() // the requisite toString function!
	{
		return (r+s);
	}
	
	public boolean equals(Card card2) // Sees if two cards are equal, checking both suit and rank.
	{
		boolean chk = false;
		
		if (this.s == card2.s && this.r == card2.r)
		{
			chk = true;
			return chk;
		} else {
			return chk;
		}
	}
}