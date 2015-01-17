// Program: Boneace31GUI
// This program utilizes the Boneace31 class and plays the game by implementing a GUI that shows the cards, scores, etc.
// Programmer: Rob Cary
// Collaborators: None

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Boneace31GUI extends JFrame
{
	private JLabel[] p = new JLabel[7]; // Array of labels for player's cards. (p = player)
	private JLabel[] c = new JLabel[7]; // Array of labels for comp's cards. (c = comp)
	private JLabel[] stats = new JLabel[7]; // Array of labels for the stats in the middle.
	private JPanel[] pP = new JPanel[7]; // Array of panels for the player's cards. (pP = player Panels)
	private JPanel[] cP = new JPanel[7]; // Array of panels for the comp's cards. (cP = comp Panels)
	private JPanel[] statsP = new JPanel[7]; // Array of panels for the stats in the middle.
	private ImageIcon[] pImage = new ImageIcon[7]; // Array for the player's card pictures.
	private ImageIcon[] cImage = new ImageIcon[7]; // Array for the comp's card pictures.
	private JButton hit, stay; // Buttons for hitting or staying.
	private Boneace31 game; // Instance of the game.
	private static boolean over; // Boolean variable to render the button unusuable.
	
	public Boneace31GUI()
	{
		game = new Boneace31();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,350);
		setResizable(false);
		setLayout(new GridLayout(3,7)); // 3x7 grid with 1st row for comp's cards, 2nd row for the stats, and 3rd row for player's cards.
		
		for (int i = 0; i < 3; i++) // Loop for adding the images of each player's first 3 cards.
		{
			pImage[i] = new ImageIcon(Boneace31.pCardLocation(i));
			cImage[i] = new ImageIcon(Boneace31.cCardLocation(i));
		}
		
		for (int j = 0; j < 7; j++) // Initializes all the labels.
		{
			c[j] = new JLabel();
			if (j < 3) // First three comp cards.
			{
				c[j].setIcon(cImage[j]);
				c[j].setText(null);
			} else {
				c[j].setText(""); // All others blank! Until more cards are played..
			}
			stats[j] = new JLabel();
			p[j] = new JLabel();
			if (j < 3) // First three player cards.
			{
				p[j].setIcon(pImage[j]);
				p[j].setText(null);
			} else {
				p[j].setText("");
			}
		}
		
		stats[0].setText("Player Score:" + Boneace31.returnPScore()); // First panel in second row for player score.
		stats[1].setText("Comp Score:" + Boneace31.returnCScore()); // Sceond panel for comp score.
		stats[3].setIcon(new ImageIcon("cards/b.gif"));	 // The 'deck'...
		hit = new JButton("Hit me!");
		hit.addActionListener(new HitListener());
		stay = new JButton("I'll stay.");
		stay.addActionListener(new StayListener());
		
		for (int k = 0; k < 7; k++) // Add the panels by row. This row, computer cards.
		{
			cP[k] = new JPanel();
			if (k < 3) // Add only the first three!
				cP[k].add(c[k]);
				add(cP[k]);
		}
		
		for (int k = 0; k < 7; k++) // All the stats stuff (scores, deck, etc.)
		{
			statsP[k] = new JPanel();
			if (k == 5) {
				statsP[k].add(hit);
			} else if (k == 6) {
				statsP[k].add(stay);
			} else {
				statsP[k].add(stats[k]);
			}
			add(statsP[k]);
		}
		
		for (int k = 0; k < 7; k++) // Player cards.
		{
			pP[k] = new JPanel();
			if (k < 3)
				pP[k].add(p[k]);
				add(pP[k]);
		}
		
		setVisible(true); // Arguably the most important step.
	}
	
	private class HitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (over == false) { // If the game isn't already over...
				Boneace31.drawCardP(); // Player draws.
				pImage[Boneace31.playerHandSize()-1] = new ImageIcon(Boneace31.pCardLocation(Boneace31.playerHandSize()-1)); // This and the next two lines
				p[Boneace31.playerHandSize()-1].setIcon(pImage[Boneace31.playerHandSize()-1]); // add the card's image and place it in the next panel.
				pP[Boneace31.playerHandSize()-1].add(p[Boneace31.playerHandSize()-1]);
				stats[0].setText("Player Score:" + Boneace31.returnPScore()); // Refresh the score.
				if (Boneace31.returnPScoreInt() > 31) {
					stats[2].setText("You busted...");
					over = Boneace31.gameOver();
				} else if (Boneace31.returnPScoreInt() == 31) {
					stats[2].setText("31! You win..!");
					over = Boneace31.gameOver();
				}
			}
		}
	}
	
	private class StayListener implements ActionListener // Similar to the last listener.
	{
		public void actionPerformed(ActionEvent e)
		{
			if (over == false)
				while (Boneace31.returnCScoreInt() < 29 || Boneace31.returnCScoreInt() < Boneace31.returnPScoreInt()) {
					Boneace31.drawCardC();
					cImage[Boneace31.compHandSize()-1] = new ImageIcon(Boneace31.cCardLocation(Boneace31.compHandSize()-1));
					c[Boneace31.compHandSize()-1].setIcon(cImage[Boneace31.compHandSize()-1]);
					cP[Boneace31.compHandSize()-1].add(c[Boneace31.compHandSize()-1]);
					stats[1].setText("Comp Score:" + Boneace31.returnCScore());
					if (Boneace31.returnCScoreInt() > 31) {
						stats[4].setText("Comp busted.");
						over = Boneace31.gameOver();
					} else if (Boneace31.returnCScoreInt() == 31) {
						stats[4].setText("Comp got 31...");
						over = Boneace31.gameOver();
					} else if (Boneace31.returnCScoreInt() >= Boneace31.returnPScoreInt()) {
						stats[4].setText("Comp bested you.");
						over = Boneace31.gameOver();
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		String name = JOptionPane.showInputDialog("What is/are your name? Enter 'quit' to exit.");
		if (name.compareToIgnoreCase("Quit") != 0)
		{
			runGame(name);
		} else {
			System.exit(0);
		}
	}
	
	private static void runGame(String name)
	{
		Boneace31GUI bag = new Boneace31GUI();
		bag.setTitle("Welcome to this Game of 31, " + name + ".");
	}
}