/*
 * File name: Game.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Jul 9, 2017
 */
package reyesProjects;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * This is my first attempt at experimenting with the various aspects of game development. I created this class once I 
 * learned how to animate graphics and code to a screen, specifically a JFrame. 
 * This class is essentially a game physics engine, where I can easily input new game development ideas or entities to 
 * test them in various ways. 
 *
 * @author Michael Jesus Reyes
 *
 */
public class Game extends JFrame
{
	public final static int SCREEN_WIDTH = 1920, SCREEN_HEIGHT = 1080; 
	private Screen screen;
	
	public Game()
	{
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setBackground(Color.BLACK);
		setTitle("Game!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		screen = new Screen(this);
		add(screen);
		setVisible(true);
	}
	
	public Screen getScreen()
	{
		return screen;
	}
	
	public int getScreenWidth()
	{
		return SCREEN_WIDTH;
	}
	
	public int getScreenHeight()
	{
		return SCREEN_HEIGHT;
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
	}
}
