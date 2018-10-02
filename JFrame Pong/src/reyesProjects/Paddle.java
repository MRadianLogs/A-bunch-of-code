/*
 * File name: Paddle.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: May 15, 2017
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Paddle
{
	private final static int WIDTH = 10, HEIGHT = 60; //Size of paddle
	private int xPos; //Paddles xPos on screen
	private int yPos, yAccel; //Paddle's yPos and yAcceleration
	
	private Pong game;
	private int up, down;
	
	public Paddle(Pong game, int up, int down, int xPos)
	{
		this.game = game;
		this.xPos = xPos;
		yPos = game.getHeight()/2;
		this.up = up;
		this.down = down;
	}
	
	public void update()
	{
		checkAllowedMovement();
	}
	
	private void checkAllowedMovement()
	{
		if(yPos > 0 && yPos < game.getHeight() - HEIGHT - 29) //If racket has room to move
		{
			yPos += yAccel; //Move in direction of acceleration
		}
		else if(yPos == 0) //If racket hits top of screen
		{
			yPos++; // It wont go further?
		}
		else if(yPos == game.getHeight() - HEIGHT - 29) //If racket hits bottom of screen
		{
			yPos--; // It wont go further?
		}
	}
	
	public void keyPressed(int keycode)
	{
		if(keycode == up)
		{
			yAccel = -1;
		}
		else if(keycode == down)
		{
			yAccel = 1;
		}
	}
	
	public void keyReleased(int keycode) //IDK if this works. I can't seem to make sense of it. 
	{
		if(keycode == up || keycode == down)
		{
			yAccel = 0;
		}
	}
	
	//Idk how this works yet/Im not sure why the creator did this.
	public Rectangle getBounds()
	{
		return new Rectangle(xPos, yPos, WIDTH, HEIGHT);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, WIDTH, HEIGHT); //Draws the paddle
	}
}
