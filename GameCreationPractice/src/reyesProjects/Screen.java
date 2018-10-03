/*
 * File name: Screen.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Jul 17, 2017
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Screen extends JPanel implements ActionListener, KeyListener
{
	private Game game;
	private Person person1;
	private Person person2;
	
	public Screen(Game game)
	{
		setBackground(Color.BLACK);
		this.game = game;
		//person1 = new Person(game, KeyEvent.VK_S, KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D, Color.RED, 50);
		//person2 = new Person(game, KeyEvent.VK_DOWN, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, Color.BLUE, 50);
		Timer timer = new Timer(5,this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public Person getPerson(int personNum)
	{	
		if(personNum == 1)
		{
			return person1;
		}
		else
		{
			return person2;
		}
	}
	
	public void update()
	{
		//person1.update();
		//person2.update();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		update();
		repaint();		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//person1.keyPressed(e.getKeyCode());
		//person2.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//person1.keyReleased(e.getKeyCode());		
		//person2.keyReleased(e.getKeyCode());		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		;		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//person1.paint(g);
		//person2.paint(g);
		
	}
}
