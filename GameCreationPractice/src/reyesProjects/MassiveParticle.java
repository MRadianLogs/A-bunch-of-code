/*
 * File name: massiveParticle.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 15, 2019
 * Time: 7:15:12 PM
 */
package reyesProjects;

import java.awt.Color;

/**
 * This class represents a spcecialized particle that has mass as an attribute. With its mass, a particle can 
 * gravitate towards other particles and have its acceleration affected. This is done by calculating the gravity 
 * vector between the two massive particles. The angle of the gravity vector is found by calculating the angle 
 * between the two massive particles. The length of the gravity vector is found by using the formula, 
 * length  = m / distanceBetween^2. This distance between the particles is calculated using the distance 
 * formula of the pythagorean theorem.
 * 
 * @author Michael J. Reyes
 *
 */
public class MassiveParticle extends Particle
{
	private double mass;
	
	public MassiveParticle(double xPos, double yPos, double speed, double direction, double xAcceleration, double yAcceleration, Color particleColor, double particleDiameter, double mass)
	{
		super(xPos, yPos, speed, direction, xAcceleration, yAcceleration, particleColor, particleDiameter);
		this.mass = mass;
	}
	
	public double getMass()
	{
		return mass;
	}
	
	public void setMass(double newMass)
	{
		this.mass = newMass;
	}
	
	//Another class or the screen would be in charge of having certain particles gravitate towards others.
//	public void update()
//	{
//		super.update();
//		gravitateTo....
//	}
	
	public double angleTo(Particle otherParticle)
	{
		return Math.atan2(otherParticle.getPosition().getyPos()-this.getPosition().getyPos(), otherParticle.getPosition().getxPos()-this.getPosition().getxPos());
	}
	
	public double distanceTo(Particle otherParticle)
	{
		double dx, dy;
		dx = otherParticle.getPosition().getxPos() - this.getPosition().getxPos();
		dy = otherParticle.getPosition().getyPos() - this.getPosition().getyPos();
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public void gravitateTo(MassiveParticle otherParticle)
	{
		//Vector gravity = new Vector(0,0, false);
		double distanceBetween = this.distanceTo(otherParticle);
		//gravity.setLength(otherParticle.getMass()/(distanceBetween*distanceBetween));
		//gravity.setAngle(this.angleTo(otherParticle));
		
		//this.getVelocity().addTo(gravity);
//		Maybe adjust accelerationVector directly? Will this not work with particles that already have an acceleration? Yes. But will I need to use such an event?
		this.getAcceleration().setLength(otherParticle.getMass()/(distanceBetween*distanceBetween));
		this.getAcceleration().setAngle(this.angleTo(otherParticle));
	}
}
