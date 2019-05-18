/*
 * File name: AsteroidsShip.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 14, 2019
 * Time: 8:08:27 PM
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This class represents the ship from the famous arcade game Asteroids. This particle will rotate left and right and 
 * only move in the forward direction. If the down button is pressed, it will shoot.
 * 
 * @author Michael J. Reyes
 *
 */
public class AsteroidsShip extends ControllableParticleWrapBounds 
{
	private double angleFacing;
	private boolean thrusting, turningLeft, turningRight, shooting;
	private Particle[] bullets;
	Particle bullet;
	
	public AsteroidsShip(RadAsteroidsGame game, double xPos, double yPos, Color particleColor, double particleDiameter, int upButton, int downButton, int leftButton, int rightButton) 
	{
		super(game, xPos, yPos, particleColor, particleDiameter, upButton, downButton, leftButton, rightButton);
		angleFacing = 0;
		thrusting = false;
		turningLeft = false;
		turningRight = false;
		shooting = false;
		bullet = null;
		bullets = new Particle[6]; //TODO I could probably do with creating a AsteroidsBullet class so that I can check for collisions/out of bounds and other mechanics of the bullets there.
		//TODO I need to make a Bullet manager class in order to draw the bullets/etc. This needs to be in the Screen class!
	}
	
	public void update()
	{
		super.update();
		checkInputs();
	}
	
	public void checkInputs()
	{
		if(turningLeft == true)
		{
			angleFacing -= 0.05;
		}
		if(turningRight == true)
		{
			angleFacing += 0.05;
		}
		
		getAcceleration().setAngle(angleFacing);
		if(thrusting == true)
		{
			getAcceleration().setLength(0.1);
		}
		else
		{
			getAcceleration().setLength(0);
		}
		if(shooting == true)
		{
			//TODO Make it shoot particles!
			//I can either make a new bullet by adding one to an array of bullets in the screen class, using game.getScreeen()...
			//Or I can have a getter for the boolean shooting variable so that the screen class can check if the ship is shooting, where it would then create a new bullet on its own.
		}
	}
	
	public void keyPressed(int keyCode) {
		if(keyCode == getUpButton())
		{
			thrusting = true;
		}
		if(keyCode == getDownButton())
		{
			shooting = true;
		}
		if(keyCode == getLeftButton())
		{
			turningLeft = true;
		}
		if(keyCode == getRightButton())
		{
			turningRight = true;
		}
	}

	public void keyReleased(int keyCode) {
		if(keyCode == getUpButton())
		{
			thrusting = false;
		}
		if(keyCode == getDownButton())
		{
			shooting = false;
		}
		if(keyCode == getLeftButton())
		{
			turningLeft = false;
		}
		if(keyCode == getRightButton())
		{
			turningRight = false;
		}
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.rotate(angleFacing, getPosition().getxPos(), getPosition().getyPos());
		
		g2D.setColor(getParticleColor());
		g2D.fillOval((int)getPosition().getxPos(), (int)(getPosition().getyPos()), 2, 2);
		//getPosition().getxPos()
		g2D.drawLine((int)(getPosition().getxPos()-getParticleDiameter()/2), (int)(getPosition().getyPos()-getParticleDiameter()/2), (int)(getPosition().getxPos()+getParticleDiameter()/2), (int)(getPosition().getyPos()));
		g2D.drawLine((int)(getPosition().getxPos()-getParticleDiameter()/2), (int)(getPosition().getyPos()+getParticleDiameter()/2), (int)(getPosition().getxPos()+getParticleDiameter()/2), (int)(getPosition().getyPos()));
		g2D.drawLine((int)(getPosition().getxPos()-getParticleDiameter()/2), (int)(getPosition().getyPos()-getParticleDiameter()/2), (int)(getPosition().getxPos()-getParticleDiameter()/2), (int)(getPosition().getyPos()+getParticleDiameter()/2));

		if(thrusting == true)
		{
			g2D.setColor(Color.RED);
			g2D.drawLine((int)(getPosition().getxPos()-getParticleDiameter()/2), (int)(getPosition().getyPos()), (int)(getPosition().getxPos()-getParticleDiameter()), (int)(getPosition().getyPos()));
		}
	}

}
