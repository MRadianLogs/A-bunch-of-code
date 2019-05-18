/*
 * File name: RadAsteroidsGame.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 16, 2019
 * Time: 1:47:03 PM
 */
package reyesProjects;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * This game represents my version on the classic arcade game Asteroids.
 * 
 * @author Michael J. Reyes
 *
 */
public class RadAsteroidsGame extends JFrame
{
	public final static int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 1000; 
	private RAScreen screen;
	
	public RadAsteroidsGame()
	{
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setBackground(Color.BLACK);
		setTitle("Rad Asteroids!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		screen = new RAScreen(this);
		add(screen);
		setVisible(true);
	}
	
	public RAScreen getScreen()
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
		RadAsteroidsGame game = new RadAsteroidsGame();
	}
}
