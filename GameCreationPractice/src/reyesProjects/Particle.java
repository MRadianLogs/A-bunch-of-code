/*
 * File name: Particle.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 13, 2019
 * Time: 12:11:19 AM
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents a physics particle, which contains vectors for position and velocity. This class is 
 * based on the design in the Coding Math Youtube tutorial.
 * 
 * @author Michael J. Reyes
 *
 */
public class Particle 
{
	Vector position, velocity;
	
	public Particle()
	{
		position = new Vector(0,0, false);
		velocity = new Vector(0,0, false);
	}
	
	public Particle(double xPos, double yPos, double speed, double direction)
	{
		position = new Vector(xPos, yPos, false);
		velocity = new Vector(direction, speed, true);
	}
	
	public void update()
	{
		position.addTo(velocity);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval((int)position.getxPos(), (int)position.getyPos(), 25, 25);
	}
}
