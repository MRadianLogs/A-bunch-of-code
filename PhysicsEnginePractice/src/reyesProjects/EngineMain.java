/*
 * File name: EngineMain.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Sep 29, 2018
 */
package reyesProjects;

import javax.swing.JFrame;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class EngineMain extends JFrame
{
	private static int WIDTH = 1920, HEIGHT = 1080;
	private EngineScreen screen;
	
	public EngineMain()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Physics Engine Testing");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		screen = new EngineScreen(this);
		add(screen);
		setVisible(true);
	}
	
	public EngineScreen getScreen()
	{
		return screen;
	}
	
	public int getWidth()
	{
		return WIDTH;
	}
	
	public int getHeight()
	{
		return HEIGHT;
	}
	
	public static void main(String[] args)
	{
		EngineMain test = new EngineMain();
	}
}
