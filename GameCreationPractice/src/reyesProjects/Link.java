/*
 * File name: Link.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Oct 3, 2018
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents a character like Link from the Legend Of Zelda in the old top down games. He will move in all directions, 
 * have a regular sword attack, a special item attack, and maybe more. I hope to draw a Link-looking sprite using shapes, or even 
 * import some pictures to be used as his graphics. He will also turn to face one of the directions.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Link
{
	private Game game;
	private int up,down,left,right; //Movement Controls
	private int regAttack, specialAttack; //Attack Controls
	
	private Vector position, velocity, acceleration;
	private final static int WIDTH=20, HEIGHT=20;
	private int health;
	private boolean isMoving = false;
	private int speed = 1;
	private int maxSpeed = 3;
	
	public Link(Game game, int xStartPosition, int yStartPosition, int up, int down, int left, int right, int regAttack, int specialAttack)
	{
		
		this.game = game;
		position = new Vector(xStartPosition, yStartPosition, false);
		velocity = new Vector(0,0,false);
		acceleration = new Vector(0,0,false);
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		this.regAttack = regAttack;
		this.specialAttack = specialAttack;
	}
	
	public void update()
	{
		//update vectors
		checkMovement();
		position.addTo(velocity);
		//Check bounds?
		checkBounds();
		//check health?
		System.out.println("Velocity: " + position.getLength()); //Doesnt work for some reason
	}
	
	public void checkMovement()
	{
		if(isMoving == true)
		{
			if(velocity.getLength()<maxSpeed)
			{
				velocity.addTo(acceleration);
			}
		}
		else
		{
			if(position.getLength() > 0)
			{
				velocity.setLength(length);
				position.setLength(0);
			}
			else if(position.getLength() < 0)
			{
				velocity.setLength(1);
			}
			else
			{
				velocity.setLength(0);
			}
		}
	}
	
	public void keyPressed(int keycode)
	{
		if(keycode == up)
		{
			isMoving = true;
			//change accel
			acceleration.setAngle(-Math.PI/2);
			acceleration.setLength(1);
		}
		if(keycode == down)
		{
			isMoving = true;
			//change accel
			acceleration.setAngle(Math.PI/2);
			acceleration.setLength(1);			
		}
		if(keycode == left)
		{
			isMoving = true;
			//change accel
			acceleration.setAngle(Math.PI);
			acceleration.setLength(1);
		}
		if(keycode == right)
		{
			isMoving = true;
			//change accel
			acceleration.setAngle(0);
			acceleration.setLength(1);
		}
	}
	
	public void keyReleased(int keycode)
	{
		if(keycode == up || keycode == down)
		{
			isMoving = false;
			//set accel to zero
			acceleration.setLength(0);
		}
		if(keycode == left || keycode == right)
		{
			isMoving = false;
			//set accel to zero
			acceleration.setLength(0);
		}
	}
	
	public void checkBounds()
	{
		if(position.getxPos()+WIDTH>=game.getScreenWidth())
		{
			position.setxPos(game.getScreenWidth()-WIDTH);
		}
		if(position.getyPos()+HEIGHT>=game.getScreenHeight())
		{
			position.setyPos(game.getScreenHeight()-(HEIGHT*4));
		}
		if(position.getxPos()<=0)
		{
			position.setxPos(0);
		}
		if(position.getyPos()<=0)
		{
			position.setyPos(0);
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect((int)position.getxPos(), (int)position.getyPos(), WIDTH, HEIGHT);
	}
	
}
