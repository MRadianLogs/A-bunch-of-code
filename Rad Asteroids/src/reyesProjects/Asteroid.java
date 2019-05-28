/*
 * File name: Asteroid.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 26, 2019
 * Time: 7:41:49 PM
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents an Asteroid in my RadAsteroids game. It bounces around in space (the screen) until it collides 
 * with another asteroid, a ship, or a bullet from a ship. If it collides with a bullet, then it will break apart into 
 * many smaller asteroids or be destroyed.
 * 
 * @author Michael J. Reyes
 *
 */
public class Asteroid extends Particle{
	private RadAsteroidsGame game;
	private boolean isHit;
	private int asteroidLevel;

	public Asteroid(RadAsteroidsGame game, double xPos, double yPos, double speed, double direction, double xAcceleration, double yAcceleration, Color particleColor, double particleDiameter,  int asteroidLevel) {
		super(xPos, yPos, speed, direction, xAcceleration, yAcceleration, particleColor, particleDiameter);
		this.game = game;
		this.asteroidLevel = asteroidLevel;
		this.isHit = false;
		this.setParticleDiameter(getParticleDiameter()*asteroidLevel); //Sets the size of the asteroid based on its level. The higher the level, the bigger the asteroid.
	}
	
	public void update()
	{
		super.update();
		breakIfHit();
		checkBounds();
	}
	
	public void checkIfHitBullet(AsteroidsShipBullet bullet)
	{
		//TODO Check if bullets intersect with this asteroid. If so, isHit = true;
		//Is this necessary if we check for each bullet?
		double distance  = Math.sqrt(Math.pow(bullet.getPosition().getxPos()-this.getPosition().getxPos(),2) + Math.pow(bullet.getPosition().getyPos() - this.getPosition().getyPos(), 2));
		if((distance)<=(this.getParticleDiameter()/2 + bullet.getParticleDiameter()/2))
		{
			this.isHit = true;
			
		}
	}
	//Could you combine these two methods into a checkIfCollide(Particle particle) method? Maybe.
	public void checkIfHitAsteroid(Asteroid otherAsteroid) //TODO Need to make accurate collision reactions for when asteroids bounce off one another.
	{
		//Check if collided with another asteroid. If so, reverse velocity?
		double distance  = Math.sqrt(Math.pow(otherAsteroid.getPosition().getxPos()-this.getPosition().getxPos(),2) + Math.pow(otherAsteroid.getPosition().getyPos() - this.getPosition().getyPos(), 2));
		if((distance)<=(this.getParticleDiameter()/2 + otherAsteroid.getParticleDiameter()/2))
		{
			this.getVelocity().setLength(this.getVelocity().getLength()*-1);
			otherAsteroid.getVelocity().setLength(otherAsteroid.getVelocity().getLength()*-1);
		}
	}
	
	public void breakIfHit()
	{
		//TODO If isHit = true, then break asteroid down a level, depending on level. When breaking, it will break apart into many smaller asteroids flying in all directions.
		//This will be done at the AsteroidManager level.
	}
	
	public void checkBounds() //TODO Need to make bounds more accurate.
	{
		if(getPosition().getxPos() > game.getWidth())
		{
			getPosition().setxPos(0);
		}
		if(getPosition().getxPos() < 0)
		{
			getPosition().setxPos(game.getWidth());
		}
		if(getPosition().getyPos() > game.getHeight())
		{
			getPosition().setyPos(0);
		}
		if(getPosition().getyPos() < 0)
		{
			getPosition().setyPos(game.getHeight());
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(getParticleColor());
		g.drawOval((int)getPosition().getxPos(), (int)getPosition().getyPos(), (int)(getParticleDiameter()), (int)(getParticleDiameter()));
	}

}
