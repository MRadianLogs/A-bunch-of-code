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
 * This class represents a physics particle, which contains vectors for position, velocity and acceleration. This class is 
 * based on the design in the Coding Math Youtube tutorial.
 * 
 * @author Michael J. Reyes
 *
 */
public class Particle 
{
	Vector position, velocity, acceleration;
	Color particleColor;
	double particleDiameter;
	
	public Particle()
	{
		position = new Vector(0,0, false);
		velocity = new Vector(0,0, false);
		acceleration = new Vector(0,0, false);
	}
	
	public Particle(double xPos, double yPos, double speed, double direction, double xAcceleration, double yAcceleration, Color particleColor, double particleDiameter)
	{
		position = new Vector(xPos, yPos, false);
		velocity = new Vector(direction, speed, true);
		acceleration = new Vector(xAcceleration, yAcceleration, false); //Should acceleration be entered as a coordinate pair or an angle and speed?
		this.particleColor = particleColor;
		this.particleDiameter = particleDiameter;
	}
	
	public void update()
	{
		velocity.addTo(acceleration);
		position.addTo(velocity);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(particleColor);
		g.fillOval((int)position.getxPos(), (int)position.getyPos(), (int)particleDiameter, (int)particleDiameter);
	}
}
