/*
 * File name: RAScreen.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 16, 2019
 * Time: 1:50:27 PM
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
 * This class represents the screen of the RA game. It controls all the mechanics of the game and what displays on the screen.
 * 
 * @author Michael J. Reyes
 *
 */
public class RAScreen extends JPanel implements ActionListener, KeyListener
{
	private RadAsteroidsGame game;
	private AsteroidsShip ship1;
	private AsteroidsShip ship2;
	private Particle[] asteroids;
	private Particle[] shipBullets;
	
	
	public RAScreen(RadAsteroidsGame game)
	{
		setupGameEngine(game);
		setupGameComponents();
	}
	
	public void setupGameEngine(RadAsteroidsGame game)
	{
		setBackground(Color.BLACK);
		//Maybe use a picture for background?
		this.game = game;
		Timer timer = new Timer(5, this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void setupGameComponents()
	{
		ship1 = new AsteroidsShip(game, game.getWidth()/2 - 30, game.getHeight()/2, Color.BLUE, 25, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
		ship2 = new AsteroidsShip(game, game.getWidth()/2 + 30, game.getHeight()/2, Color.RED, 25, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		asteroids = new Particle[5];
		shipBullets = new Particle[20];
	}

	public void update()
	{
		ship1.update();
		ship2.update();
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
		ship1.keyPressed(e.getKeyCode());
		ship2.keyPressed(e.getKeyCode());
	}
	
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		ship1.keyReleased(e.getKeyCode());
		ship2.keyReleased(e.getKeyCode());
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
		ship1.paint(g);
		ship2.paint(g);
		//Maybe related or dif. bug: red ship sometimes has weird bounds.
	}
	
}
