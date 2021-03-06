/*
 * File name: Ball.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Sep 29, 2018
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Ball
{
	private EngineMain main;
	private final static int RADIUS = 20;
	private Vector position, velocity, gravity; 
	private int centerXPos, centerYPos;
	private Color currentColor;
	
	public Ball(EngineMain main, int startingXPos, int startingYPos, double direction, double speed, double gravityForce)
	{
		this.main = main;
		position = new Vector(startingXPos, startingYPos, false);
		velocity = new Vector(direction, speed, true);
		gravity = new Vector((3*Math.PI)/2, gravityForce, true);
	}
	
	public Vector getPosition()
	{
		return position;
	}
	
	public Vector getVelocity()
	{
		return velocity;
	}

	public int getCenterXPos()
	{
		return centerXPos;
	}

	public int getCenterYPos()
	{
		return centerYPos;
	}

	public Color getCurrentColor()
	{
		return currentColor;
	}

	public void setCurrentColor(Color currentColor)
	{
		this.currentColor = currentColor;
	}

	public static int getRadius()
	{
		return RADIUS;
	}

	public void update()
	{
		currentColor = Color.RED;
		//Calc current centerXPos and centerYPos //Should this be after updating position?
		centerXPos = (int) (position.getxPos() + RADIUS);
		centerYPos = (int) (position.getyPos() + RADIUS);
		
		//move like this
		position.addTo(velocity);
		velocity.addTo(gravity);
		//Check for collisions
		
	}
	
	public void accelerate(Vector acceleration)
	{
		this.getVelocity().addTo(acceleration);
	}
	
	public void checkForWallCollision()
	{
		if(getCenterXPos()+RADIUS >= main.getWidth()) //If ball hits right edge of screen
		{
			//Turn around on x axis.
		}
		if(getCenterXPos()-RADIUS <= 0) //If ball hits left side of screen.
		{
			//Turn around on x axis.
		}
		if(getCenterYPos()-RADIUS <= 0) //If ball hits top of screen.
		{
			//Turn around on y axis.
		}
		if(getCenterYPos()+RADIUS >= main.getHeight()) //If ball hits bottom of screen.
		{
			//Turn around on y axis.
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(currentColor);
		g.fillOval((int)position.getxPos(), (int)position.getyPos(), RADIUS*2, RADIUS*2);
	}
}
