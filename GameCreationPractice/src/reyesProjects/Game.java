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
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Game extends JFrame
{
	public final static int SCREEN_WIDTH = 900, SCREEN_HEIGHT = 600; 
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
	public static void main(String[] args)
	{
		Game game = new Game();
	}
}
