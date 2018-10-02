/*
 * File name: BAHE.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Nov 11, 2017
 */
package reyesProjects;

import javax.swing.JFrame;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class BAHE extends JFrame
{
	private final static int WIDTH = 800, HEIGHT = 500;
	private BAHEScreen screen;
	
	public BAHE()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Beyond Air Hockey and Evil");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		screen = new BAHEScreen(this);
		add(screen);
		setVisible(true);
	}
	
	public BAHEScreen getScreen()
	{
		return screen;
	}
	
	public static void main(String[] args)
	{
		new BAHE();
	}
}