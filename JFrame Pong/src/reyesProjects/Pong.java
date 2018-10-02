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
 * <Insert C;ass Description Here>
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
