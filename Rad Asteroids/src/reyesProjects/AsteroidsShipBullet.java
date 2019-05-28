/*
 * File name: AsteroidsShipBullet.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 26, 2019
 * Time: 8:26:45 PM
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents a bullet from a ship in my RadAsteroids game. This bullets will be shot at asteroids to break them down.
 * 
 * @author Michael J. Reyes
 *
 */
public class AsteroidsShipBullet extends Particle{
	private boolean isShot;
	
	
	public AsteroidsShipBullet(RadAsteroidsGame game, double xPos, double yPos, double speed, double direction, double xAcceleration, double yAcceleration, Color particleColor, double particleDiameter,  int asteroidLevel) {
		super(xPos, yPos, speed, direction, xAcceleration, yAcceleration, particleColor, particleDiameter);
		isShot = false;
	}
	
	public void update()
	{
		super.update();
		checkIfOffScreen();
	}
	
	public void checkIfCollided(Asteroid asteroid)
	{
		
	}
	
	public void checkIfOffScreen()
	{
		//TODO Checks if the bullet is off the screen. If so, isShot = false. The bullet can be fired again.
	}
	
	public void paint(Graphics g)
	{
		g.setColor(getParticleColor());
		g.fillOval((int)getPosition().getxPos(), (int)getPosition().getyPos(), (int)(getParticleDiameter()), (int)(getParticleDiameter()));
	}
}
