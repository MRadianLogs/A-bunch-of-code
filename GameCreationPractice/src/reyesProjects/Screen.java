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
 * This class sets up what happens on the screen of a game. It sets up the JFrame screen and controls how 
 * everything on that screen works. I should consider using inheritance to make setting up the active game easier.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Screen extends JPanel implements ActionListener, KeyListener
{
	private Game game;
	
	//First game stuff
	private Person person1;
	private Person person2;
	
	//Test Player with vector stuff
	private Link link;
	
	private Vector position, velocity;
	private Particle mikeParticle;
	
	private Particle[] firework;
	private int numFireworkBursts = 1000;
	
	public Screen(Game game)
	{	
		setupGameEngine(game);
		
		//setupFirstGame();
		//setupVectorPractice();
		setupParticlePractice();
		//setupTestPlayerWithVector();
	}
	
	public void setupGameEngine(Game game)
	{
		setBackground(Color.BLACK);
		this.game = game;
		Timer timer = new Timer(5,this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);	
	}
	
	public void setupTestPlayerWithVector()
	{
		link = new Link(game, 50, 50,KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_COMMA, KeyEvent.VK_PERIOD);
	}
	
	public void setupFirstGame()
	{
		person1 = new Person(game, KeyEvent.VK_S, KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D, Color.RED, 50);
		person2 = new Person(game, KeyEvent.VK_DOWN, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, Color.BLUE, 50);
	}
	
	public void setupVectorPractice()
	{
		CMVector testCMVector = new CMVector(10, 5);
		CMVector test2CMVector = new CMVector(3, 4);
		CMVector test3CMVector = testCMVector.add(test2CMVector);
		
		Vector testMyVector = new Vector(0.4636476090008061, 11.180339887498949, true);
		Vector test2MyVector = new Vector(3, 4, false);
		Vector test3MyVector = testMyVector.add(test2MyVector);
		
		//System.out.println("After calculations");
		System.out.println("Coding Math Vector: ");
//		System.out.println(test3CMVector.getXValue());
//		System.out.println(test3CMVector.getYValue());
//		System.out.println(test3CMVector.getAngle());
//		System.out.println(test3CMVector.getLength());
//		test3CMVector = test3CMVector.multiply(2);
				
		System.out.println("After calculations");
		System.out.println(testCMVector.getXValue());
		System.out.println(testCMVector.getYValue());
		System.out.println(testCMVector.getAngle());
		System.out.println(testCMVector.getLength());
		
		System.out.println();
		System.out.println("My Vector: ");
//		System.out.println(test3MyVector.getxPos());
//		System.out.println(test3MyVector.getyPos());
//		System.out.println(test3MyVector.getAngle());
//		System.out.println(test3MyVector.getLength());
//		test3MyVector = test3MyVector.multiply(2);
				
		System.out.println(testMyVector.getxPos());
		System.out.println(testMyVector.getyPos());
		System.out.println(testMyVector.getAngle());
		System.out.println(testMyVector.getLength());
	}
	
	public void setupParticlePractice()
	{
		position = new Vector(100, 100, false);
		velocity = new Vector(Math.PI/6, 1, true);
		
		mikeParticle = new Particle(100, 100, 3, Math.PI/6);
		
		firework = new Particle[numFireworkBursts];
		for(int i = 0; i < firework.length; i++)
		{
			firework[i] = new Particle(game.getWidth()/2, game.getHeight()/2, Math.random()*4+1, Math.random()*Math.PI*2);
		}
	}
	
	public Game getGame()
	{
		return game;
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
		//updateFirstGame();
		//updateTestPlayerWithVector();
		updateParticlePractice();
	}
	
	public void updateFirstGame()
	{
		person1.update();
		person2.update();
	}
	
	public void updateParticlePractice()
	{
		//Update particle
		position.addTo(velocity);
		
		mikeParticle.update();
		
		for(int i = 0; i < firework.length; i++)
		{
			firework[i].update();
		}
	}
	
	public void updateTestPlayerWithVector()
	{
		link.update();
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
		//firstGameKeyPressed(e);
		//testPlayerWithVectorKeyPressed(e);
	}
	
	public void firstGameKeyPressed(KeyEvent e)
	{
		person1.keyPressed(e.getKeyCode());
		person2.keyPressed(e.getKeyCode());
	}
	
	public void testPlayerWithVectorKeyPressed(KeyEvent e)
	{
		link.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//firstGameKeyReleased(e);
		//testPlayerWithVectorKeyReleased(e);
	}
	
	public void firstGameKeyReleased(KeyEvent e)
	{
		person1.keyReleased(e.getKeyCode());		
		person2.keyReleased(e.getKeyCode());				
	}
	
	public void testPlayerWithVectorKeyReleased(KeyEvent e)
	{
		link.keyReleased(e.getKeyCode());
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
		//paintFirstGame(g);
		//paintTestPlayerWithVector(g);
		paintParticlePractice(g);
	}
	
	public void paintFirstGame(Graphics g)
	{
		person1.paint(g);
		person2.paint(g);
	}
	
	public void paintParticlePractice(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval((int)position.getxPos(), (int)position.getyPos(), 20, 20);
		
		mikeParticle.paint(g);
		for(int i = 0; i < firework.length; i++)
		{
			firework[i].paint(g);
		}
	}
	
	public void paintTestPlayerWithVector(Graphics g)
	{
		link.paint(g);
	}
}
