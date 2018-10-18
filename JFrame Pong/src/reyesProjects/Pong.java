/*
 * File name: Pong.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: May 15, 2017
 */
package reyesProjects;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * This is my first JFrame practice program. I followed somebody else's tutorial code of Pong so that I may learn 
 * the basic mechanics of what allows you to animate objects with a JFrame. That being said, this class is the main 
 * Pong class. It created the JFrame and its attributes and starts the game by creating a screen object. This program 
 * features mechanics such as animation of objects, automatically moving objects, basic collision detection, user key 
 * input for moving objects, and implementing the rules of the game Pong into code.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Pong extends JFrame
{
	public final static int WIDTH = 700, HEIGHT = 450; //Screen Size/Resolution
	private Screen screen;
	
	public Pong()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Ping Pong");
		setBackground(Color.BLACK);
		setResizable(false); //Cannot change screen size when active;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		screen = new Screen(this);
		add(screen);
		setVisible(true);
	}
	
	public Screen getScreen() //Allows access to screen
	{
		return screen;
	}
	
	public static void main(String[] args)
	{
		new Pong();
	}
}
