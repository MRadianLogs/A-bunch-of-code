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
	private Vector position, velocity, acceleration;
	private Color particleColor;
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
	
	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public Vector getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector acceleration) {
		this.acceleration = acceleration;
	}

	public Color getParticleColor() {
		return particleColor;
	}

	public void setParticleColor(Color particleColor) {
		this.particleColor = particleColor;
	}

	public double getParticleDiameter() {
		return particleDiameter;
	}

	public void setParticleDiameter(double particleDiameter) {
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
