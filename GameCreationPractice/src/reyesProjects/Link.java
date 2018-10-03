/*
 * File name: Link.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Oct 3, 2018
 */
package reyesProjects;

import java.awt.Graphics;

/**
 * This class represents a character like Link from the Legend Of Zelda in the old top down games. He will move in all directions, 
 * have a regular sword attack, a special item attack, and maybe more. I hope to draw a Link-looking sprite using shapes, or even 
 * import some pictures to be used as his graphics. He will also turn to face one of the directions.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Link
{
	private Game game;
	private int up,down,left,right; //Controls
	
	private Vector position, velocity, acceleration;
	private final static int WIDTH=20, HEIGHT=20;
	private int health;
	
	public Link(Game game)
	{
		this.game = game;
	}
	
	public void update()
	{
		
	}
	
	public void keyPressed()
	{
		
	}
	
	public void keyReleased()
	{
		
	}
	
	public void paint(Graphics g)
	{
		
	}
	
}
