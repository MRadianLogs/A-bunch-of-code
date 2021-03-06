/*
 * File name: Ball.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: May 15, 2017
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Ball
{
	private final static int WIDTH = 30, HEIGHT = 30;
	private int xPos, xAccel = 2;
	private int yPos, yAccel = 2;
	
	private Pong game;
	
	public Ball(Pong game)
	{
		this.game = game;
		xPos = game.getWidth()/2;
		yPos = game.getHeight()/2;
	}
	
	public void Update()
	{
		xPos += xAccel; //These lines move the ball
		yPos += yAccel; // based on the accel direction.
		
		checkCollision();
		
		if(xPos < 0) //If the ball hits the left wall (player fails to hit)
		{
			game.getScreen().increaseScore(2); //Increase score of opponent.
			xPos = game.getWidth() / 2; // Restart ball.
			xAccel = -xAccel; // Start ball moving other direction.
		}
		else if( xPos > game.getWidth() - WIDTH) // If ball hits right wall
		{
			game.getScreen().increaseScore(1); //Increase score of opponent.
			xPos = game.getWidth() / 2; // Restart ball.
			xAccel = -xAccel; // Start ball moving other direction.
		}
		else if(yPos < 0 || yPos > game.getHeight() - HEIGHT - 29) //Ball hits floor or ceiling
		{
			yAccel = -yAccel; //Switch directions.
		}
		
		if(game.getScreen().getScore(1) == 10) //If either player gets 10 points, game over, submit winner message.
		{
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Pong", JOptionPane.PLAIN_MESSAGE);
		}
		else if(game.getScreen().getScore(2) == 10)
		{
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Pong", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void checkCollision() //If ball hits paddle
	{
		if(game.getScreen().getPlayer(1).getBounds().intersects(getBounds()) || game.getScreen().getPlayer(2).getBounds().intersects(getBounds()))
		{
			xAccel = -xAccel; //Turn ball around
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(xPos, yPos, WIDTH, HEIGHT);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(xPos, yPos, WIDTH, HEIGHT);
		//g.fillOval(xPos, yPos, WIDTH, HEIGHT); //Draws ball on screen
	}
}
